package com.goat.model;

import com.fasterxml.jackson.annotation.*;

import java.io.Serializable;
import java.util.Date;

//@JsonIgnoreProperties({ "password", "age" }) //  转换实体时忽略json中不存在的字段
//@JsonNaming(PropertyNamingStrategy.LowerCaseWithUnderscoresStrategy.class)
//@JsonInclude(JsonInclude.Include.NON_NULL) // 如果该字段为 null 则不会返回  也可以用在 属性上
public class User implements Serializable {

	private static final long serialVersionUID = 6222176558369919436L;

	public interface UserNameView {
	}

	public interface AllUserFieldView extends UserNameView {
	}

	@JsonView(UserNameView.class)
	private String userName;
	
	@JsonView(AllUserFieldView.class)
	private int age;

	@JsonView(AllUserFieldView.class)
	private String password;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") //  2019-04-05 07:22:49
    @JsonView(AllUserFieldView.class)
	private Date birthday;

    /**
     @JsonProperty 此注解用于属性上，作用是把该属性的名称序列化为另外一个名称，如把trueName属性序列化为name，@JsonProperty("name")
     该注解 项目重启后 生效
     */
    @JsonProperty("text")
	 private String temp1;

	 private String temp2;

    @JsonIgnore // 作用：在json序列化时将java bean中的一些属性忽略掉，序列化和反序列化都受影响
    private String temp3;

    public User() {
    }

    public User(String userName, int age, String password, Date birthday) {
        this.userName = userName;
        this.age = age;
        this.password = password;
        this.birthday = birthday;
    }

    public User(String userName, int age, String password, Date birthday, String temp2) {
        this.userName = userName;
        this.age = age;
        this.password = password;
        this.birthday = birthday;
        this.temp2 = temp2;
    }

    public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getAge() {
		return age;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

    public String getTemp1() {
        return temp1;
    }

    public void setTemp1(String temp1) {
        this.temp1 = temp1;
    }

    public String getTemp2() {
        return temp2;
    }

    public void setTemp2(String temp2) {
        this.temp2 = temp2;
    }

    public String getTemp3() {
        return temp3;
    }

    public void setTemp3(String temp3) {
        this.temp3 = temp3;
    }
}
