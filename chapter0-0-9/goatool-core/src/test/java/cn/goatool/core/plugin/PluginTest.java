
package cn.goatool.core.plugin;


import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


public class PluginTest {

  Map map = new HashMap();



  @Test
  public void test() {
    AlwaysMapPlugin alwaysMapPlugin = new AlwaysMapPlugin();
    Object plugin = alwaysMapPlugin.plugin(map);
    System.out.println(plugin);

    Map temp = (Map) plugin;
    System.out.println(temp.get("Anything"));
  }

  @Test
  public void mapPluginShouldInterceptGet() {
    map = (Map) new AlwaysMapPlugin().plugin(map);
    assertEquals("Always", map.get("Anything"));
  }

  @Test
  public void shouldNotInterceptToString() {
    map = (Map) new AlwaysMapPlugin().plugin(map);
//    assertNotEquals("Always", map.toString());
    assertNotEquals("Always", map.put(1,"11"));
  }



}
