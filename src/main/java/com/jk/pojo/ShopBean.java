package com.jk.pojo;

import lombok.Data;

/**
 * @program: houtai
 * @description:
 * @author: 刘海
 * @create: 2021-01-12 16:41
 */
@Data
public class ShopBean {
  /*  sname	String	商品名称
    stypeid	int	商品类型
    sprice	double	商品价格
    sinfo	String 	商品描述
    sdate	Date	商品出厂日期
    sbaodate	int	保质期
    simage	String	图片
    scount	Int	库存
    ordernum	Int	购买量
    status	Int	商品状态*/
    private Integer id;
    private String sname;
    private Integer stypeid;
    private Double sprice;
    private String sinfo;
    private String sdate;
    private Integer sbaodate;
    private String simage;
    private Integer scount;
    private Integer ordernum;
    private Integer status;

    private String stypename;//类型



}
