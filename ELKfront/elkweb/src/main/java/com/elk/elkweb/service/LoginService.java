package com.elk.elkweb.service;

import org.springframework.stereotype.Service;

/**
 * @author Edison
 * @create 2022-04-30 19:55
 */
@Service
public interface LoginService {
    // 登录验证
    boolean login(String USER_NAME, String USER_PSD);
}
