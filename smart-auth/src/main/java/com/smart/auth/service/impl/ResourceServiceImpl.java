package com.smart.auth.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.smart.auth.domain.Resource;
import com.smart.auth.domain.RoleResourceRelation;
import com.smart.auth.model.RoleResourceRelationExample;
import com.smart.auth.service.ResourceService;
import com.smart.auth.mapper.ResourceMapper;
import com.smart.auth.service.RoleResourceRelationService;
import com.smart.auth.service.UserCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ResourceServiceImpl extends ServiceImpl<ResourceMapper, Resource> implements ResourceService {

    private final ResourceMapper resourceMapper;

    private final UserCacheService userCacheService;

    private final RoleResourceRelationService roleResourceRelationService;

    @Autowired
    public ResourceServiceImpl(ResourceMapper resourceMapper,
                               RoleResourceRelationService roleResourceRelationService,
                               UserCacheService userCacheService) {
        this.resourceMapper = resourceMapper;
        this.roleResourceRelationService = roleResourceRelationService;
        this.userCacheService = userCacheService;
    }

    @Override
    public List<Resource> listResource(Long roleId) {
        return resourceMapper.listResourceByRoleId(roleId);
    }

    @Override
    public boolean allocResource(Long roleId, List<Long> resourceIds) {
        //先删除原有关系
        RoleResourceRelationExample relationExample = new RoleResourceRelationExample();
        relationExample.createCriteria().andRoleIdEqualTo(roleId);
        roleResourceRelationService.deleteByExample(relationExample);
        List<RoleResourceRelation> roleResourceRelations = resourceIds.stream().map(resourceId -> {
            RoleResourceRelation relation = new RoleResourceRelation();
            relation.setRoleId(roleId);
            relation.setResourceId(resourceId);
            return relation;
        }).collect(Collectors.toList());
        boolean isSaveBatch = roleResourceRelationService.saveBatch(roleResourceRelations);
        userCacheService.delResourceListByRole(roleId);
        return isSaveBatch;
    }

    @Override
    public IPage<Resource> list(Resource resource, Integer pageSize, Integer currentPage) {
        QueryWrapper<Resource> wrapper = new QueryWrapper<>();
        wrapper.eq(resource.getId() != null, "id", resource.getId());
        wrapper.eq(resource.getName() != null, "name", resource.getName());
        wrapper.eq(resource.getCategoryId() != -1, "category_id", resource.getCategoryId());
        wrapper.eq(resource.getUrl() != null, "url", resource.getUrl());
        wrapper.eq(resource.getCreateTime() != null, "create_time", resource.getCreateTime());
        Page<Resource> page = new Page<>(currentPage, pageSize, count(wrapper));
        wrapper.last("LIMIT " + pageSize + " OFFSET " + (pageSize * (currentPage - 1)));
        return resourceMapper.selectPage(page, wrapper);
    }

    @Override
    public List<Resource> getResourceList(Long userId) {
        List<Resource> resourceList = resourceMapper.getResourceList(userId);
        return resourceList;
    }

    @Override
    public List<Resource> listAll() {
        return resourceMapper.selectList(null);
    }
}




