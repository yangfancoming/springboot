package cn.goatool.core.io;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URL;
import java.util.List;

/**
 * Created by Administrator on 2019/12/6.
 *
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
    public void test() throws IOException {
        List<URL> resources = VFS.getResources("cn/goatool/core/io"); // cn.goatool.core.io
        System.out.println(resources);
    }
}
