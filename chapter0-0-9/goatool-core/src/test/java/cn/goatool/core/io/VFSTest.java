package cn.goatool.core.io;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/12/6.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/12/6---17:33
 */
public class VFSTest {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Test
    public void getPackagePath(){
        String packagePath = VFS.getPackagePath("org.apache.goat.common");
        Assert.assertEquals("org/apache/goat/common", packagePath);
    }

    @Test
    public void getResources() throws IOException {
        List<URL> urls = VFS.getResources("cn/goatool/core/reflect"); //  cn.goatool.core.reflect
        System.out.println(urls);
    }

    DefaultVFS defaultVFS = new DefaultVFS();

    @Test
    public void list() throws IOException {
        List<String> names = new ArrayList<>();
        String path = "cn/goatool/core/exception";
        List<URL> urls = VFS.getResources(path);
        for (URL url : urls) {
            List<String> list = defaultVFS.list(url, path);
            names.addAll(list);
        }
        System.out.println(names);
    }


    @Test
    public void isJar() throws IOException {
        String path = "cn/goatool/core/exception";
        List<URL> urls = VFS.getResources(path);

        for (URL url : urls) {
            List<URL> childUrls = defaultVFS.getChildUrls(url, path);
            childUrls.stream().forEach(x->{
                boolean jar = defaultVFS.isJar(x);
                System.out.println(jar);
            });
        }
    }




}
