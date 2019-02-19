package com.wxmp.wxcms.domain;

import lombok.Data;

import java.io.Serializable;

/**
 *
 * @author hermit
 * @version 2.0
 * @date 2018-04-17 10:54:58
 */
@Data
public class SysConfig implements Serializable {
    private String jkey;

    private String jvalue;

    private String description;
}
