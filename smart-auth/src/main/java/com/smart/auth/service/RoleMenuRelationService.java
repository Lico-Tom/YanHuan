package com.smart.auth.service;

import com.smart.auth.domain.RoleMenuRelation;
import com.baomidou.mybatisplus.extension.service.IService;
import com.smart.auth.model.RoleMenuRelationExample;

/**
* @author lizhonghao
*/
public interface RoleMenuRelationService extends IService<RoleMenuRelation> {

    void deleteByExample(RoleMenuRelationExample relationExample);
}
