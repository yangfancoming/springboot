package com.goat.config;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.goat.model.Person;

import java.io.IOException;

public class PersonDeserializer extends JsonDeserializer<Person> {

	@Override
	public Person deserialize(JsonParser parser, DeserializationContext context)throws IOException {
		JsonNode node = parser.getCodec().readTree(parser);
		String userName = node.get("user-name").asText();
        Person user = new Person();
		user.setUserName(userName);
		return user;
	}
}
