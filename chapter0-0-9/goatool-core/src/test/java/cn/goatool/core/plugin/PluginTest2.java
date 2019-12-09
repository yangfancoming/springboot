
package cn.goatool.core.plugin;


import org.junit.Test;




public class PluginTest2 {



  @Test
  public void test() {
      MyMybatisPlugin myMybatisPlugin = new MyMybatisPlugin();
      PluginDemo pluginDemo = (PluginDemo)myMybatisPlugin.plugin(new PluginDemo());
      String fly = pluginDemo.fly("11");
      System.out.println(fly);

  }



}
