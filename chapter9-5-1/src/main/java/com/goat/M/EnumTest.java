package com.goat.M;

/**
 * Created by 64274 on 2018/12/14.
 *
 * @ Description: 使用枚举类 中的 抽象方法 实现 替换多重 if...else 语句 干掉 if else
 * @ Description: 缺陷： 如果传递参数 没在枚举类型中  就不能实现 类似 case中 default 功能
 * @ author  山羊来了
 * @ date 2018/12/14---16:25
 */
public enum EnumTest {  //在枚举里面定义一个抽象方法，每种类型对应各自的具体实现。

    ONE("one") {
        @Override
        public void apply() {
            System.out.println("one");
        }
    },
    TWO("two") {
        @Override
        public void apply() {
            System.out.println("two");
        }
    },
    THREE("three") {
        @Override
        public void apply() {
            System.out.println("three");
        }
    },
    FOUR("four") {
        @Override
        public void apply() {
            System.out.println("four");
        }
    };

    public abstract void apply();

    private String type;

    EnumTest(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

}
