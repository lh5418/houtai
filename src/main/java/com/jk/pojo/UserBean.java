package com.jk.pojo;

import lombok.Data;

/**
 * @program: houtai
 * @description:
 * @author: 刘海
 * @create: 2021-01-12 10:26
 */
@Data
public class UserBean {
    private Integer id;
    private String name;
    private String pwd;
    private String uimg;
    private String address;


    private String rolename;
    private String roleid;
}
