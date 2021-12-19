package com.s2u2m.demo.spring.mvc;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @author: Amos
 * @date: 2021/11/22
 * @since:
 **/
@Configuration
public class ConverterConfig implements WebMvcConfigurer {
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new MoneyHttpMessageConverter());
    }
}
