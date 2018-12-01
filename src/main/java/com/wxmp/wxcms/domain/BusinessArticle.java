package com.wxmp.wxcms.domain;

import lombok.Data;

import java.util.Date;

@Data
public class BusinessArticle {
    private String id;
    private String name;
    private String title;
    private String content;
    private Date createTime;
    private String url;
    private Date updateTime;
    private BusinessArticleType type;

}
