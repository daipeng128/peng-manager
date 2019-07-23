package com.peng.manager.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class AuthoriytTree {
    private Integer id;  //人员编号  
    private String text; //人员名称  
    private Boolean checked = false; //是否选中  
    private List<AuthoriytTree> children; //子节点


    public AuthoriytTree(Integer id, String text) {
        this.id = id;
        this.text = text;
    }
}