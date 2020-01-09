package com.goat.B.B06.item06;

import java.util.List;

/**
 * Created by 64274 on 2019/7/17.
 * @ Description: 抽象的组件对象，为组合中的对象声明接口，实现接口的缺省行为
 * @ author  山羊来了
 * @ date 2019/7/17---10:20
 */

public abstract class Component {

    public abstract void businessLogic(String preStr);

    public void addComponent(Component component) {
        throw new UnsupportedOperationException("对象不支持这个功能");
    }
    
    /**
     * 从组合对象中移出某个组件对象
     * @param component 被移出的组件对象
     */
    public void removeComponent(Component component) {
        throw new UnsupportedOperationException("对象不支持这个功能");
    }
    
    /**
     * 返回某个索引对应的组件对象
     * @param index 需要获取的组件对象的索引，索引从0开始
     * @return 索引对应的组件对象
     */
    public Component getComponentren(int index) {
        throw new UnsupportedOperationException("对象不支持这个功能");
    }

    public List<Component> getList(){
        throw new UnsupportedOperationException("对象不支持这个功能");
    }
}
