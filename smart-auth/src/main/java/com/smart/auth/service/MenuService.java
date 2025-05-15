package com.smart.auth.service;

import com.smart.auth.domain.Menu;
import com.baomidou.mybatisplus.extension.service.IService;
import com.smart.auth.dto.MenuNode;

import java.util.List;

/**
* @author lizhonghao
*/
public interface MenuService extends IService<Menu> {

    List<Menu> listMenu(Long roleId);

    boolean allocMenu(Long roleId, List<Long> menuIds);

    List<Menu> list(Long parentId, Integer pageSize, Integer pageNum);

    List<MenuNode> treeList();

    boolean updateHidden(Long id, Integer hidden);
}
