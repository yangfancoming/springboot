
package cn.goatool.core.plugin;


import cn.goatool.core.io.Resources;
import cn.goatool.core.xml.BaseTest;
import cn.goatool.core.xml.XNode;
import org.junit.Test;

import java.util.List;
import java.util.Properties;


public class PluginTest extends BaseTest {



  @Test
  public void test() {
      MyMybatisPlugin myMybatisPlugin = new MyMybatisPlugin();
      PluginDemo pluginDemo = (PluginDemo)myMybatisPlugin.plugin(new PluginDemo());
      String fly = pluginDemo.fly("11");
      System.out.println(fly);
  }


    @Test
    public void pluginPasing() throws Exception{
       // 获取 <plugins> 节点
        XNode node = common("plugin.xml", "/configuration/plugins");
        // 获取 <plugins> 节点下的所有 <plugin> 子节点
        List<XNode> childrens = node.getChildren();

        InterceptorChain interceptorChain = new InterceptorChain();

        for (XNode child : childrens) {
            // 获取 单个 <plugin>标签下的所有 <property>
            Properties properties = child.getChildrenAsProperties();
            // 获取 <plugin>标签中的 interceptor 属性 ：org.apache.goat.chapter200.D10.MyMybatisPlugin
            String interceptor = child.getStringAttribute("interceptor");
            Class<?> aClass = Resources.classForName(interceptor);
            Interceptor interceptorInstance = (Interceptor) aClass.newInstance();
            // 调用我们自定义的重写的 setProperties() 方法
            // 再拿<plugin>标签下的所有<property>标签，解析name和value属性成为一个Properties，将Properties设置到拦截器中
            interceptorInstance.setProperties(properties);
            interceptorChain.addInterceptor(interceptorInstance);
        }
//        PluginDemo pluginDemo = (PluginDemo)interceptorChain.pluginAll(PluginDemo.class);
        Object o = interceptorChain.pluginAll(PluginDemo.class);
//        String wagagag = pluginDemo.fly("wagagag");
        PluginDemo temp = (PluginDemo)o;
        System.out.println(temp);
    }

}
