## 深入解析 ThreadLocal
ThreadLocal类提供的几个方法：
``` java
public T get() { }
public void set(T value) { }
public void remove() { }
protected T initialValue() { }
```
&emsp;&emsp;<font color="red">get()</font>方法用来获取ThreadLocal当前线程中保存的变量副本；<br>
&emsp;&emsp;<font color="red">set()</font>用来设置当前线程中变量的副本；<br>
&emsp;&emsp;<font color="red">remove()</font>用来移除当前线程中变量的副本；<br>
&emsp;&emsp;<font color="red">initialValue()</font>是一个protected方法，一般是用来在使用时进行重写，它是一个延迟加载的方法。<br>
&emsp;&emsp;首先来看下ThreadLocal类是如何为每个线程创建一个变量的副本的。<br>
&emsp;&emsp;先看下get()方法的实现：
``` java
    /**
     * Returns the value in the current thread's copy of this
     * thread-local variable.  If the variable has no value for the
     * current thread, it is first initialized to the value returned
     * by an invocation of the {@link #initialValue} method.
     *
     * @return the current thread's value of this thread-local
     */
    public T get() {
        Thread t = Thread.currentThread();
        ThreadLocalMap map = getMap(t);
        if (map != null) {
            ThreadLocalMap.Entry e = map.getEntry(this);
            if (e != null) {
                @SuppressWarnings("unchecked")
                T result = (T)e.value;
                return result;
            }
        }
        return setInitialValue();
    }
```
&emsp;&emsp;第一句话是取得当前线程，然后通过getMap(t)方法获取一个ThreadLocalMap类型的map，接着获取到该map中的<key,value>键值对，<font color="red">注意这里获取键值对传进去的是this，而不是当前线程t。（？）</font><br>
&emsp;&emsp;如果获取成功，则返回value；<br>
&emsp;&emsp;如果map为空，则调用setInitialValue()方法返回值。<br>
&emsp;&emsp;我们来根据上面的每一句来仔细分析：<br>
&emsp;&emsp;首先看getMap()方法中做了什么：<br>
``` java
    /**
     * Get the map associated with a ThreadLocal. Overridden in
     * InheritableThreadLocal.
     *
     * @param  t the current thread
     * @return the map
     */
    ThreadLocalMap getMap(Thread t) {
        return t.threadLocals;
    }
```
&emsp;&emsp;在getMap(t)方法中，是调用当前线程t，返回当前线程t中的一个成员变量threadlocals，<font color="red">注意：这个threadlocals是Thread中的成员变量，而不是ThreadLocal中</font>。<br>
&emsp;&emsp;那么我们继续看下Thread类中的成员变量threadlocals是什么：<br>
``` java
    /* ThreadLocal values pertaining to this thread. This map is maintained
     * by the ThreadLocal class. */
    ThreadLocal.ThreadLocalMap threadLocals = null;
```
&emsp;&emsp;实际上就是一个ThreadLocalMap，这个类型是ThreadLocal当中的一个静态内部类，我们看下ThreadLocalMap的实现：<br>
``` java
    /**
     * ThreadLocalMap is a customized hash map suitable only for
     * maintaining thread local values. No operations are exported
     * outside of the ThreadLocal class. The class is package private to
     * allow declaration of fields in class Thread.  To help deal with
     * very large and long-lived usages, the hash table entries use
     * WeakReferences for keys. However, since reference queues are not
     * used, stale entries are guaranteed to be removed only when
     * the table starts running out of space.
     */
    static class ThreadLocalMap {

        /**
         * The entries in this hash map extend WeakReference, using
         * its main ref field as the key (which is always a
         * ThreadLocal object).  Note that null keys (i.e. entry.get()
         * == null) mean that the key is no longer referenced, so the
         * entry can be expunged from table.  Such entries are referred to
         * as "stale entries" in the code that follows.
         */
        static class Entry extends WeakReference<ThreadLocal<?>> {
            /** The value associated with this ThreadLocal. */
            Object value;

            Entry(ThreadLocal<?> k, Object v) {
                super(k);
                value = v;
            }
        }
```
&emsp;&emsp;可以看到ThreadLocalMap中的Entry继承了WeakReference，并且使用ThreadLocal作为键值。<br>
&emsp;&emsp;然后再继续看setInitialValue()方法的具体实现：<br>
``` java
    /**
     * Variant of set() to establish initialValue. Used instead
     * of set() in case user has overridden the set() method.
     *
     * @return the initial value
     */
    private T setInitialValue() {
        T value = initialValue();
        Thread t = Thread.currentThread();
        ThreadLocalMap map = getMap(t);
        if (map != null)
            map.set(this, value);
        else
            createMap(t, value);
        return value;
    }
```
&emsp;&emsp;如果map不为空，就设置键值对；为空，再创建Map，跟下去看createMap()的实现：<br>
``` java
    /**
     * Create the map associated with a ThreadLocal. Overridden in
     * InheritableThreadLocal.
     *
     * @param t the current thread
     * @param firstValue value for the initial entry of the map
     */
    void createMap(Thread t, T firstValue) {
        t.threadLocals = new ThreadLocalMap(this, firstValue);
    }
```
&emsp;&emsp;至此，我们可以明白ThreadLocal是如何为每个线程创建变量的副本的：<br>
&emsp;&emsp;首先，每个线程Thread内部有一个Thread.ThreadLocalMap类型的成员变量threadlocals，这个threadlocals就是用来存储实际的变量副本的，键值为当前ThreadLocal变量，value为变量副本（即T类型的变量）。<br>
&emsp;&emsp;初始时，在Thread里面，threadlocals为空，当通过ThreadLocal变量调用get()方法或者set()方法，就会对Thread类中的threadlocals进行初始化，并且以当前ThreadLocal为键值，以ThreadLocal要保存的副本变量为value，存到threadlocals中。<br>
&emsp;&emsp;然后，在当前线程里面，如果要使用副本变量，就可以通过get方法在threadlocals里面查找。<br>
---
&emsp;&emsp;*总结*<br>
&emsp;&emsp;1. 通过ThreadLocal创建的副本是存储在每个线程自己的threadlocals中的；<br>
&emsp;&emsp;2. 为何threadlocals的类型ThreadLocalMap的键值为ThreadLocal对象，因为每个线程中可以有多个ThreadLocal变量，例如ThreadLocal<Student>，ThreadLocal<Teacher>；<br>
&emsp;&emsp;3. 在进行get之前，必须先set，否则会报空指针异常；如果想在调用get之前不调用set就能正常访问的话，必须重写initialValue()方法。
---
