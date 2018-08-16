package com.pengttyy.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by pengt on 2017/8/12.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FooProperties2Test {
    @Autowired
    private FooProperties2 fooProperties2;

    @Test
    public void name() throws Exception {
        System.out.println(this.fooProperties2.getName());
    }
}