package com.itlh.weather;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Diamond
 */
@SpringBootApplication
@MapperScan("com.itlh.weather.mapper")
public class WeatherForecastingSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeatherForecastingSystemApplication.class, args);
    }

}
