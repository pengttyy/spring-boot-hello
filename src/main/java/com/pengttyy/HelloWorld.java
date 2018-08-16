package com.pengttyy;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by pengt on 2017/6/18.
 */
@RestController
public class HelloWorld {

    @GetMapping("/hello")
    public String say() {
        return "spring-boot hello2222";
    }

}
