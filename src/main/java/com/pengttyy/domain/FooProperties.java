package com.pengttyy.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by pengt on 2017/8/12.
 */
@ConfigurationProperties("foo")
public class FooProperties {
    private String name;
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
