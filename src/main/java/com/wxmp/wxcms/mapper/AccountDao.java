package com.wxmp.wxcms.mapper;

import com.wxmp.wxcms.domain.Account;

import java.util.List;

/**
 *
 * @author hermit
 * @version 2.0
 * @date 2018-04-17 10:54:58
 */

public interface AccountDao {

	public Account getById(Long id);
	
	public Account getByAccount(String account);
	
	public Account getSingleAccount();

	public List<Account> listAccount(Account searchEntity);

	public void add(Account entity);

	public void update(Account entity);

	public void delete(Account entity);



}
