package com.goat.B.B06.item08;

/**
 * Created by Administrator on 2020/1/9.
 *
 * @ Description: AbstractFile: 抽象文件类，充当抽象构建。
 * @ author  山羊来了
 * @ date 2020/1/9---8:59
 */
public abstract class AbstractFiles {
    public abstract void add(AbstractFiles af);
    public abstract void remove(AbstractFiles af);
    public abstract AbstractFiles get(int  i);
    public abstract void killVirus();
}
