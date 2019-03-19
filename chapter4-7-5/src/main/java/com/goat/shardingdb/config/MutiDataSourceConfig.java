package com.goat.shardingdb.config;

import io.shardingjdbc.core.api.MasterSlaveDataSourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by 64274 on 2019/3/19.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/3/19---14:15
 */
@Configuration
public class MutiDataSourceConfig {

    /**
     * 配置读写分离数据源
     * 注意，数据源需要手动注入，直接使用MasterSlaveDataSourceFactory的创建数据源方式，
     * 将sharding-jdbc.yml传入后可创建出一个数据源，后面的操作就和普通数据源一样，
     * 但在内部里，该数据源就会自动将操作进行读写分离
     * @throws SQLException
     * @throws IOException
     */
    @Bean
    public DataSource dataSource() throws SQLException, IOException {
        return MasterSlaveDataSourceFactory.createDataSource(ResourceUtils.getFile("classpath:sharding-jdbc.yml"));
    }
}
