package cn.goatool.core.io;

import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.List;

/**
 * Created by Administrator on 2019/12/6.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/12/6---17:23
 */
public abstract class VFS {

    /**
     * Get a list of {@link URL}s from the context classloader for all the resources found at the specified path.
     * @param path The resource path.
     * @return A list of {@link URL}s, as returned by {@link ClassLoader#getResources(String)}.
     * @throws IOException If I/O errors occur
     * 输入示例：   "cn/goatool/core/io"
     * 输出结果：
     * 0 = {URL@843} "file:/E:/Code/J2EE_code/MySpringBoot/springboot/chapter0-0-9/goatool-core/target/test-classes/cn/goatool/core/io"
     * 1 = {URL@844} "file:/E:/Code/J2EE_code/MySpringBoot/springboot/chapter0-0-9/goatool-core/target/classes/cn/goatool/core/io"
     * @date 2019年12月6日17:43:06
     */
    public static List<URL> getResources(String path) throws IOException {
        return Collections.list(Thread.currentThread().getContextClassLoader().getResources(path));
    }

    /**
     * 将Java包名转换为可通过调用ClassLoader类的getResources方法查找的路径
     * @param packageName The Java package name to convert to a path
     * 输入示例：   org.apache.goat.common
     * 输出结果：   org/apache/goat/common
     * @date 2019年12月6日17:25:17
     */
    public static String getPackagePath(String packageName) {
        return packageName == null ? null : packageName.replace('.', '/');
    }

}
