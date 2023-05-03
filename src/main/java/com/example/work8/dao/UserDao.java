package com.example.work8.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.work8.domain.User;
//import com.example.work8.handler.CryptoTypeHandler;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface UserDao extends BaseMapper<User> {
    @Select("SELECT * FROM user2 WHERE username = #{username} AND password = #{password}")
    @Results(id = "userResultMap", value = {
            @Result(column = "username",jdbcType = JdbcType.VARCHAR ,property = "username"),
            @Result(column = "password",jdbcType = JdbcType.VARCHAR,property = "password"),
            // 其他属性映射
    })
    User login(@Param("username") String username, @Param("password") String password);
    @Insert("INSERT INTO user2(username, password) VALUES(#{username}, #{password,jdbcType=VARCHAR})")
    int registerUser(@Param("username") String username, @Param("password") String password);

}
