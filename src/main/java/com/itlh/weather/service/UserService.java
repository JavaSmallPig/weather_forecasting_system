package com.itlh.weather.service;

import com.itlh.weather.pojo.User;
import com.itlh.weather.pojo.dto.LoginDto;
import com.itlh.weather.pojo.dto.RegisterDto;
import com.itlh.weather.result.Result;

/**
 * @author Diamond
 * @description 针对表【users】的数据库操作Service
 * @createDate 2024-12-02 16:18:11
 */
public interface UserService {

    Result login(LoginDto loginDto) throws Exception;

    void register(RegisterDto registerDto) throws Exception;

    User findByName(String username);

    User findById(int id);
}
