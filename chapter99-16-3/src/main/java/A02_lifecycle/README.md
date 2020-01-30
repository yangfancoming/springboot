#  各种状态一目了然，值得一提的是"blocked"这个状态：

    创建,就绪,运行,阻塞,死亡
    
    线程在Running的过程中可能会遇到阻塞(Blocked)情况
    调用join()和sleep()方法，sleep()时间结束或被打断，join()中断,IO完成都会回到Runnable状态，等待JVM的调度。
    调用wait()，使该线程处于等待池(wait blocked pool),直到notify()/notifyAll()，线程被唤醒被放到锁定池(lock blocked pool )，释放同步锁使线程回到可运行状态（Runnable）
    对Running状态的线程加同步锁(Synchronized)使其进入(lock blocked pool ),同步锁被释放进入可运行状态(Runnable)。
    此外，在runnable状态的线程是处于被调度的线程，此时的调度顺序是不一定的。Thread类中的yield方法可以让一个running状态的线程转入runnable。
    
    
    1. Thread thread = new Thread(); new 出来后 是新生状态
    2. thread.start();   start() 后 是就绪状态(等待cpu调度)