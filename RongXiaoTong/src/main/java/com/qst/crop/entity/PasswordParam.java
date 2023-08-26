package com.qst.crop.entity;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;

@Data
public class PasswordParam {
    @NotBlank
    private String oldPassword;
    @NotBlank
    @Pattern(  regexp = "^[a-zA-Z][a-zA-Z0-9_]{5,17}$",message = "密码必须以字母开头，长度在6-18之间，只能包含英文字符、数字和下划线")
    private String newPassword;
}
