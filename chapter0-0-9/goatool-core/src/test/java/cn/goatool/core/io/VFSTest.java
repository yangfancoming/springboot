package cn.goatool.core.io;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
        String path = "cn/goatool/core/exception";
        List<URL> urls = VFS.getResources(path);
        for (URL url : urls) {
            List<String> list = defaultVFS.list(url, path);
            names.addAll(list);
        }
        System.out.println(names);
    }


    @Test
    public void listResources() throws IOException {
        String path = "cn/goatool/core/exception";
        List<URL> urls = VFS.getResources(path);

        List<String> children = new ArrayList<>();

        for (URL url : urls) {
            InputStream is = url.openStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            List<String> lines = new ArrayList<>();
            for (String line; (line = reader.readLine()) != null;) {
                if (log.isDebugEnabled()) {
                    log.debug("Reader entry: " + line);
                }
                lines.add(line);
                if (defaultVFS.getResources(path + "/" + line).isEmpty()) {
                    lines.clear();
                    break;
                }
            }

            if (!lines.isEmpty()) {
                if (log.isDebugEnabled()) {
                    log.debug("Listing " + url);
                }
                children.addAll(lines);
            }

            // The URL prefix to use when recursively listing child resources
            String prefix = url.toExternalForm();
            if (!prefix.endsWith("/")) {
                prefix = prefix + "/";
            }
            List<String> resources = new ArrayList<>();
            // Iterate over immediate children, adding files and recursing into directories
            for (String child : children) { // 由于这里的 for循环到 测试类的失败 doit？？？
                String resourcePath = path + "/" + child;
                resources.add(resourcePath);
                URL childUrl = new URL(prefix + child);
                boolean jar = defaultVFS.isJar(childUrl);
                log.info(childUrl.toString() + "是不是jar：{}",jar);

                System.out.println(childUrl);
                System.out.println(resourcePath);
            }
        }

        System.out.println(children);



    }

}
