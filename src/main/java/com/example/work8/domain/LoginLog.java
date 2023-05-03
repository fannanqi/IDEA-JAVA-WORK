package com.example.work8.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("login_log")
public class LoginLog {
    @TableField(value = "loginUser")
    private String loginUser;
    @TableField(value = "loginTime")
    private String loginTime;
    @TableField(value = "loginIp")
    private String loginIp;

    public String getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(String loginUser) {
        this.loginUser = loginUser;
    }

    public String getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    @Override
    public String toString() {
        return "LoginLog{" +
                "loginUser='" + loginUser + '\'' +
                ", loginTime='" + loginTime + '\'' +
                ", loginIp='" + loginIp + '\'' +
                '}';
    }
}
