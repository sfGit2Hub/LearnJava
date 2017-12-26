package org.mybatis.example;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

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
            @Result(property = "phone", column = "phone")
    })
    User selectById(long id);
}
