package com.goat.concurrency.atomic;

import com.goat.concurrency.annoations.ThreadSafe;
import com.goat.concurrency.model.Girl;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by 64274 on 2019/3/31.
 *
 * @ Description: count.compareAndSet(a,b) 如果count 为 a 则 将count的值 设置成b
 * @ author  山羊来了
 * @ date 2019/3/31---22:41
 */
@ThreadSafe
public class MyAtomicReference{

    private static AtomicReference<Integer> count = new AtomicReference(0);

    @Test
    public void test1()  {
        count.compareAndSet(0, 2); // 如果是 0 则 设置成 2  == 2
        count.compareAndSet(0, 1); // 如果是 0 则 设置成 1  == 不执行
        count.compareAndSet(1, 3); // 如果是 1 则 设置成 3  == 不执行
        count.compareAndSet(2, 4); // 如果是 2 则 设置成 4  == 4
        count.compareAndSet(3, 5); // 如果是 3 则 设置成 5  == 不执行
        System.out.println(count); // 输出 4
    }

    @Test
    public void test2()  {
        AtomicReference<Girl> af = new AtomicReference<>(); // 主存
        Girl girl1 =  new Girl("meila",23);
        Girl girl2 =  new Girl("guai",43);
        af.set(girl1);
        System.out.println(af.compareAndSet(girl1, girl2) + "\t"+ af.get().toString()); // true
        System.out.println(af.compareAndSet(girl1, girl2) + "\t"+ af.get().toString()); // false
    }



}
