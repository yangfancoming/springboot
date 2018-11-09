
##Quartz和Spring Task定时任务 比较



精确度和功能 

    Quartz可以通过cron表达式精确到特定时间执行，而TimerTask不能。
    Quartz拥有SpringTask所有的功能，而TimerTask则没有。 

任务类的数量 

    Quartz每次执行都创建一个新的任务类对象。
    SpringTask则每次使用同一个任务类对象。 

对异常的处理

    Quartz的某次执行任务过程中抛出异常，不影响下一次任务的执行，当下一次执行时间到来时，定时器会再次执行任务。
    SpringTask不同，一旦某个任务在执行过程中抛出异常，则整个定时器生命周期就结束，以后永远不会再执行定时器任务。
    
    
#总结:还是第三方考虑的周全，东西比较多，加上Quartz配置简单，maven也就是多加一个jar包，所以一般情况下还是使用Quartz了。