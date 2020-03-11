package cn.goatool.core.io;

import org.junit.Test;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2020/3/11.
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/3/11---16:07
 */
public class DefaultVFSTest {

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
            childUrls.stream().forEach(x->System.out.println(defaultVFS.isJar(x)));
        }
    }

}
