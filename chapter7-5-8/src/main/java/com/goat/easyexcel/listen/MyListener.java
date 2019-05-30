package com.goat.easyexcel.listen;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.ArrayList;
import java.util.List;

public class MyListener<T> extends AnalysisEventListener<T> {

    private List<T>  data = new ArrayList<>();

    @Override
    public void invoke(T object, AnalysisContext context) {
        data.add(object);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        doSomething();
    }

    public void doSomething(){
        for (T o:data) {
            System.out.println(o);
        }
    }

    public List<T> getDatas() { return data; }
}
