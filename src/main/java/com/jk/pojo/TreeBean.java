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
public class TreeBean  {

    private Integer id;
    private String text;
    private String url;
    private String permission;
    private String flag;
    private Integer pid;
    private Boolean checked;
    private List<TreeBean> children;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    public List<TreeBean> getChildren() {
        return children;
    }

    public void setChildren(List<TreeBean> children) {
        this.children = children;
    }
}
