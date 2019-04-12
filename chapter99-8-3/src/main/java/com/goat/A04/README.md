# streams分类
     可以从不同的数据源创建stream。
     java collection包中的Collections，Lists，Sets这些类中新增stream()和parallelStream()方法，
     通过这些方法可以创建一个顺序stream（sequential streams）或者一个并发的stream(Parallel streams)。
     并发stream(Parallel streams)更适合在多线程中使用，
     本文先介绍顺序流（sequential streams）在结尾会描述并发stream(Parallel streams)，