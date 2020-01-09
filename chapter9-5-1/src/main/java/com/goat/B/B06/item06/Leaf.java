package com.goat.B.B06.item06;


/**
 * 叶子对象，叶子对象不再包含其它子对象
 */
public class Leaf extends Component {

    // 节点名称
    private String name;

    // 构造方法 传入叶子名称
    public Leaf(String name) {
        this.name = name;
    }

    /**
     * 叶子节点 只能实现业务方法  其并不具有父类的 crud 方法
     * @param preStr 前缀，主要是按照层级拼接的空格，实现向后缩进
     */
    @Override
    public void businessLogic(String preStr) {
        System.out.println(preStr + "-" + name);
    }

}
