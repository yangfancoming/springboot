package com.goat.M.example01;

/**
 * Created by 64274 on 2018/12/14.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2018/12/14---17:52
 */
public enum RechargeTypeEnum {

    E_BANK(1, "网银"),
    BUSI_ACCOUNTS(2, "商户账号"),
    MOBILE(3,"手机卡充值"),
    CARD_RECHARGE(4,"充值卡");

    private int value;
    private String description;


    RechargeTypeEnum(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public int value() {
        return value;
    }
    public String description() {
        return description;
    }


    public static RechargeTypeEnum valueOf(int value) {
        for(RechargeTypeEnum type : RechargeTypeEnum.values()) {
            if(type.value() == value) {
                return type;
            }
        }
        return  E_BANK;
    }
}
