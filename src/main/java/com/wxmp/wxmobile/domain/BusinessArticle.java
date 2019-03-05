package com.wxmp.wxmobile.domain;

import lombok.Data;

import java.util.Date;

@Data
public class BusinessArticle {
    private String id;
    private String name;
    private String title;
    private String content;
    private String shortContent;
    private Date createTime;
    private String url;
    private String picName;
    private Date updateTime;
    private BusinessArticleType type;

}
