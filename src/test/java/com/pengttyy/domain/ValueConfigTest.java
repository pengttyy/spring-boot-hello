package com.pengttyy.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

/**
 * Created by pengt on 2017/8/12.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ValueConfigTest {

    @Autowired
    private ValueConfig valueConfig;

    @Test
    public void test() throws Exception {
        assertEquals("pengttyy", valueConfig.getName());
        assertEquals(12, valueConfig.getAge());
    }
}