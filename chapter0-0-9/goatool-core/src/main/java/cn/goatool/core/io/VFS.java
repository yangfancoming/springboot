package cn.goatool.core.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Administrator on 2019/12/6.
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/12/6---17:23
 *
 * 在应用服务中提供非常简单API访问资源文件。
 * 不同的操作系统有不同的文件结构，有些特殊的需要进行适配，例如：JBoss6VFS。
 * 主要是实现package这种目录式文件加载 <package name="org.apache.ibatis.builder.mapper"/>
 *
 * VFS 为抽象类，定义了模板方法 List<String> list(URL url, String forPath) 由子类实现， VFS是一个静态单例模式
 */
public abstract class VFS {

    private Logger log = LoggerFactory.getLogger(getClass());

    // 对比list方法    此方法不是递归 只是获取当前目录的下一层目录
    public List<URL> getChildUrls(URL url, String path) throws IOException {
        List<URL> childUrls = new ArrayList<>();
        List<String> children = getchilds(url, path);
        // The URL prefix to use when recursively listing child resources  getchilds
        String prefix = url.toExternalForm();
        if (!prefix.endsWith("/")) {
            prefix = prefix + "/";
        }
        // Iterate over immediate children, adding files and recursing into directories
        for (String child : children) {
            URL childUrl = new URL(prefix + child);
            childUrls.add(childUrl);
        }
        return childUrls;
    }

    public List<String> getchilds(URL url,String path) throws IOException {
        InputStream is = url.openStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        List<String> lines = new ArrayList<>();
        List<String> children = new ArrayList<>();
        for (String line; (line = reader.readLine()) != null;) {
            if (log.isDebugEnabled()) {
                log.debug("Reader entry: " + line);
            }
            lines.add(line);
            if (getResources(path + "/" + line).isEmpty()) {
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
        return children;
    }

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

    /**
     * Recursively list the full resource path of all the resources that are children of the resource identified by a URL.
     * 递归地列出所有资源的完整资源路径，这些资源是由URL标识的资源的子级。
     * @param url The URL that identifies the resource to list.
     * @param forPath The path to the resource that is identified by the URL. Generally, this is the value passed to {@link #getResources(String)} to get the resource URL.
     * @return A list containing the names of the child resources.
     * @throws IOException If I/O errors occur
     * D.获取资源list
     */
    protected abstract List<String> list(URL url, String forPath) throws IOException;

    /**
     * Recursively list the full resource path of all the resources that are children of all the resources found at the specified path.
     * 递归地列出所有资源的完整资源路径，这些资源是在指定路径上找到的所有资源的子级。
     * @param path The path of the resource(s) to list.  org/apache/goat/common
     * @return A list containing the names of the child resources.
     * @throws IOException If I/O errors occur
     * D.递归列出所有的资源 org/apache/goat/common
     */
    public List<String> list(String path) throws IOException {
        List<String> names = new ArrayList<>();
        List<URL> resources = getResources(path);
        for (URL url : resources) {
            List<String> list = list(url, path);
            names.addAll(list);
        }
        return names;
    }
}
