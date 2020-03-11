package cn.goatool.core.io;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URL;
import java.util.List;

/**
 * Created by Administrator on 2019/12/6.
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/12/6---17:33
 */
public class VFSTest {

    @Test
    public void getPackagePath(){
        String packagePath = VFS.getPackagePath("org.apache.goat.common");
        Assert.assertEquals("org/apache/goat/common", packagePath);
    }

    @Test
    public void getResources() throws IOException {
        List<URL> urls = VFS.getResources("cn/goatool/core/reflect"); //  cn.goatool.core.reflect
        urls.forEach(x->System.out.println(x));
    }

}
