package A04_synchronize.example1;

/**
 * Created by Brian on 2016/4/11.
 */

public class HasLocalNum {
    public void addI(String username)  {
            int num ;
            if (username.equals("a")) {
                num = 100;
                System.out.println("a set over");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            } else {
                num = 200;
                System.out.println("b set over");
            }
            System.out.println(username + " num= " + num);

    }
}
