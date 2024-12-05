package com.itlh.weather.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author Java小猪
 * @Date 2024/12/5 14:58
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class City {
    private int id;
    private String name;
    private String country;
}
