package com.goat.B.B06.item01;

/**
 * Created by 64274 on 2019/7/15.
 *
 * @ Description: Leaf 叶节点对象：叶节点对象没有任何子节点，实现了Component中的某些操作。
 * @ author  山羊来了
 * @ date 2019/7/15---20:53
 */
public class Leaf extends Component {

    public Leaf(String name) {
        super(name);
    }

    @Override
    public void operation() {
        System.out.println("叶节点"+name+"的操作");
    }
}