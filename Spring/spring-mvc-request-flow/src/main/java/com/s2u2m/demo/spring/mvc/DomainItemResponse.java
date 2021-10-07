package com.s2u2m.demo.spring.mvc;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

@JsonComponent
public class DomainItemResponse extends JsonSerializer<DomainItem> {

    @Override
    public void serialize(DomainItem domainItem,
                          JsonGenerator jsonGenerator,
                          SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString(domainItem.getName());
    }
}
