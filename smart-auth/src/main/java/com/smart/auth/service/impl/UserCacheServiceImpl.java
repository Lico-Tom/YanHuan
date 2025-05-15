package com.smart.auth.service.impl;

import com.smart.auth.domain.Resource;
import com.smart.auth.domain.User;
import com.smart.auth.service.UserCacheService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserCacheServiceImpl implements UserCacheService {

    @Override
    public void delUser(Long userId) {

    }

    @Override
    public void delResourceList(Long adminId) {

    }

    @Override
    public void delResourceListByRole(Long roleId) {

    }

    @Override
    public void delResourceListByRoleIds(List<Long> roleIds) {

    }

    @Override
    public void delResourceListByResource(Long resourceId) {

    }

    @Override
    public User getUser(String username) {
        return null;
    }

    @Override
    public void setUser(User user) {

    }

    @Override
    public List<Resource> getResourceList(Long userId) {
        return null;
    }

    @Override
    public void setResourceList(Long adminId, List<Resource> resourceList) {

    }
}
