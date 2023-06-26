package com.qst.crop.entity;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import java.math.BigInteger;
import java.util.List;

/**
 * @author lzh
 * @creat 2022-08-10 14:57
 */
@Data
public class Recommend {
    private String userName;
    private String realName;
    private String phone;
    private String address;

    private String avatar;
    private Integer area;

    private String item;

    private String amount;
    private Integer num;
}
