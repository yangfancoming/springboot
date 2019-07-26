

package com.goat.eventbus;


import java.lang.reflect.Method;
import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArraySet;


final class SubscriberRegistry {


    private final ConcurrentMap<Class<?>, CopyOnWriteArraySet<Subscriber>> subscribers = new ConcurrentHashMap<>();

     private final EventBus bus;

    SubscriberRegistry(EventBus bus) {
        this.bus = bus;
    }

    /** Registers all subscriber methods on the given listener object. */
    /** 主要的逻辑是：
     获取这个类中所有用@Subscribe注解的方法，存储到Multimap中。
     遍历Multimap，键为eventType，然后根据这个键，从缓存中获取这个事件对应的订阅者集合。
     获取到之后，判断集合是否为空，如果为空，新建一个集合来存储。

     Set<Entry<String, String>> entrySet = params.entrySet();
     for (Entry<String, String> entry : entrySet) {
         uriBuilder.setParameter(entry.getKey(), entry.getValue());
     }

    */
    void register(Object listener) {
        //根据订阅者找到对应的<EventType,订阅者集合>
        Map<Class<?>, Subscriber> listenerMethods = findAllSubscribers(listener);
        System.out.println(listenerMethods);
        Set<Entry<Class<?>, Subscriber>> entries = listenerMethods.entrySet();
        // 遍历上述映射表并将新注册的观察者映射表添加到全局的subscribers中
        for(Entry<Class<?>, Subscriber> entry: entries){
            Class<?> eventType = entry.getKey();
            Subscriber eventMethodsInListener = entry.getValue();
            CopyOnWriteArraySet<Subscriber> eventSubscribers = subscribers.get(eventType);
            // 如果指定事件对应的观察者列表不存在就创建一个新的
            if (eventSubscribers == null) {
                CopyOnWriteArraySet<Subscriber> newSet = new CopyOnWriteArraySet<>();
                CopyOnWriteArraySet<Subscriber> subscribers = this.subscribers.putIfAbsent(eventType, newSet);
                if (subscribers == null)
                eventSubscribers = newSet;
            }
            eventSubscribers.add(eventMethodsInListener);
        }
    }


    // 它用来获取指定监听者对应的全部观察者集合
    private Map<Class<?>, Subscriber> findAllSubscribers(Object listener) {
        // 创建一个哈希表
        Map<Class<?>, Subscriber> methodsInListener = new HashMap<>();// 这里需要体会 Multimap 与 传统Map 的区别
        // 获取监听者的类型
        Class<?> clazz = listener.getClass();
        // 获取上述监听者的全部监听方法
        Collection<Method> annotatedMethods = getAnnotatedMethods(clazz);
        // 遍历上述方法，并且根据方法和类型参数创建观察者并将其插入到映射表中
        for (Method method : annotatedMethods) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            Class<?> eventType = parameterTypes[0];
            methodsInListener.put(eventType, Subscriber.create(bus, listener, method));
        }
        return methodsInListener;
    }


    //这个执行结果会放入到subscriberMethodsCache本地缓存中，下次同样的Class不用再反射解析，直接从缓存中拿
    private static Collection<Method> getAnnotatedMethods(Class<?> supertype) {
        Map<MethodIdentifier, Method> identifiers = new HashMap<>();
        Method[] declaredMethods = supertype.getDeclaredMethods();
        for (Method method : declaredMethods) {
                //遍历订阅者的每个方法，检查方法上是否有@SubScribe注解
                if (method.isAnnotationPresent(Subscribe.class) && !method.isSynthetic()) {
                    Class<?>[] parameterTypes = method.getParameterTypes();
                    //注解方法只能有一个参数
                    System.out.println(parameterTypes.length == 1);
                    MethodIdentifier ident = new MethodIdentifier(method);
                    if (!identifiers.containsKey(ident)) {
                        identifiers.put(ident, method);
                    }
                }
            }
        Collection<Method> values = identifiers.values();
        System.out.println(values);
        return values ;
    }

}
