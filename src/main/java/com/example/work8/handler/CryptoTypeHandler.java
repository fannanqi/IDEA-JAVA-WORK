//package com.example.work8.handler;
//
//import com.alibaba.druid.pool.DruidPooledPreparedStatement;
//import com.baomidou.mybatisplus.core.toolkit.AES;
//import org.apache.ibatis.type.BaseTypeHandler;
//import org.apache.ibatis.type.JdbcType;
//import org.apache.ibatis.type.MappedTypes;
//import org.springframework.stereotype.Component;
//import org.springframework.util.StringUtils;
//
//import java.sql.CallableStatement;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//@Component
//@MappedTypes(value = String.class)
//public class CryptoTypeHandler extends BaseTypeHandler<String> {
//    private final static String KEY="c86038fe04bc7097";
//
//    @Override
//    public void setNonNullParameter(PreparedStatement preparedStatement, int i, String s, JdbcType jdbcType) throws SQLException {
//        preparedStatement.setString("password");
//        String sql = ((DruidPooledPreparedStatement) preparedStatement).getSql();
//        if (StringUtils.hasLength(sql) && sql.contains("password")){
//
//    insert into user (name,pwd) vla
//            preparedStatement.setString(i, AES.encrypt(s,KEY));
//        }else{
//            preparedStatement.setString(i, s);
//        }
//    }
//
//    @Override
//    public String getNullableResult(ResultSet resultSet, String columnName) throws SQLException {
//        String columnValue=resultSet.getString(columnName);
//        return AES.decrypt(columnValue,KEY);
//    }
//
//    @Override
//    public String getNullableResult(ResultSet resultSet, int columnIndex) throws SQLException {
//        String columnValue = resultSet.getString(columnIndex);
//        return AES.decrypt(columnValue,KEY);
//    }
//
//    @Override
//    public String getNullableResult(CallableStatement callableStatement, int columnIndex) throws SQLException {
//        String columnValue = callableStatement.getString(columnIndex);
//        return AES.decrypt(columnValue,KEY);
//    }
//
//}
//
