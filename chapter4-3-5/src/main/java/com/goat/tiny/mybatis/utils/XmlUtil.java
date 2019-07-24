
package com.goat.tiny.mybatis.utils;


import com.goat.tiny.mybatis.constants.Constant;
import com.goat.tiny.mybatis.mapping.MappedStatement;
import com.goat.tiny.mybatis.session.Configuration;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.goat.tiny.mybatis.constants.Constant.SqlType;

public final class XmlUtil {

    @SuppressWarnings("rawtypes")
    public static void readMapperXml(File fileName, Configuration configuration) {
        try {
            SAXReader saxReader = new SAXReader(); // 创建一个读取器
            saxReader.setEncoding(Constant.CHARSET_UTF8); // 设置编码
            Document document = saxReader.read(fileName); // 读取文件内容
            Element rootElement = document.getRootElement();  // 获取xml中的根元素
            // 不是beans根元素的，文件不对
            if (!Constant.XML_ROOT_LABEL.equals(rootElement.getName())){
                System.err.println("mapper xml文件根元素不是mapper");
                return;
            }
            for (Iterator iterator = rootElement.elementIterator(); iterator.hasNext();) {
                Element element = (Element)iterator.next();
                String eleName = element.getName();
                MappedStatement statement = new MappedStatement();
                if (SqlType.SELECT.value().equals(eleName)) {
                    String resultType = element.attributeValue(Constant.XML_SELECT_RESULTTYPE);
                    statement.setResultType(resultType);
                    statement.setSqlCommandType(SqlType.SELECT);
                }
                else if (SqlType.UPDATE.value().equals(eleName)){
                    statement.setSqlCommandType(SqlType.UPDATE);
                }
                else{
                    // 其他标签自己实现
                    System.err.println("不支持此xml标签解析:" + eleName);
                    statement.setSqlCommandType(SqlType.DEFAULT);
                }
                // com.goat.tiny.mybatis.dao.UserMapper
                String namespace = rootElement.attributeValue(Constant.XML_SELECT_NAMESPACE);
                //设置SQL的唯一ID
                String sqlId = namespace + "." + element.attributeValue(Constant.XML_ELEMENT_ID);
                statement.setSqlId(sqlId);
                statement.setNamespace(namespace);
                statement.setSql(CommonUtis.stringTrim(element.getStringValue()));
                configuration.addMappedStatement(sqlId, statement);
                //这里其实是在MapperRegistry中生产一个mapper对应的代理工厂
                configuration.addMapper(Class.forName(namespace));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}
