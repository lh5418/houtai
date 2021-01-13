package com.jk.pojo;

import lombok.Data;

/**
 * @program: houtai
 * @description:
 * @author: 刘海
 * @create: 2021-01-13 10:22
 */
@Data
public class OrderBean {
    private Integer id;
    private String sname;
    private Integer stypeid;
    private Double sprice;
    private Integer userid;
    private Integer ordernum;
    private Double ordersum;
    private String ordertime;
    private String simage;
    private Integer orderstataus;


    private String stypename;
    private String name;
}
