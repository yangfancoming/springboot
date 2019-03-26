package com.goat.B.B05.example00;

/**
 * Created by 64274 on 2019/3/26.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/3/26---16:57
 */
public abstract class Abstraction {
    private Implementor implementor;

    public Implementor getImplementor() {
        return implementor;
    }

    public void setImplementor(Implementor implementor) {
        this.implementor = implementor;
    }

    protected void operation(){
        implementor.operation();
    }
}