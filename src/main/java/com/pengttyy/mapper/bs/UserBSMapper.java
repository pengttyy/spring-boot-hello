package com.pengttyy.mapper.bs;

import com.pengttyy.mapper.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;

/**
 * Created by pengt on 2017/8/6.
 */
public interface UserBSMapper {
    @Insert("INSERT INTO USER(name,code,age) VALUES (#{name},#{code},#{age})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int save(User user);
}
