#下面的实践有以下特色： 
    1、不同线程启用不同statemachine实例处理 
    2、用工厂模式创建statemachine，且用StateMachinePersist根据recruit对象不同状态反序列化statemachine 
    3、 用message 给OnTransition注解的方法传递对象
