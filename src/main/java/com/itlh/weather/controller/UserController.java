package com.itlh.weather.controller;

import com.itlh.weather.pojo.User;
import com.itlh.weather.pojo.dto.LoginDto;
import com.itlh.weather.pojo.dto.RegisterDto;
import com.itlh.weather.result.Result;
import com.itlh.weather.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Java小猪
 * @Date 2024/12/2 16:33
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    /**
     * 根据用户名查找用户
     *
     * @param
     * @return
     */
    @GetMapping("/selByName/{username}")
    public User findByName(@PathVariable("username") String username) {
        return userService.findByName(username);
    }

    /**
     * 根据id查询用户
     *
     * @param id
     * @return
     */
    @GetMapping("/selById/{id}")
    public User findById(@PathVariable("id") int id) {
        return userService.findById(id);
    }

    /**
     * 登录
     *
     * @param loginDto
     * @return
     */
    @PostMapping("/login")
    public Result login(@RequestBody LoginDto loginDto) throws Exception {
        return userService.login(loginDto);
    }

    /**
     * 注册
     *
     * @param registerDto
     * @return
     */
    @PostMapping("/register")
    public Result register(@RequestBody RegisterDto registerDto) throws Exception {
        String username = registerDto.getUsername();
        User registerUser = userService.findByName(username);
        if (registerUser == null) {
            userService.register(registerDto);
            return Result.success("注册成功");
        }
        return Result.failure(402, "用户已存在");
    }
}
