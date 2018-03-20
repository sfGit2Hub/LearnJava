package org.mybatis.example;

import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by SF on 2017/12/25.
 */
public interface UserMapper {
    @Select("select * from users where id=#{id}")
    @Results(id = "userResult", value = {
            @Result(property = "id", column = "id", id = true),
            @Result(property = "email", column = "email"),
            @Result(property = "passport", column = "password"),
            @Result(property = "firstName", column = "firstName"),
            @Result(property = "lastName", column = "lastName"),
            @Result(property = "address", column = "address"),
            @Result(property = "city", column = "city"),
            @Result(property = "state", column = "state"),
            @Result(property = "phone", column = "phone"),
            @Result(property = "married", column = "married", javaType = Boolean.class),
            @Result(property = "orders", column = "user_id",
                    many = @Many(select = "org.mybatis.example.UserMapper.getOrderByUser"))
    })
    User selectById(long id);

    @Select("select * from order where user_id = #{id}")
    @Results({
            @Result(column = "id", property = "id", javaType = Long.class, id = true),
            @Result(column = "name", property = "name"),
            @Result(column = "description", property = "description")
    })
    List<Order> getOrderByUser(@Param("id")Long id);
}
