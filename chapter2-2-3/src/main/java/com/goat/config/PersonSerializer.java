package com.goat.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.goat.model.Person;

import java.io.IOException;

public class PersonSerializer extends JsonSerializer<Person> {

	@Override
	public void serialize(Person person, JsonGenerator generator, SerializerProvider provider)throws IOException {
		generator.writeStartObject();
		generator.writeStringField("user-name", person.getUserName());
		generator.writeEndObject();
	}
}
