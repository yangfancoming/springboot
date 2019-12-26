package com.goat.chapter239.chain;

import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * Created by Administrator on 2019/11/18.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/11/18---11:56
 */
public abstract class Chain {

    // 责任链节点
    private Chain mSuccessor;

    // 设置责任链节点 返回当前对象
    protected Chain setSuccessor(Chain successor) {
        this.mSuccessor = successor;
        return successor;
    }

    // 设置责任链节点 返回当前对象
    protected void clearSuccessor() {
         this.mSuccessor = null;
    }

    // 传递给下一个节点处理
    final ByteArrayInputStream process(ByteArrayInputStream input) throws IOException {
        if (mSuccessor != null) {
            return mSuccessor.handler(input);
        }
        return input;
    }

    // 每个节点处理函数  待具体子类实现
    public abstract ByteArrayInputStream handler(ByteArrayInputStream bytes) throws IOException;
}
