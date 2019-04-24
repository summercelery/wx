package com.wxmp.wxmobile.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.wxmp.core.page.Page;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
public class BusinessArticle extends Page implements Serializable {
    private String id;
    private String name;
    private String title;
    private String content;
    private String shortContent;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss",iso= DateTimeFormat.ISO.DATE_TIME)
    private Date createTime;
    private String url;
    private String picUrl;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss",iso= DateTimeFormat.ISO.DATE_TIME)
    private Date updateTime;
    private Long typeId;
    private String typeName;

}
