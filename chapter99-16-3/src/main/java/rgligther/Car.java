package rgligther;

/**
 * Created by 64274 on 2019/4/22.
 *
 * @ Description: 车辆线程
 * @ author  山羊来了
 * @ date 2019/4/22---10:05
 */
public class Car extends Thread{
    String name;
    //灯作为私有变量，车辆根据灯的状态决定是否要停止
    private Lighter lighter;
    public Car(String name,Lighter l){
        this.name=name;
        this.lighter=l;
    }

    @Override
    public void run(){
        if (lighter.state.equals("red")){
            System.out.println(this.name+":等待中");
        }else{
            System.out.println(this.name+":通过了红绿灯");
        }
    }
}