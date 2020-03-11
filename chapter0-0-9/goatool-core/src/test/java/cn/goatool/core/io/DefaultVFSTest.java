package cn.goatool.core.io;

import org.junit.Assert;
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


    DefaultVFS defaultVFS = new DefaultVFS();

    String path =  "cn/goatool/core/exception";
    String path2 = "cn/goatool/core/reflect";

    @Test
    public void getPackagePath(){
        String packagePath = defaultVFS.getPackagePath("org.apache.goat.common");
        Assert.assertEquals("org/apache/goat/common", packagePath);
    }

    @Test
    public void getResources() throws IOException {
        List<URL> list = defaultVFS.getResources(path);
        list.forEach(x->System.out.println(x));
    }

    @Test
    public void list2() throws IOException {
        String packagePath = defaultVFS.getPackagePath(path);
        List<String> list = defaultVFS.list(packagePath);
        list.forEach(x->System.out.println(x));
    }

    @Test
    public void list() throws IOException {
        List<URL> urls = defaultVFS.getResources(path2);
        for (URL url : urls) {
            List<String> list = defaultVFS.list(url, path2);
            list.forEach(x->System.out.println(x));
        }
    }

    @Test
    public void isJar() throws IOException {
        List<URL> urls = defaultVFS.getResources(path);
        for (URL url : urls) {
            List<URL> childUrls = defaultVFS.getChildUrls(url, path);
            childUrls.forEach(x->System.out.println(defaultVFS.isJar(x)));
        }
    }

}
