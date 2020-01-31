package A04_synchronize.example00;


public class ThreadA extends Thread {
    private HasLocalNum numRef;

    public ThreadA(HasLocalNum numRef) {
        super();
        this.numRef = numRef;
    }

    @Override
    public void run() {
        super.run();
        numRef.addI("a");
    }
}
