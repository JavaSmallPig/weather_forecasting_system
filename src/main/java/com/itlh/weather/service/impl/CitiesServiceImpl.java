package com.itlh.weather.service.impl;

import com.itlh.weather.mapper.CitiesMapper;
import com.itlh.weather.pojo.City;
import com.itlh.weather.result.Result;
import com.itlh.weather.service.CitiesService;
import com.itlh.weather.util.JWTUtils;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Author Java小猪
 * @Date 2024/12/5 15:00
 */
@Service
@Slf4j
public class CitiesServiceImpl implements CitiesService {

    @Resource
    private CitiesMapper citiesMapper;

    @Override
    public Result findById(int id, HttpServletRequest request) {
        String token = request.getHeader("token");
        JWTUtils.verify(token);
        City city = citiesMapper.findById(id);
        return Result.success(city);
    }
}
