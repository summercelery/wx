
package com.wxmp.wxapi.service;

import com.alibaba.fastjson.JSONObject;
import com.wxmp.core.exception.WxErrorException;
import com.wxmp.wxapi.process.MpAccount;
import com.wxmp.wxapi.vo.MsgRequest;
import com.wxmp.wxcms.domain.AccountFans;

/**
 * 我的微信服务接口，主要用于结合自己的业务和微信接口
 */
public interface MyService {
	
	//消息处理
	public String processMsg(MsgRequest msgRequest, MpAccount mpAccount) throws WxErrorException;

	//发布菜单
	public JSONObject publishMenu(MpAccount mpAccount) throws WxErrorException;

	//删除菜单
	public JSONObject deleteMenu(MpAccount mpAccount) throws WxErrorException;

	//获取用户列表
	public boolean syncAccountFansList(MpAccount mpAccount) throws WxErrorException;

	//获取单个用户信息
	public AccountFans syncAccountFans(String openId, MpAccount mpAccount, boolean merge) throws WxErrorException;

	//根据openid 获取粉丝，如果没有，同步粉丝
	public AccountFans getFansByOpenId(String openid, MpAccount mpAccount) throws WxErrorException;

	//同步服务器的用户标签
	public boolean syncUserTagList(MpAccount mpAccount)throws WxErrorException;
}
