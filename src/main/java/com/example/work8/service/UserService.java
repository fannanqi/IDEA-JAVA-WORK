package com.example.work8.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.AES;
import com.example.work8.dao.UserDao;
import com.example.work8.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    private final static String KEY="c86038fe04bc7097";

    public boolean registUser(User registUser){
        // 对密码进行加密
        int insert = userDao.registerUser(registUser.getUsername(), registUser.getPassword());
        System.out.println(insert);
        if(insert==0){
            return false;
        }
        else {
            return true;
        }
    }

    public User loginUser(User loginuser){
        LambdaQueryWrapper<User>lqw=new LambdaQueryWrapper<User>();
        System.out.println(loginuser);
        lqw.eq(User::getUsername, loginuser.getUsername()).eq(User::getPassword, loginuser.getPassword());
        return userDao.selectOne(lqw);
    }

    public Boolean updateUser(String username,String password){
        LambdaQueryWrapper<User>lqw=new LambdaQueryWrapper<User>();
        lqw.eq(User::getUsername,username);
        User user1 = userDao.selectOne(lqw);
        user1.setPassword(password);
        System.out.println(user1);
        int update = userDao.update(user1,lqw);
        if(update==0){
            return false;
        }
        else{
            return true;
        }
    }
}

