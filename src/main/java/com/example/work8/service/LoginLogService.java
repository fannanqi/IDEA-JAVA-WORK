package com.example.work8.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.work8.dao.LoginLogDao;
import com.example.work8.domain.LoginLog;
import com.example.work8.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginLogService {
    @Autowired
    private LoginLogDao loginLogDao;
    public boolean insertLog(String loginuser,String logintime,String loginip){
        LoginLog loginLog=new LoginLog();
        loginLog.setLoginUser(loginuser);
        loginLog.setLoginIp(loginip);
        loginLog.setLoginTime(logintime);
        int insert = loginLogDao.insert(loginLog);
        System.out.println("insert:"+insert);
        if(insert==0){
            return false;
        }
        else {
            return true;
        }
    }
    public LoginLog getLog(String logUser){
        LambdaQueryWrapper<LoginLog> lqw=new LambdaQueryWrapper<>();
        lqw.eq(LoginLog::getLoginUser,logUser);
//        LoginLog loginLog = loginLogDao.selectOne(lqw);
        return loginLogDao.selectOne(lqw);
    }
    public boolean updataLog(String logUser,String data,String id){
        LambdaQueryWrapper<LoginLog> lqw=new LambdaQueryWrapper<>();
        LoginLog log = getLog(logUser);
        log.setLoginTime(data);
        log.setLoginIp(id);
        lqw.eq(LoginLog::getLoginUser,logUser);
        int insert = loginLogDao.update(log,lqw);
        if(insert==0){
            return false;
        }else {
            return true;
        }
    }
}