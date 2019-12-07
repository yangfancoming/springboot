package cn.goatool.core.io;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.MalformedURLException;
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
        String path = "cn/goatool/core/reflect";
        List<URL> urls = VFS.getResources(path); //  cn.goatool.core.reflect
        for (URL url : urls) {
            List<String> list = defaultVFS.list(url, path);
            names.addAll(list);// file:/E:/Code/Mybatis/GitHub/mybatis-3-master/target/test-classes/org/apache/goat/common
        }
        System.out.println(names);
    }


    @Test
    public void isJar() throws IOException {
        String path = "cn/goatool/core/reflect";
        List<URL> urls = VFS.getResources(path); //  cn.goatool.core.reflect

        urls.stream().forEach(x->{
            StringBuilder jarUrl = new StringBuilder(x.toExternalForm());
            int index = jarUrl.lastIndexOf(".jar");
            if (index >= 0) {
                jarUrl.setLength(index + 4);
                if (log.isDebugEnabled()) {
                    log.debug("Extracted JAR URL: " + jarUrl);
                }
            }
            else {
                if (log.isDebugEnabled()) {
                    log.debug("Not a JAR: " + jarUrl);
                }
                return ;
            }

            URL testUrl = null;
            try {
                testUrl = new URL(jarUrl.toString());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            log.info(x.getPath() + "是否为jar：{}",defaultVFS.isJar(testUrl));

        });
    }

}
