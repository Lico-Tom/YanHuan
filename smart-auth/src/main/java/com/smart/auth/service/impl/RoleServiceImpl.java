package com.smart.auth.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.smart.auth.domain.Role;
import com.smart.auth.domain.UserRoleRelation;
import com.smart.auth.service.RoleService;
import com.smart.auth.mapper.RoleMapper;
import com.smart.auth.service.UserRoleRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    private final RoleMapper roleMapper;

    private final UserRoleRelationService userRoleRelationService;

    @Autowired
    public RoleServiceImpl(RoleMapper roleMapper, UserRoleRelationService userRoleRelationService) {
        this.roleMapper = roleMapper;
        this.userRoleRelationService = userRoleRelationService;
    }

    @Override
    public List<Role> list(String keyword, Integer pageSize, Integer pageNum) {
        QueryWrapper<Role> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name", keyword);
        Page<Role> rolePage = new Page<>();
        rolePage.setCurrent(pageNum);
        rolePage.setSize(pageSize);
        return roleMapper.selectList(rolePage, queryWrapper);
    }

    @Override
    public boolean updateStatusById(Long id, Integer status) {
        roleMapper.updateStatusById(id, status);
        return true;
    }

    @Override
    public List<Role> getRoleList(Long userId) {
        QueryWrapper<UserRoleRelation> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("admin_id", userId);
        List<UserRoleRelation> roleRelations = userRoleRelationService.list(queryWrapper);
        List<Long> roleIds = roleRelations.stream().map(UserRoleRelation::getRoleId).toList();
        return roleMapper.selectList(new QueryWrapper<Role>().lambda().in(Role::getId, roleIds));
    }

    @Override
    public boolean updateRole(Long userId, List<Long> roleIds) {
        return false;
    }
}




