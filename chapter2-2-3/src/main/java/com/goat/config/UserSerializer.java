package com.goat.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.goat.model.User;

import java.io.IOException;

public class UserSerializer extends JsonSerializer<User> {

	@Override
	public void serialize(User user, JsonGenerator generator, SerializerProvider provider)throws IOException {
		generator.writeStartObject();
		generator.writeStringField("user-name", user.getUserName());
		generator.writeEndObject();
	}
}
