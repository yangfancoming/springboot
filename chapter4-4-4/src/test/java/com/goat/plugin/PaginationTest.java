package com.goat.plugin;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.goat.entity.User;
import com.goat.dao.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by 64274 on 2018/12/7.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2018/12/7---23:54
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class PaginationTest {

    @Autowired
    private UserMapper userMapper;

    /**
     *  分页插件
     */
    @Test
    public void pagingTest() {
        // SELECT id,name,age,version FROM user LIMIT 0,5
        Page<User> page = new Page<>(1,5);
        IPage<User> employeeIPage = userMapper.selectPage(page, null);
        System.out.println("返回数据：" + employeeIPage.getRecords());

        System.out.println("总条数：" + page.getTotal());
        System.out.println("当前页码：" + page.getCurrent());
        System.out.println("总页码：" + page.getPages());
        System.out.println("每页显示条数：" + page.getSize());
        System.out.println("是否有上一页：" + page.hasPrevious());
        System.out.println("是否有下一页：" + page.hasNext());
        System.out.println("返回的数据：" + page.getRecords());
    }
}
