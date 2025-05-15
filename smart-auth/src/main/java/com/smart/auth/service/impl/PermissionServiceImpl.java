package com.smart.auth.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.smart.auth.domain.Permission;
import com.smart.auth.service.PermissionService;
import com.smart.auth.mapper.PermissionMapper;
import org.springframework.stereotype.Service;


@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission>
    implements PermissionService{

}




