package com.s2u2m.demo.spring.mvc;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;

@Component
public class ItemConverter implements Converter<String, DomainItem>, InitializingBean {
    private Map<String, DomainItem> repo = new LinkedHashMap<>();
    @Override
    public void afterPropertiesSet() throws Exception {
        repo.put("1", DomainItem.builder().name("1").build());
        repo.put("2", DomainItem.builder().name("2").build());
    }

    @Override
    public DomainItem convert(String source) {
        return repo.get(source);
    }
}
