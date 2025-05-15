package com.smart.auth.service;

import com.smart.auth.domain.Resource;
import com.smart.auth.domain.User;

import java.util.List;

/**
 * 后台用户缓存操作Service
 */
public interface UserCacheService {

    void delUser(Long userId);

    void delResourceList(Long adminId);

    void delResourceListByRole(Long roleId);

    void delResourceListByRoleIds(List<Long> roleIds);

    void delResourceListByResource(Long resourceId);

    User getUser(String username);

    void setUser(User user);

    List<Resource> getResourceList(Long userId);

    void setResourceList(Long adminId, List<Resource> resourceList);
}
