
package cn.goatool.core.plugin;


import org.junit.Test;




public class PluginTest2 {



  @Test
  public void test() {
      MyMybatisPlugin myMybatisPlugin = new MyMybatisPlugin();

      PluginDemo target = new PluginDemo();
      PluginDemo plugin = (PluginDemo)myMybatisPlugin.plugin(target);
      String fly = plugin.fly("11");
      System.out.println(fly);

  }



}
