package com.wxmp.wxmobile.domain;

import lombok.Data;

import java.util.Date;

@Data
public class BusinessArticleType {

    private Long id;
    private String name;
    private Date createTime;
    private String url;
    private Date updateTime;

}
