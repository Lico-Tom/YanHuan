package com.smart.auth.service;

import com.smart.auth.domain.Role;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
* @author lizhonghao
*/
public interface RoleService extends IService<Role> {

    List<Role> list(String keyword, Integer pageSize, Integer pageNum);

    boolean updateStatusById(Long id, Integer status);

    List<Role> getRoleList(Long userId);

    @Transactional(rollbackForClassName = "updateRollback()")
    boolean updateRole(Long userId, List<Long> roleIds);

}
