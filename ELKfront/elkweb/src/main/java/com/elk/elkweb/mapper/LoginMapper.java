package com.elk.elkweb.mapper;

import com.elk.elkweb.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author Edison
 * @create 2022-04-30 19:37
 */
@Repository
@Mapper
public interface LoginMapper {
    // 登录验证
    User login(@Param("USER_NAME") String USER_NAME, @Param("USER_PSD") String USER_PSD);
}
