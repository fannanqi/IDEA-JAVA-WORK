package com.example.work8.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
//import com.example.work8.handler.CryptoTypeHandler;

import static com.alibaba.druid.filter.config.ConfigTools.encrypt;

@TableName(value = "user2",autoResultMap = true)//autoResultMap,查询结果转换为明文
public class User {
    private String username;
//    @TableField(value = "password",typeHandler = CryptoTypeHandler.class)
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
