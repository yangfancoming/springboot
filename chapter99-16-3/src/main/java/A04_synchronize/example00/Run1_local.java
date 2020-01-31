package A04_synchronize.example00;


/**
 * P53例子
 * 方法内局部变量则不存在“非线程安全”问题
 */

public class Run1_local {

    public static void main(String[] args) {
        HasLocalNum numRef = new HasLocalNum();
        ThreadA threadA = new ThreadA(numRef);
        threadA.start();
        ThreadB threadB = new ThreadB(numRef);
        threadB.start();

        System.out.println(threadA.isDaemon());
        System.out.println(threadB.isDaemon());
    }
}


/*
输出：
a set over
b set over
b num= 200
a num= 100
 */