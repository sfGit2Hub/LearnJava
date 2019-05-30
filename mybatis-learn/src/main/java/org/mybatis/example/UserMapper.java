package org.mybatis.example;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * Created by SF on 2017/12/25.
 */
public interface UserMapper {
    @Select("select * from users where user_id=#{id}")
    @Results(id = "userResult", value = {
            @Result(property = "id", column = "user_id", id = true, javaType = Long.class),
            @Result(property = "email", column = "email"),
            @Result(property = "passport", column = "password"),
            @Result(property = "firstName", column = "firstName"),
            @Result(property = "lastName", column = "lastName"),
            @Result(property = "address", column = "address"),
            @Result(property = "city", column = "city"),
            @Result(property = "state", column = "state"),
            @Result(property = "phone", column = "phone"),
            @Result(property = "married", column = "married", javaType = Boolean.class),
            @Result(property = "orders", column = "user_id", javaType = List.class,
                    many = @Many(select = "org.mybatis.example.UserMapper.getOrderByUser", fetchType = FetchType.LAZY))
    })
    User selectById(long id);

    @Select(" select * from orders where user_id = #{id}")
    @Results({
            @Result(column = "id", property = "id", javaType = Long.class, id = true),
            @Result(column = "name", property = "name"),
            @Result(column = "description", property = "description")
    })
    List<Order> getOrderByUser(Long id);
}
