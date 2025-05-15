package com.smart.auth.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.smart.auth.domain.RoleResourceRelation;
import com.smart.auth.model.RoleResourceRelationExample;
import com.smart.auth.service.RoleResourceRelationService;
import com.smart.auth.mapper.RoleResourceRelationMapper;
import org.springframework.stereotype.Service;


@Service
public class RoleResourceRelationServiceImpl extends ServiceImpl<RoleResourceRelationMapper, RoleResourceRelation>
    implements RoleResourceRelationService{

    @Override
    public boolean deleteByExample(RoleResourceRelationExample relationExample) {
        return false;
    }
}




