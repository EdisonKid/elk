package com.elk.elkweb.service;

import com.elk.elkweb.entity.User;
import com.elk.elkweb.mapper.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Edison
 * @create 2022-04-30 19:56
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;

    @Override
    public boolean login(String USER_NAME, String USER_PSD) {
        boolean flag = false;
        User user = loginMapper.login(USER_NAME, USER_PSD);
        if (user != null)
            flag = true;
        return flag;
    }
}
