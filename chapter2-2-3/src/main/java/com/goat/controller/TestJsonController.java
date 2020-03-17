package com.goat.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.goat.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@RestController
public class TestJsonController {

	@Autowired
    ObjectMapper mapper;

	// http://localhost:8223/AllUserFieldView    返回 所有的4个属性
	@JsonView(User.AllUserFieldView.class)
	@GetMapping("AllUserFieldView")
	public User AllUserFieldView() {
		User user = new User("name111",11,"111",new Date(),"temp2");// 2019-04-05 07:22:49
		return user;
	}

    // http://localhost:8223/UserNameView  只返回 userName 属性
    @JsonView(User.UserNameView.class)
    @GetMapping("UserNameView")
    public User UserNameView() {
        User user = new User("name222",22,"222",new Date());// 2019-04-05 07:22:49
        return user;
    }

    // http://localhost:8223/readjsonstring   将json转成 JsonNode 属性结构
    @GetMapping("readjsonstring")
    public String readJsonString() throws IOException {
        String json = "{\"name\":\"mrbird\",\"age\":26}";
        JsonNode node = mapper.readTree(json);
        String name = node.get("name").asText();
        int age = node.get("age").asInt();
        return name + " " + age;
    }

    // http://localhost:8223/formatobjecttojsonstring 将实体类转成json
    @GetMapping("formatobjecttojsonstring")
    public String formatObjectToJsonString() throws JsonProcessingException {
        User user = new User("name222",22,"222",new Date());// 2019-04-05 07:22:49
        String jsonStr = mapper.writeValueAsString(user);
        return jsonStr;
    }

    // http://localhost:8223/updateuser
	@GetMapping("updateuser")
	public int updateUser(@RequestBody List<User> list) {
		return list.size();
	}

    // http://localhost:8223/customize
	@GetMapping("customize")
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
