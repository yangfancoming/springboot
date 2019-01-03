package com.goat.ar;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.goat.entity.UserModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * Created by 64274 on 2018/11/13.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/11/13---13:28
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ARTest {



    @Test
    public void insert() {
        UserModel userModel = new UserModel();
        userModel.setName("vander");
        userModel.setAge(24);
        userModel.insert(); //-----------------  字段不为空插入
    }
    @Test
    public void insertOrUpdate() {
        UserModel userModel = new UserModel();
        userModel.setName("vander");
        userModel.setAge(24);
        userModel.insertOrUpdate(); //-----------------  ID为空插入，否则为更新
    }


    @Test
    public void updateById() { //-----------------  ID 修改
        UserModel userModel = new UserModel();
        userModel.setName("vander");
        userModel.setAge(24);
        userModel.updateById();
    }

    @Test
    public void update() { //-----------------  条件修改
        UserModel userModel = new UserModel();
        userModel.setName("vander");
        userModel.setAge(24);
        /**
         * UPDATE tbl_employee SET last_name='vander',email='vander-4@foxmail.com',gender=0,age=24 WHERE gender = '5'
         */
        userModel.update(new UpdateWrapper<UserModel>().eq("gender","5"));
    }

    @Test
    public void ARSelect() {
        UserModel userModel = new UserModel();
        userModel.setId(24L);

        //-----------------  setId
        userModel.selectById();

        //-----------------  直接键入 Id
        userModel.selectById(24);

        //-----------------  条件
        userModel.selectCount(new QueryWrapper<>().eq("gender", "0"));

        //-----------------  查询所有
        userModel.selectAll();

        //-----------------  查询总记录数
        userModel.selectList((Wrapper) new QueryWrapper().eq("gender", 0));

        //-----------------
        userModel.selectOne(new QueryWrapper());

        //-----------------
        userModel.selectPage(new Page<>(1,2), new QueryWrapper<>());

    }


    @Test
    public void ARDelete() {
        /**
         *  删除不存在的数据 在逻辑上也是成功的，返回结果 true
         */
        UserModel userModel = new UserModel();
        userModel.setId(30L);

        //-----------------
        userModel.deleteById();

        //-----------------
        userModel.deleteById(31);

        //-----------------
        userModel.delete((Wrapper) new QueryWrapper().eq("Id", 32));
    }
}