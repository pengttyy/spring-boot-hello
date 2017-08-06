package com.pengttyy;

import com.pengttyy.mapper.bs.UserBSMapper;
import com.pengttyy.mapper.bscap.UserBSCAPMapper;
import com.pengttyy.mapper.entity.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * Created by pengt on 2017/6/18.
 */
@RestController
public class HelloWorld {
    private static final Random random = new Random();

    @Autowired
    private UserBSMapper userMapper;

    @Autowired
    private UserBSCAPMapper userBSCAPMapper;

    @PostMapping(path = "/bs/user", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "say hello", notes = "这是一个测试接口")
    public String say(@RequestBody User user) {
        int save = this.userMapper.save(user);
        System.out.println(save);
        return user.toString();
    }

    @PostMapping(path = "/bscap/user", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "插入另外的数据库", notes = "这是一个测试接口")
    public String bscapUser(@RequestBody User user) {
        int save = this.userBSCAPMapper.save(user);
        System.out.println(save);
        return user.toString();
    }

}
