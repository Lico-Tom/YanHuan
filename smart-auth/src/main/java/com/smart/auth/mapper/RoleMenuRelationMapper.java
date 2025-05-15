package com.smart.auth.mapper;

import com.smart.auth.domain.RoleMenuRelation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.smart.auth.model.RoleMenuRelationExample;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface RoleMenuRelationMapper extends BaseMapper<RoleMenuRelation> {

    int deleteByExample(RoleMenuRelationExample relationExample);
}




