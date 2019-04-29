package A01_create.example00;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by 64274 on 2019/4/29.
 *
 * @ Description: Callable 与 Runnable 的区别
     （1）Callable规定的方法是call()，而Runnable规定的方法是run().
     （2）Callable的任务执行后可返回值，而Runnable的任务是不能返回值的。
     （3）call()方法可抛出异常，而run()方法是不能抛出异常的。
     （4）运行Callable任务可拿到一个Future对象， Future表示异步计算的结果。
     它提供了检查计算是否完成的方法，以等待计算的完成，并检索计算的结果。
     通过Future对象可了解任务执行情况，可取消任务的执行，还可获取任务执行的结果。
     Callable是类似于Runnable的接口，实现Callable接口的类和实现Runnable的类都是可被其它线程执行的任务。
 * @ author  山羊来了
 * @ date 2019/4/29---15:15
 */
public class App {


    public static void main(String[] args) {
        ThreadDemo td = new ThreadDemo();
        FutureTask<Integer> result = new FutureTask<>(td);  //1.执行 Callable 方式，需要 FutureTask 实现类的支持，用于接收运算结果。
        new Thread(result).start();
        //2.接收线程运算后的结果
        try {
            Integer sum = result.get();  // 这里会等待工作线程的计算结果
            System.out.println(sum);
            System.out.println("------------------------------------");
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }


}
