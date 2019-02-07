package com.goat.constant;

/**
 * Created by 64274 on 2019/2/7.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/2/7---13:06
 */
public enum View {
    sql, bad, zhyd, exception, none;

    public static View getView(String view) {
        for (View v : View.values()) {
            if (v.toString().equalsIgnoreCase(view)) {
                return v;
            }
        }
        return none;
    }
}