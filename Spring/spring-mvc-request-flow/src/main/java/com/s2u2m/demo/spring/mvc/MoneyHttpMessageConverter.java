package com.s2u2m.demo.spring.mvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.util.List;

/**
 * serialize/deserialize money object in request/response body
 **/
public class MoneyHttpMessageConverter implements HttpMessageConverter<Money> {

    @Override
    public boolean canRead(Class<?> clazz, MediaType mediaType) {
        return Money.class.isAssignableFrom(clazz)
                && MediaType.APPLICATION_JSON.isCompatibleWith(mediaType);
    }

    @Override
    public boolean canWrite(Class<?> clazz, MediaType mediaType) {
        return Money.class.isAssignableFrom(clazz)
                && MediaType.APPLICATION_JSON.isCompatibleWith(mediaType);
    }

    @Override
    public List<MediaType> getSupportedMediaTypes() {
        return List.of(MediaType.APPLICATION_JSON);
    }

    @Override
    public Money read(Class<? extends Money> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(inputMessage.getBody(), Money.class);
    }

    @Override
    public void write(Money money, MediaType contentType, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        ObjectMapper mapper = new ObjectMapper();
        money.setCurrency("MessageConvert: " + money.getCurrency());
        mapper.writeValue(outputMessage.getBody(), money);
    }
}
