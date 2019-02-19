package com.wxmp.wxcms.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.wxmp.core.page.Page;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author fuzi Kong
 * @version 2.0
 * @date 2018-05-30 10:54:58
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ToString
public class UserTag extends Page {
    
    private Integer id;// 主键ID
    
    private String name;// 标签名称
    
    private Integer count = 0;// 该标签的粉丝数量
    
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss", iso = DateTimeFormat.ISO.DATE_TIME)
    private Date createTime = new Date();// 创建时间
}
