package com.pengttyy;

import com.pengttyy.domain.Result;
import com.pengttyy.mapper.bs.UserBSMapper;
import com.pengttyy.mapper.bscap.UserBSCAPMapper;
import com.pengttyy.mapper.entity.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
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
    @Transactional
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

    @GetMapping(path = "/bs/result")
    public Result<User> result() {
        User user = new User();
        user.setId(10);
        user.setName("pengttyy");
        user.setCode("ppppp");
        user.setAge(10);

        List<User> list = new ArrayList<>();
        User user1 = new User();
        user1.setName("kai1");
        list.add(user1);
        user.setList(list);

        Result<User> userResult = new Result<>();
        userResult.setData(user);
        userResult.setStatus(200);
        return userResult;
    }

}
