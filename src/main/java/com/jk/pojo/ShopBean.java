package com.jk.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @program: houtai
 * @description:
 * @author: 刘海
 * @create: 2021-01-12 16:41
 */
@Data
@Document(indexName = "shopping",type = "2007a")
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
    @Id
    private Integer id;
  @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String sname;
  @Field(type = FieldType.Keyword)
    private Integer stypeid;
  @Field(type = FieldType.Keyword)
    private Double sprice;
  @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String sinfo;
  @Field(type = FieldType.Keyword)
    private String sdate;
  @Field(type = FieldType.Keyword)
    private Integer sbaodate;
  @Field(type = FieldType.Keyword)
    private String simage;
  @Field(type = FieldType.Keyword)
    private Integer scount;
  @Field(type = FieldType.Keyword)
    private Integer ordernum;
 @Transient
    private Integer status;
  @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String stypename;//类型



}
