package com.smart.auth.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.smart.auth.domain.Resource;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author lizhonghao
*/
public interface ResourceService extends IService<Resource> {

    List<Resource> listResource(Long roleId);

    boolean allocResource(Long roleId, List<Long> resourceIds);

    IPage<Resource> list(Resource resource, Integer pageSize, Integer pageNum);

    List<Resource> getResourceList(Long userId);

    List<Resource> listAll();
}
