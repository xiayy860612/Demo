package com.s2u2m.demo.spring.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class BeanLifeCycleApp {
    public static void main(String[] args) {
        SpringApplication.run(BeanLifeCycleApp.class, args);
    }

    @Component
    static class MyInstantiation implements InstantiationAwareBeanPostProcessor {
        @Override
        public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
            if (User.class.isAssignableFrom(beanClass)) {
                System.out.println("before Instantiation: " + beanName);
            }
            return InstantiationAwareBeanPostProcessor.super.postProcessBeforeInstantiation(beanClass, beanName);
        }

        @Override
        public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
            if (User.class.isAssignableFrom(bean.getClass())) {
                System.out.println("after Instantiation: " + beanName);
            }
            return InstantiationAwareBeanPostProcessor.super.postProcessAfterInstantiation(bean, beanName);
        }
    }
}
