package org.mybatis.example;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by SF on 2018/3/20.
 */
public interface OrderMapper {
    @Select("select * from order where order.user_id = #{id}")
    @Results({
            @Result(column = "id", property = "id")
    })
    List<Order> getOrderByUserId(Long id);
}
