package com.goat.spring.chapter_02.javaconfig;

import com.goat.spring.chapter_02.ICompactDisc;
import com.goat.spring.chapter_02.IMediaPlayer;
import org.springframework.beans.factory.annotation.Autowired;


/**
        不管是构造器、 Setter方法还是其他的方法， Spring都会尝试满足方法
        参数上所声明的依赖。 假如有且只有一个bean匹配依赖需求的话， 那么这个bean将会被装配进来。
        如果没有匹配的bean， 那么在应用上下文创建的时候， Spring会抛出一个异常。
        为了避免异常的出现， 你可以将   @Autowired(required = false)  （默认为true）

        如果有多个bean都能满足依赖关系的话， Spring将会抛出一个异常，
        表明没有明确指定要选择哪个bean进行自动装配。 在第3章中， 我们会进一步讨论自动装配中的歧义性
     * @Date:   2018/7/25
*/
public class MediaPlayerImpl2 implements IMediaPlayer {

    private ICompactDisc cd;

    @Autowired(required = false)
    public MediaPlayerImpl2(ICompactDisc cd) { //这表明当Spring创建CDPlayerbean的时候， 会通过这个构造器来进行实例化并且会传入一个可设置给CompactDisc类型的bean
        this.cd = cd;
    }

    @Override
    public void insert() {
        System.out.println("插入 CD 盘。。。。。11111");
        cd.play();
    }

}
