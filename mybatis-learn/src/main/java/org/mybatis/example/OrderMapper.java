package org.mybatis.example;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by SF on 2018/3/20.
 */
public interface OrderMapper {
    @Select("select * from order where user_id = #{id}")
    @Results({
            @Result(column = "id", property = "id", javaType = Long.class, id = true),
            @Result(column = "name", property = "name"),
            @Result(column = "description", property = "description")
    })
    List<Order> getOrderByUser(@Param("id")Long id);
}
