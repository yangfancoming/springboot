package com.goat.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;

import java.io.Serializable;
import java.util.Date;

//@JsonIgnoreProperties({ "password", "age" }) // @JsonIgnoreProperties 转换实体时忽略json中不存在的字段
//@JsonNaming(PropertyNamingStrategy.LowerCaseWithUnderscoresStrategy.class)
//@JsonSerialize(using = UserSerializer.class)
//@JsonDeserialize (using = UserDeserializer.class)
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

	// @JsonIgnore
	@JsonView(AllUserFieldView.class)
	private String password;

	// @JsonProperty("bth")
	 @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonView(AllUserFieldView.class)
	private Date birthday;

    /**
     @JsonProperty 此注解用于属性上，作用是把该属性的名称序列化为另外一个名称，如把trueName属性序列化为name，@JsonProperty("name")
     该注解 项目重启后 生效
     */
    @JsonProperty("text")
	 private String temp1;
	 private String temp2;


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
}
