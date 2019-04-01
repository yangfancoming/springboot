package com.goat.C.C06.example00;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 64274 on 2019/4/1.
 *
 * @ Description: 服务员
 * @ author  山羊来了
 * @ date 2019/4/1---13:36
 */
public class Waiter {

    private List<Commond> commonds = new ArrayList<>();

    public void addCommond(Commond commond) {
        // TODO 可以做很多事情  记日志等等
        commonds.add(commond);
    }

    public void removeCommond(Commond commond) {
        // TODO 可以做很多事情  记日志等等
        commonds.remove(commond);
    }

    public void Notify() {
        for (Commond commond : commonds) {
            commond.excuteCommond();
        }
    }
}