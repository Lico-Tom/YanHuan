package com.smart.auth.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.smart.auth.domain.Menu;
import com.smart.auth.domain.RoleMenuRelation;
import com.smart.auth.dto.MenuNode;
import com.smart.auth.model.RoleMenuRelationExample;
import com.smart.auth.service.MenuService;
import com.smart.auth.mapper.MenuMapper;
import com.smart.auth.service.RoleMenuRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {

    private final MenuMapper menuMapper;

    private final RoleMenuRelationService roleMenuRelationService;

    @Autowired
    public MenuServiceImpl(MenuMapper menuMapper, RoleMenuRelationService roleMenuRelationService) {
        this.menuMapper = menuMapper;
        this.roleMenuRelationService = roleMenuRelationService;
    }

    @Override
    public List<Menu> listMenu(Long roleId) {
        return menuMapper.selectMenusByRoleId(roleId);
    }

    @Override
    public boolean allocMenu(Long roleId, List<Long> menuIds) {
        // TODO 先删除原有关系
        RoleMenuRelationExample relationExample = new RoleMenuRelationExample();
        relationExample.createCriteria().andRoleIdEqualTo(roleId);
        roleMenuRelationService.deleteByExample(relationExample);
        //批量插入新关系
        List<RoleMenuRelation> roleMenuRelations = menuIds.stream().map(menuId -> {
            RoleMenuRelation menuRelation = new RoleMenuRelation();
            menuRelation.setRoleId(roleId);
            menuRelation.setMenuId(menuId);
            return menuRelation;
        }).collect(Collectors.toList());
        return roleMenuRelationService.saveBatch(roleMenuRelations);
    }

    @Override
    public List<Menu> list(Long parentId, Integer pageSize, Integer pageNum) {
        return null;
    }

    @Override
    public List<MenuNode> treeList() {
        return null;
    }

    @Override
    public boolean updateHidden(Long id, Integer hidden) {
        return false;
    }
}




