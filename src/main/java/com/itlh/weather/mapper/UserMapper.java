package com.itlh.weather.mapper;

import com.itlh.weather.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

/**
 * @author Diamond
 * @description 针对表【users】的数据库操作Mapper
 * @createDate 2024-12-02 16:18:11
 * @Entity com.itlh.weather.pojo.Users
 */
public interface UserMapper {
    /**
     * 注册
     *
     * @param username
     * @param md5Password
     * @param email
     */
    @Insert("insert into users(username,password,email,role,created_at)" +
            "values (#{username},#{md5Password},#{email},default,now())")
    void save(String username, String md5Password, String email);

    /**
     * 根据用户名查找用户
     *
     * @param username
     * @return
     */
    @Select("select *from users where username = #{username}")
    User selectByName(String username);

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    @Select("select * from users where id = #{id};")
    User findById(int id);
}




