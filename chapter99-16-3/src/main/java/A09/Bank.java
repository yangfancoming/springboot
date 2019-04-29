package A09;

public class Bank {

    // 使用ThreadLocal类来管理共享变量account，并重写initialValue()方法，将account的初始值设为100
    private static ThreadLocal<Integer> account = ThreadLocal.withInitial(()->100);
    
    public void deposit(int money) {
        account.set(account.get() + money);// 利用account的get()、set()方法实现存钱
    }
    
    public int getAccount() {// 获得账户余额
        return account.get();
    }
}
