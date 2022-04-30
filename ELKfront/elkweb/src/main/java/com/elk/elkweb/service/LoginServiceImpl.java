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
    public boolean login(String username, String password) {
        boolean flag = false;
        User user = loginMapper.login(username, password);
        if (user !=  null)
            flag = true;
        return flag;
    }
}
