package A04_synchronize.example00;


public class ThreadB extends Thread {

    private HasLocalNum numRef;

    public ThreadB(HasLocalNum numRef) {
        super();
        this.numRef = numRef;
    }

    @Override
    public void run() {
        super.run();
        numRef.addI("b");
    }
}
