    
    《第一种解决方案》:
    使用abstract class方式定义Door：
    public abstract class Door {
        abstract void open();
        abstract void close();
        // 新增报警功能
        abstract void alarm();
    }
    
    使用interface方式定义Door：
    public interface Door {
        void open();
        void close();
        // 新增报警功能
        void alarm();
    }

    《第二种解决方案》: 
    我们可以分析：基本上所有的门都有open()和close()这两个方法，所以我们可以将open()和close()这两个方法设计在抽象类中，
    但是报警这种功能不仅仅只有门才会有，我们的其他一些类，比如汽车等，所以我们可以将这种可以高度自定义的行为设计成一个接口，
    如果我们实现了这个接口，只需要定义我们需要的自定义功能即可。

    
    总结：
    其实abstract class表示的是”is a”关系，interface表示的是”like a”关系，大家在选择时可以作为一个依据，
    当然这是建立在对问题领域的理解上的，比如：如果我们认为AlarmDoor在概念本质上是报警器，同时又具有Door的功能，那么上述的定义方式就要反过来了。
 