package com.elk.elkweb.mapper;

import com.elk.elkweb.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Edison
 * @create 2022-04-30 19:37
 */
@Mapper
public interface LoginMapper {
    // 登录验证
    User login(@Param("username") String username, @Param("password") String password);
}
