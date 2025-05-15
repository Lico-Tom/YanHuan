package com.smart.auth.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.smart.auth.domain.UpdatePasswordParam;
import com.smart.auth.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.smart.auth.domain.UserParam;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;


public interface UserService extends IService<User> {

    User register(UserParam userParam);

    String login(String username, String password);

    String refreshToken(String token);

    User getAdminByUsername(String username);

    List<User> list(String keyword, int pageSize, int pageNum);

    IPage<User> list(int currentPage, int pageSize, User user);

    void updatePassword(UpdatePasswordParam updatePasswordParam);

    UserDetails loadUserByUsername(String username);

    UserCacheService getCacheService();

}
