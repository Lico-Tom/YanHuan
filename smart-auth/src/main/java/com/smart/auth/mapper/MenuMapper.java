package com.smart.auth.mapper;

import com.smart.auth.domain.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface MenuMapper extends BaseMapper<Menu> {

    List<Menu> selectMenusByRoleId(Long roleId);
}




