package com.smart.auth.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.smart.auth.domain.ResourceCategory;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author lizhonghao
*/
public interface ResourceCategoryService extends IService<ResourceCategory> {

    IPage<ResourceCategory> list(ResourceCategory resourceCategory, int pageSize, int currentPage);
}
