package A09.demo1;

import java.util.Random;


public class ThreadLocalDemo1 implements Runnable {

    private final static ThreadLocal<Student> STUDENT_THREAD_LOCAL = new ThreadLocal<>();

    public static void main(String[] args) {
        ThreadLocalDemo1 tld = new ThreadLocalDemo1();
        Thread t1 = new Thread(tld, "ThreadLocalDemo3");
        Thread t2 = new Thread(tld, "b");
        t1.start();
        t2.start();
    }

    @Override
    public void run() {
        accessStudent();
    }

    private void accessStudent(){
        //currentThread
        String name = Thread.currentThread().getName();
        System.out.println(name + " is Running!");

        //generate ThreadLocalDemo3 random and print
        int age = new Random().nextInt(100);
        System.out.println("thread " + name + " set age to " + age);

        //set Student age
        Student student = getStudent();
        student.setAge(age);
        System.out.println("thread " + name + " first read age is " + student.getAge());

        try {
            Thread.sleep(500);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("thread " + name + " second read age is " + student.getAge());
    }

    private Student getStudent(){
        //get Student from threadLocal
        Student student = STUDENT_THREAD_LOCAL.get();

        //init student
        if (student == null){
            student = new Student();
            STUDENT_THREAD_LOCAL.set(student);
        }
        return student;
    }

}
