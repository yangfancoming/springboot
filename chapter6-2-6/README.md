#状态机的要素：
    状态机可归纳为4个要素，现态、条件、动作、次态。“现态”和“条件”是因，“动作”和“次态”是果。
    
    1 现态：指当前所处的状态
    2 条件：又称“事件”，当一个条件被满足，将会触发一个动作，或者执行一次状态的迁移
    3 动作：条件满足后执行的动作。动作执行完毕后，可以迁移到新的状态，也可以仍旧保持原状态。动作不是必须的，当条件满足后，也可以不执行任何动作，直接迁移到新的状态。
    4 次态：条件满足后要迁往的新状态。“次态”是相对于“现态”而言的，“次态”一旦被激活，就转换成“现态”。
    
#状态机动作类型：
    进入动作：在进入状态时进行
    退出动作：在退出状态时进行
    输入动作：依赖于当前状态和输入条件进行
    转移动作：在进行特定转移时进行
    
    
    
#    Could not autowire. No beans of 'StateMachine<States, Events>' type found.
     @Autowired
     private StateMachine<States, Events> stateMachine;       
     解决： 是由于 注入的bean的依赖版本  与 springboot 版本 不一致 导致 springboot 不支持 所导致的  
     
     由 <version>2.0.3.RELEASE</version>  换成  <version>1.0.3.RELEASE</version> 就正常使用了
     <version>2.0.3.RELEASE</version> 对应  springboot 2.0.4 
     <version>1.0.3.RELEASE</version> 对应  springboot 1.3.0