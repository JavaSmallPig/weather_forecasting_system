package com.itlh.weather.controller;

import com.itlh.weather.result.Result;
import com.itlh.weather.service.CitiesService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Java小猪
 * @Date 2024/12/5 14:57
 */
@RestController
@RequestMapping("/city")
public class CitiesController {

    @Resource
    private CitiesService citiesService;

    @GetMapping("/select/{id}")
    public Result selectOne(@PathVariable("id") int id, HttpServletRequest request) {
        return citiesService.findById(id, request);
    }
}
