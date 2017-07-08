package com.pengttyy;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * Created by pengt on 2017/6/18.
 */
@RestController
public class HelloWorld {
    private static final Random random = new Random();
    @GetMapping("/hello")
    @ApiOperation(value = "say hello", notes = "这是一个测试接口")
    public String say() {
        return "spring-boot hello" + random.nextInt();
    }

}
