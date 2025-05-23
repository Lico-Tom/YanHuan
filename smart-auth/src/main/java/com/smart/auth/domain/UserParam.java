package com.smart.auth.domain;

import io.swagger.v3.oas.annotations.media.SchemaProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;


@Data
public class UserParam {

    @NotEmpty
    @SchemaProperty(name = "用户名")
    private String username;

    @NotEmpty
    @SchemaProperty(name = "密码")
    private String password;

    @SchemaProperty(name = "用户头像")
    private String icon;

    @Email
    @SchemaProperty(name = "邮箱")
    private String email;

    @SchemaProperty(name = "用户昵称")
    private String nickName;

    @SchemaProperty(name = "备注")
    private String note;
}
