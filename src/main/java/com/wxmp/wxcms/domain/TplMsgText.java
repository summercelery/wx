package com.wxmp.wxcms.domain;

import lombok.Data;

/**
 *
 * @author hermit
 * @version 2.0
 * @date 2018-04-17 10:54:58
 */
@Data
public class TplMsgText extends MsgBase {
	private String title;//消息标题
	private String content;//消息内容
	private Long baseId;//消息主表id
	private String tplId;//消息主表id
	private String wxTpl;//微信模板
}
