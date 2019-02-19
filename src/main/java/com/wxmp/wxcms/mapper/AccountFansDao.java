package com.wxmp.wxcms.mapper;

import com.wxmp.wxcms.domain.AccountFans;

import java.util.List;

/**
 *
 * @author hermit
 * @version 2.0
 * @date 2018-04-17 10:54:58
 */
public interface AccountFansDao {

	public AccountFans getById(String id);

	public AccountFans getByOpenId(String openId);
	
	public List<AccountFans> list(AccountFans searchEntity);

	public Integer getTotalItemsCount(AccountFans searchEntity);
	
	public List<AccountFans> getFansListByPage(AccountFans searchEntity);

	public AccountFans getLastOpenId();
	
	public void add(AccountFans entity);
	
	public void addList(List<AccountFans> list);

	public void update(AccountFans entity);

	public void delete(AccountFans entity);

	public void deleteByOpenId(String openId);

	/**
	 * 分页查询粉丝列表
	 * @param searchEntity
	 * @return
	 */
	public List<AccountFans> getAccountFansList(AccountFans searchEntity);
	/**
	 * 根据多个openId查看粉丝列表
	 * @param openIds
	 * @return List
	 */
	public List<AccountFans> getFansByOpenIdListByPage(List<AccountFans> openIds);
}
