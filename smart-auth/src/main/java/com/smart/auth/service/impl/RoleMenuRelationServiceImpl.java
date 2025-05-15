package com.smart.auth.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.smart.auth.domain.RoleMenuRelation;
import com.smart.auth.model.RoleMenuRelationExample;
import com.smart.auth.service.RoleMenuRelationService;
import com.smart.auth.mapper.RoleMenuRelationMapper;
import org.springframework.stereotype.Service;


@Service
public class RoleMenuRelationServiceImpl extends ServiceImpl<RoleMenuRelationMapper, RoleMenuRelation>
    implements RoleMenuRelationService{

    @Override
    public void deleteByExample(RoleMenuRelationExample relationExample) {

    }
}




