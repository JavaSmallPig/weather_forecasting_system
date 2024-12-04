package com.itlh.weather.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author Java小猪
 * @Date 2024/12/2 16:42
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    // 状态码，用于表示请求是否成功
    private int code;

    // 描述信息，用于对结果进行描述
    private String message;

    // 泛型，用于存储返回的数据
    private Object data;

    // 成功时的构造方法
    public static Result success(Object data) {
        return new Result(200, "Success", data);
    }

    // 失败时的构造方法
    public static Result failure(String message) {
        return new Result(500, message, null);
    }

    // 成功时的构造方法，带有自定义消息
    public static Result success(String message, Object data) {
        return new Result(200, message, data);
    }

    // 失败时的构造方法，带有自定义消息
    public static Result failure(int code, String message) {
        return new Result(code, message, null);
    }
}
