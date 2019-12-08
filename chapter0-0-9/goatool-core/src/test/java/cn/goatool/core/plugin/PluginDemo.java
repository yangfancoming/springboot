package cn.goatool.core.plugin;

/**
 * Created by Administrator on 2019/12/8.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/12/8---20:08
 */
public class PluginDemo {

    public String fly(String name){
        System.out.println("PluginDemo --- fly() ----" + name);
        return name;
    }

    public String cry(String name){
        System.out.println("PluginDemo --- cry() ----" + name);
        return name;
    }

}
