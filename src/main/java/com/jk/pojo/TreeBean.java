/**
 * <pre>项目名称:week_employee_lh_b
 * 文件名称:TreeBean.java
 * 包名:com.jk.lh.pojo
 * 创建日期:2020年11月16日下午7:25:06
 * Copyright (c) 2020, yuxy123@gmail.com All Rights Reserved.</pre>
 */
package com.jk.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * <pre>项目名称：week_employee_lh_b    
 * 类名称：TreeBean    
 * 类描述：    
 * 创建人：liuh
 * 创建时间：2020年11月16日 下午7:25:06    
 * 修改人：liuh
 * 修改时间：2020年11月16日 下午7:25:06    
 * 修改备注：       
 * @version </pre>    
 */
@Data
public class TreeBean  {

    private Integer id;
    private String text;
    private String url;
    private String permission;
    private String flag;
    private Integer pid;
    private Boolean checked;
    private List<TreeBean> children;


}
