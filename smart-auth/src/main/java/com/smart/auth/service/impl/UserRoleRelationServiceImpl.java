package com.smart.auth.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.smart.auth.domain.UserRoleRelation;
import com.smart.auth.service.UserRoleRelationService;
import com.smart.auth.mapper.UserRoleRelationMapper;
import org.springframework.stereotype.Service;


@Service
public class UserRoleRelationServiceImpl extends ServiceImpl<UserRoleRelationMapper, UserRoleRelation>
    implements UserRoleRelationService{

}




