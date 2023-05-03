package com.example.work8.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.work8.domain.LoginLog;
import com.example.work8.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginLogDao extends BaseMapper<LoginLog> {
}
