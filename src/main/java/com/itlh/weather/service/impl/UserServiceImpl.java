package com.itlh.weather.service.impl;

import com.itlh.weather.mapper.UserMapper;
import com.itlh.weather.pojo.User;
import com.itlh.weather.pojo.dto.LoginDto;
import com.itlh.weather.pojo.dto.RegisterDto;
import com.itlh.weather.result.Result;
import com.itlh.weather.service.UserService;
import com.itlh.weather.util.JWTUtils;
import com.itlh.weather.util.Md5Utils;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Diamond
 * @description 针对表【users】的数据库操作Service实现
 * @createDate 2024-12-02 16:18:11
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    /**
     * 登录
     *
     * @param loginDto
     * @return
     */
    @Override
    public Result login(LoginDto loginDto) throws Exception {
        String username = loginDto.getUsername();
        String password = loginDto.getPassword();
        User loginUser = findByName(username);
        if (loginUser == null) {
            return Result.failure(400, "用户名错误");
        }
        boolean verify = Md5Utils.verify(password, "password", loginUser.getPassword());
        if (!verify) {
            return Result.failure(401, "密码错误");
        }
        Map<String, String> claims = new HashMap<>();
        claims.put("id", loginUser.getId().toString());
        claims.put("username", loginUser.getUsername());
        String token = JWTUtils.getToken(claims);
        return Result.success(token);
    }

    /**
     * 注册
     * @param registerDto
     */
    @Override
    public void register(RegisterDto registerDto) throws Exception {
        String password = registerDto.getPassword();
        String md5Password = Md5Utils.md5(password, "password");
        userMapper.save(registerDto.getUsername(),md5Password,registerDto.getEmail());
    }

    /**
     * 根据用户名查找用户
     *
     * @param username
     * @return
     */
    @Override
    public User findByName(String username) {
        return userMapper.selectByName(username);
    }
}




