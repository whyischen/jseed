package com.whyischen.projectwebapp.mapper;

import com.whyischen.projectwebapp.entity.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface UserMapper {
    @Select("select * from `user` where id = #{id}")
    User getById(Long id);

}
