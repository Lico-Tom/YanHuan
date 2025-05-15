package com.smart.auth.mapper;

import com.smart.auth.domain.Resource;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface ResourceMapper extends BaseMapper<Resource> {

    List<Resource> listResourceByRoleId(Long roleId);

    List<Resource> getResourceList(Long userId);
}




