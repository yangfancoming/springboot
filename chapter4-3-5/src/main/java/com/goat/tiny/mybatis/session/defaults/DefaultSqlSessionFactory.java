
package com.goat.tiny.mybatis.session.defaults;




import com.goat.tiny.mybatis.constants.Constant;
import com.goat.tiny.mybatis.session.Configuration;
import com.goat.tiny.mybatis.session.SqlSession;
import com.goat.tiny.mybatis.session.SqlSessionFactory;
import com.goat.tiny.mybatis.utils.CommonUtis;
import com.goat.tiny.mybatis.utils.XmlUtil;

import java.io.File;
import java.net.URL;


/**
 * 默认SQL会话工厂实现类
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private final Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
        String dirName = Configuration.getProperty(Constant.MAPPER_LOCATION).replaceAll("\\.", "/");
        loadMappersInfo(dirName);
    }

    @Override
    public SqlSession openSession() {
        SqlSession session = new DefaultSqlSession(this.configuration);
        return session;
    }

    private void loadMappersInfo(String dirName) {
        URL resources =this.getClass().getClassLoader().getResource(dirName);
        File mappersDir = new File(resources.getFile());
        if (mappersDir.isDirectory()){
            // 显示包下所有文件
            File[] mappers = mappersDir.listFiles();
            if (CommonUtis.isNotEmpty(mappers)){
                for (File file : mappers){
                    // 对文件夹继续递归
                    if (file.isDirectory()){
                        loadMappersInfo(dirName + "/" + file.getName());
                    }
                    else if (file.getName().endsWith(Constant.MAPPER_FILE_SUFFIX)){
                        XmlUtil.readMapperXml(file, this.configuration); // 只对XML文件解析
                    }
                }
            }
        }
    }

}
