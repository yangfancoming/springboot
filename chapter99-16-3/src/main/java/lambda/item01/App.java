package lambda.item01;

/**
 * Created by Administrator on 2020/1/29.
 *
 * @ Description: lambda 推导过程 5个步骤
 * 1.外部类
 * 2.静态内部类
 * 3.局部内部类
 * 4.匿名内部类
 * 5.lambda 表达式
 * @ author  山羊来了
 * @ date 2020/1/29---17:34
 */
public class App {

    //静态内部类
    static class Like2 implements ILike{
        @Override
        public void lambda() {
            System.out.println("i like lambda2 ");
        }
    }

    public static void main(String[] args) {
        ILike like = new Like();
        like.lambda();

        like = new Like2();
        like.lambda();


        // 局部内部类
        class Like3 implements ILike{
            @Override
            public void lambda() {
                System.out.println("i like lambda3 ");
            }
        }
        like = new Like3();
        like.lambda();

        //匿名内部类
        like = new ILike() {
            @Override
            public void lambda() {
                System.out.println("i like lambda4 ");
            }
        };
        like.lambda();

        //lambda
        like = ()->System.out.println("i like lambda5 ");
        like.lambda();
    }
}
