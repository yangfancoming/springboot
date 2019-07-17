package com.goat.B.B03.example03;

/**
 * Created by 64274 on 2018/6/26.
 * @author 山羊来了
 * @Description: 代理类
 * @date 2018/6/26---20:54
 */
public class WangPo implements KindWomen {

    //她可以是KindWomen的任何一个女人的代理，只要你是这一类型
    private KindWomen kindWomen;

    //默认的话，是潘金莲的代理
    public WangPo(){
        this.kindWomen = new PanJinLian();
    }

    public WangPo(KindWomen kindWomen){
        this.kindWomen = kindWomen;
    }
    @Override
    public void makeEyesWithMan(){
        this.kindWomen.makeEyesWithMan(); //王婆这么大年龄了，谁看她抛媚眼？！
    }

    @Override
    public void happyWithMan(){
        this.kindWomen.happyWithMan(); //自己老了，干不了，可以让年轻的代替
    }
}
