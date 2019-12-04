
package com.goat.mybatis.decompose;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import java.util.Properties;


public class XPathParser {

    private Logger log = LoggerFactory.getLogger(getClass());

    //  private final Document document; //Document对象通过createDocument方法得到
    private boolean validation; //是否开启验证
    private EntityResolver entityResolver; //用于加载本地DTD文件，具体实现为XMLMapperEntityResolver类
    private Properties variables; //mybatis-config.xml 中<propteries>标签定义的键值对集合
    private XPath xpath;  //XPath对象

    public Document createDocument(InputSource inputSource) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setValidating(validation);
            factory.setNamespaceAware(false);
            factory.setIgnoringComments(true);
            factory.setIgnoringElementContentWhitespace(false);
            factory.setCoalescing(false);
            factory.setExpandEntityReferences(true);
            DocumentBuilder builder = factory.newDocumentBuilder();
            builder.setEntityResolver(entityResolver);
//            builder.setErrorHandler(new MyErrorHandler());
            return builder.parse(inputSource);
        } catch (Exception e) {
            throw new BuilderException("Error creating document instance.  Cause: " + e, e);
            // 为啥 换成 Exception 就必须要捕获呢？  throw new Exception("Error creating document instance.  Cause: " + e, e);
        }
    }


//    private void propertiesElement(XNode context) throws Exception {
//        if (context != null) {
//            // 获取<properties>节点的所有子节点 并将这些节点内容转换为属性对象 Properties
//            Properties defaults = context.getChildrenAsProperties();
//            // 获取<properties>节点上的resource属性
//            String resource = context.getStringAttribute("resource");
//            // 获取<properties>节点上的url属性
//            String url = context.getStringAttribute("url");
//            // resource 和 url 两个属性不能同时存在
//            if (resource != null && url != null) {
//                throw new BuilderException("The properties element cannot specify both a URL and a resource based property file reference. Please specify one or the other.");
//            }
//            if (resource != null) {
//                // 获取resource属性值对应的properties文件中的键值对，并添加至defaults容器中 会产生覆盖操作
//                // 从文件系统中加载并解析属性文件
//                Properties properties = Resources.getResourceAsProperties(resource);
//                defaults.putAll(properties);
//            } else if (url != null) {
//                // 获取url属性值对应的properties文件中的键值对，并添加至defaults容器中  会产生覆盖操作
//                defaults.putAll(Resources.getUrlAsProperties(url));
//            }
//            // 获取configuration中原本的属性，并添加至defaults容器中
//            Properties vars = configuration.getVariables();
//            if (vars != null) {
//                defaults.putAll(vars);
//            }
//            parser.setVariables(defaults);
//            // 将defaults容器添加至configuration中
//            configuration.setVariables(defaults);
//        }
//    }

}
