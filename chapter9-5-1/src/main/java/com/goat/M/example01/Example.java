package com.goat.M.example01;


import org.junit.Test;

/**
 * Created by 64274 on 2018/12/14.
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2018/12/14---17:53
 *
 * 网银充值，8.5折
 * 商户充值，9折
 * 手机充值，没有优惠
 * 点卡充值，收取1%的渠道费
 */
public class Example {


    //  菜逼阶段
    public Double calRecharge1(Double charge ,RechargeTypeEnum type ){
        if(type.equals(RechargeTypeEnum.E_BANK)){
            return charge*0.85;
        }else if(type.equals(RechargeTypeEnum.BUSI_ACCOUNTS)){
            return charge*0.90;
        }else if(type.equals(RechargeTypeEnum.MOBILE)){
            return charge;
        }else if(type.equals(RechargeTypeEnum.CARD_RECHARGE)){
            return charge+charge*0.01;
        }else{
            return null;
        }
    }

    // 菜鸟阶段  缺陷： 不支持 传入 String 类型 匹配 枚举中的 description  只能传入 RechargeTypeEnum 类型
    public Double calRecharge2(Double charge ,RechargeTypeEnum type ){
        switch(type){
            case E_BANK:
                return charge*0.85;
            case BUSI_ACCOUNTS:
                return charge*0.90;
            case MOBILE:
                return charge;
            case CARD_RECHARGE:
                return (charge*0.01) + charge;
            default:
                return null;
        }
    }

    // BUSI_ACCOUNTS  商户充值  9折
    // MOBILE         手机充值  没有优惠
    // CARD_RECHARGE  点卡充值  收取1%的渠道费
    // E_BANK         网银充值  8.5折
    @Test
    public void testEnum() {
        Double aDouble = calRecharge1(1.5, RechargeTypeEnum.E_BANK); //
        System.out.println(aDouble);
    }

    @Test
    public void test() {
        Double aDouble = calRecharge2(1.5,RechargeTypeEnum.E_BANK);
        System.out.println(aDouble);
    }
}
