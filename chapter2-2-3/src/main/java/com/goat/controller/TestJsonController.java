package com.goat.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.goat.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
public class TestJsonController {

	@Autowired
    ObjectMapper mapper;

	// http://localhost:8223/AllUserFieldView 返回 所有的4个属性
	@JsonView(User.AllUserFieldView.class)
	@RequestMapping("AllUserFieldView")
	@ResponseBody
	public User AllUserFieldView() {
		User user = new User();
		user.setUserName("mrbird");
		user.setAge(25);
		user.setPassword("123456");
		user.setBirthday(new Date()); // 2019-04-05 07:22:49
		return user;
	}

    // http://localhost:8223/UserNameView  只返回 userName 属性
    @JsonView(User.UserNameView.class)
    @RequestMapping("UserNameView")
    @ResponseBody
    public User UserNameView() {
        User user = new User();
        user.setUserName("mrbird");
        user.setAge(26);
        user.setPassword("123456");
        user.setBirthday(new Date());
        return user;
    }

    // http://localhost:8223/serialization
    @RequestMapping("serialization")
    @ResponseBody
    public String serialization() throws JsonProcessingException {
        User user = new User();
        user.setUserName("mrbird");
        user.setBirthday(new Date());
        String str = mapper.writeValueAsString(user);
        return str;
    }

    // http://localhost:8223/readjsonstring
    @RequestMapping("readjsonstring")
    @ResponseBody
    public String readJsonString() throws IOException {
        String json = "{\"name\":\"mrbird\",\"age\":26}";
        JsonNode node = this.mapper.readTree(json);
        String name = node.get("name").asText();
        int age = node.get("age").asInt();
        return name + " " + age;

    }
    //    http://localhost:8223/readjsonasobject
    @RequestMapping("readjsonasobject")
    @ResponseBody
    public String readJsonAsObject() throws IOException {
        String json = "{\"user-name\":\"mrbird\"}";
        User user = mapper.readValue(json, User.class);
        String name = user.getUserName();
        return name;

    }

    // http://localhost:8223/formatobjecttojsonstring
    @RequestMapping("formatobjecttojsonstring")
    @ResponseBody
    public String formatObjectToJsonString() throws JsonProcessingException {
        User user = new User();
        user.setUserName("mrbird");
        user.setAge(27);
        user.setPassword("123456");
        user.setBirthday(new Date());
        String jsonStr = mapper.writeValueAsString(user);
        return jsonStr;
    }

    // http://localhost:8223/updateuser
	@RequestMapping("updateuser")
	@ResponseBody
	public int updateUser(@RequestBody List<User> list) {
		return list.size();
	}

    // http://localhost:8223/customize
	@RequestMapping("customize")
	@ResponseBody
	public String customize() throws IOException {
		String jsonStr = "[{\"userName\":\"mrbird\",\"age\":26},{\"userName\":\"scott\",\"age\":27}]";
		JavaType type = mapper.getTypeFactory().constructParametricType(List.class, User.class);
		List<User> list = mapper.readValue(jsonStr, type);
		String msg = "";
		for (User user : list) {
			msg += user.getUserName();
		}
		return msg;
	}
}
