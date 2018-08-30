package com.csii.userservice.mapper;

import com.csii.userservice.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author cuitao
 * @version V1.0
 * @Description: ${todo}
 * @date 2018/8/25 - 13:23 -- 星期六
 */
@Mapper
@Component
public interface UserMapper {
    @Insert("INSERT INTO USER(age,name) VALUES (#{age},#{name})")
    User saveUser(User user);

    @Select("SELECT * FROM user WHERE id =#{id}")
    User selectById(int id);

    @Update("UPDATE user SET age=#{age},name=#{name} WHERE id=#{id}")
    boolean updateUser(User user);

    @Delete("DELETE FROM user WHERE id=#{id}")
    boolean deleteUser(int id);

    @Select("SELECT * FROM user")
    List<User> selectAllUser();
}
