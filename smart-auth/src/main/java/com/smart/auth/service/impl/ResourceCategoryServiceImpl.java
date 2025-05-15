package com.smart.auth.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.smart.auth.domain.ResourceCategory;
import com.smart.auth.service.ResourceCategoryService;
import com.smart.auth.mapper.ResourceCategoryMapper;
import org.springframework.stereotype.Service;


@Service
public class ResourceCategoryServiceImpl extends ServiceImpl<ResourceCategoryMapper, ResourceCategory>
    implements ResourceCategoryService{

    private final ResourceCategoryMapper resourceCategoryMapper;

    public ResourceCategoryServiceImpl(ResourceCategoryMapper resourceCategoryMapper) {
        this.resourceCategoryMapper = resourceCategoryMapper;
    }

    @Override
    public IPage<ResourceCategory> list(ResourceCategory resourceCategory, int pageSize, int currentPage) {
        QueryWrapper<ResourceCategory> wrapper = new QueryWrapper<>();
        wrapper.eq(resourceCategory.getId() != null, "id", resourceCategory.getId());
        wrapper.eq(resourceCategory.getName() != null, "name", resourceCategory.getName());
        wrapper.eq(resourceCategory.getCreateTime() != null, "create_time", resourceCategory.getCreateTime());
        Page<ResourceCategory> page = new Page<>(currentPage, pageSize, count(wrapper));
        wrapper.last("LIMIT " + pageSize + " OFFSET " + (pageSize * (currentPage - 1)));
        return resourceCategoryMapper.selectPage(page, wrapper);
    }
}




