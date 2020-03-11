package cn.goatool.core.io;

import org.junit.Test;

import java.io.IOException;
import java.net.URL;
import java.util.List;

/**
 * Created by Administrator on 2020/3/11.
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/3/11---16:07
 */
public class DefaultVFSTest {

    public DefaultVFSTest() throws IOException {}

    DefaultVFS defaultVFS = new DefaultVFS();

    String path =  "cn/goatool/core/exception";
    String path2 = "cn/goatool/core/reflect";

    // doit 同样的方法为啥 再VFSTest测试类中 就是2个结果  这里运行就是1个结果呢？？？
    @Test
    public void getResources() throws IOException {
        List<URL> list = VFS.getResources(path);
        list.forEach(x->System.out.println(x));
    }

    @Test
    public void list() throws IOException {
        List<URL> urls = VFS.getResources(path2);
        for (URL url : urls) {
            List<String> list = defaultVFS.list(url, path2);
            list.forEach(x->System.out.println(x));
        }
    }

    @Test
    public void isJar() throws IOException {
        List<URL> urls = VFS.getResources(path);
        for (URL url : urls) {
            List<URL> childUrls = defaultVFS.getChildUrls(url, path);
            childUrls.forEach(x->System.out.println(defaultVFS.isJar(x)));
        }
    }

}
