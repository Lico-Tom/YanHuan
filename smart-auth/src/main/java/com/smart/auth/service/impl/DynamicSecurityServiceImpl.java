package com.smart.auth.service.impl;

import com.smart.auth.domain.Resource;
import com.smart.auth.service.ResourceService;
import com.smart.security.component.DynamicSecurityService;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class DynamicSecurityServiceImpl implements DynamicSecurityService {

    private final ResourceService resourceService;

    public DynamicSecurityServiceImpl(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    @Override
    public Map<String, ConfigAttribute> loadDataSource() {
        Map<String, ConfigAttribute> map = new ConcurrentHashMap<>();
        List<Resource> resourceList = resourceService.listAll();
        for (Resource resource : resourceList) {
            map.put(resource.getUrl(), new SecurityConfig(resource.getId() + ":" + resource.getName()));
        }
        return map;
    }
}
