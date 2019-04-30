#集合框架
    |- - - -  Collection 接口： 单列集合  
        |- - - - List 接口 ： 存储有序、可重复的数据  ---> 存储 象棋 因为棋子中 有重复的
            |- - - - ArrayList 、 LinkedList 、 Vector

          
        |- - - - Set 接口 ： 存储无序、不可重复的数据  --->  存储 每个班级的同学  因为每个同学都是不会重复的
             |- - - - HashSet 、 LinkedHashSet 、 TreeSet       

    |- - - - Map 接口 ： 双列集合  存储键值对
        |- - - - HashMap 、 LinkedHashMap 、 TreeMap、HashTable   

# Java 集合
    集合 其实就是内存中 存储数据的数据结构 可以看成是一个数据的容器 
    
   
    数组优缺点：
    缺点：
        1. 一旦定义 长度不能改变 
        2.对于新增和删除元素效率低
        
    优点：  遍历 效率高


# Collection 接口 

     boolean add(E e) 向集合中添加元素  
     void clear() 	 清空集合    
     boolean contains(Object o)             如果此 collection 包含指定的元素，则返回 true。 
     boolean containsAll(Collection<?> c)   如果此 collection 包含指定 collection 中的所有元素，则返回 true。 
     boolean equals(Object o)  比较此 collection 与指定对象是否相等。 
     int hashCode()  返回此 collection 的哈希码值。 
     boolean isEmpty()  如果此 collection 不包含元素，则返回 true。 
     Iterator<E> iterator()  返回在此 collection 的元素上进行迭代的迭代器。 
     boolean remove(Object o)  从此 collection 中移除指定元素的单个实例，如果存在的话（可选操作）。 
     boolean removeAll(Collection<?> c)  移除此 collection 中那些也包含在指定 collection 中的所有元素（可选操作）。 
     boolean retainAll(Collection<?> c)  仅保留此 collection 中那些也包含在指定 collection 的元素（可选操作）。 
     int size()  返回此 collection 中的元素数。 
     Object[] toArray()  返回包含此 collection 中所有元素的数组。 
      <T> T[] toArray(T[] a) 返回包含此 collection 中所有元素的数组；返回数组的运行时类型与指定数组的运行时类型相同
      
      java8 中新增 方法：
        addAll
        parallelStream
        removeIf
        retainAll
        spliterator
        stream
        

     
               
