package com.goat.chapter277.model;

import java.util.List;

/**
 * Created by Administrator on 2020/3/19.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/3/19---15:37
 */
public class MyResult extends BaseResult {

    private List<TranslateResult> trans_result;

    public List<TranslateResult> getTrans_result() {
        return trans_result;
    }

    public void setTrans_result(List<TranslateResult> trans_result) {
        this.trans_result = trans_result;
    }

}
