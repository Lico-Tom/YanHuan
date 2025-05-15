package com.smart.auth.service;

import com.smart.auth.domain.RoleResourceRelation;
import com.baomidou.mybatisplus.extension.service.IService;
import com.smart.auth.model.RoleResourceRelationExample;

/**
* @author lizhonghao
*/
public interface RoleResourceRelationService extends IService<RoleResourceRelation> {

    boolean deleteByExample(RoleResourceRelationExample relationExample);
}
