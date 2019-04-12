package com.goat.B.B04;

/**
 * Created by 64274 on 2019/4/12.
 *
 * @ Description: 门面
 * @ author  山羊来了
 * @ date 2019/4/12---16:04
 */
public class Computer {

    private CPU cpu;
    private Memory memory;
    private Disk disk;

    public Computer(){
        cpu = new CPU();
        memory = new Memory();
        disk = new Disk();
    }

    public void start(){
        System.out.println("Computer start begin");
        cpu.start();
        disk.start();
        memory.start();
        System.out.println("Computer start end");
    }

    public void shutDown(){
        System.out.println("Computer shutDown begin");
        cpu.shutDown();
        disk.shutDown();
        memory.shutDown();
        System.out.println("Computer shutDown end");
    }
}
