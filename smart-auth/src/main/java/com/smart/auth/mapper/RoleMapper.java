package com.smart.auth.mapper;

import com.smart.auth.domain.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface RoleMapper extends BaseMapper<Role> {

    void updateStatusById(Long id, Integer status);
}




