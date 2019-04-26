# 享元模式

    优点
          1、享元模式的优点在于它能够极大的减少系统中对象的个数。
          2、享元模式由于使用了外部状态，外部状态相对独立，不会影响到内部状态，所以享元模式使得享元对象能够在不同的环境被共享。
    
    缺点
          1、由于享元模式需要区分外部状态和内部状态，使得应用程序在某种程度上来说更加复杂化了。
          2、为了使对象可以共享，享元模式需要将享元对象的状态外部化，而读取外部状态使得运行时间变长。 
    
    五、 模式适用场景
          1、如果一个系统中存在大量的相同或者相似的对象，由于这类对象的大量使用，会造成系统内存的耗费，可以使用享元模式来减少系统中对象的数量。
          2、对象的大部分状态都可以外部化，可以将这些外部状态传入对象中。
          String常量池
          数据库连接池
          线程池
    
    
    六、 模式总结
          1、享元模式可以极大地减少系统中对象的数量。但是它可能会引起系统的逻辑更加复杂化。
          2、享元模式的核心在于享元工厂，它主要用来确保合理地共享享元对象。
          3、内部状态为不变共享部分，存储于享元享元对象内部，而外部状态是可变部分，它应当油客户端来负责。
          
    7. 注意事项
    注意划分内部状态和外部状态，否则可能会引起线程安全问题
    这些类必须有一个工厂类加以控制