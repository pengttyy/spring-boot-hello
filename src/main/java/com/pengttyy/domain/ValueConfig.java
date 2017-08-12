package com.pengttyy.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by pengt on 2017/8/12.
 */
@Component
public class ValueConfig {
    @Value("${value.config.name}")
    private String name;

    @Value("${value.config.age}")
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
