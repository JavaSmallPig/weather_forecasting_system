package com.itlh.weather.service;

import com.itlh.weather.result.Result;
import jakarta.servlet.http.HttpServletRequest;

/**
 * @Author Java小猪
 * @Date 2024/12/5 15:00
 */
public interface CitiesService {
    Result findById(int id, HttpServletRequest request);
}
