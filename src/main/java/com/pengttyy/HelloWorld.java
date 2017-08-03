package com.pengttyy;

import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * Created by pengt on 2017/6/18.
 */
@RestController
public class HelloWorld {
    private static final Random random = new Random();

    @PostMapping(path = "/hello", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "say hello", notes = "这是一个测试接口")
    public String say() {
        if (true) {
            throw new NullPointerException("这是个异常");
        }
        return "spring-boot hello" + random.nextInt();
    }

}
