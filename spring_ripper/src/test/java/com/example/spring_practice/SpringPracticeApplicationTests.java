package com.example.spring_practice;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class SpringPracticeApplicationTests {
    @Test
    void contextLoads() throws InterruptedException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("context.xml");
        applicationContext.getBean(Quoter.class).sayQuote();
    }
}
