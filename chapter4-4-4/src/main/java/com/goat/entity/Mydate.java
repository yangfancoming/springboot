package com.goat.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by 64274 on 2018/11/13.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/11/13---13:29
 */

@TableName("my_date") // value 指定数据库对应表名  如果与类名相同则可以省略
public class Mydate {

    @TableId(value = "id",type = IdType.AUTO) // type 主键自增  value 指定数据库主键列的列名  如果与属性名相同则可以省略
    private Long id;
    private Timestamp mydatetime;
    private Timestamp mytimestamp;
    private Date mydate;

    @TableField(exist = false)//：表示该属性不为数据库表字段，但又是必须使用的。
    private String boring;

    public Timestamp getMydatetime() {
        return mydatetime;
    }

    public void setMydatetime(Timestamp mydatetime) {
        this.mydatetime = mydatetime;
    }

    public Timestamp getMytimestamp() {
        return mytimestamp;
    }

    public void setMytimestamp(Timestamp mytimestamp) {
        this.mytimestamp = mytimestamp;
    }

    public Date getMydate() {
        return mydate;
    }

    public void setMydate(Date mydate) {
        this.mydate = mydate;
    }

    public String getBoring() {
        return boring;
    }

    public void setBoring(String boring) {
        this.boring = boring;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Mydate{" + "id=" + id + ", mydatetime=" + mydatetime + ", mytimestamp=" + mytimestamp + ", mydate=" + mydate + '}';
    }
}
