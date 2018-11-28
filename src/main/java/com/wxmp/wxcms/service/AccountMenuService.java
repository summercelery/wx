package com.wxmp.wxcms.service;

import com.wxmp.wxcms.domain.AccountMenu;
import com.wxmp.wxcms.mapper.AccountMenuDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class AccountMenuService{

	@Resource
	private AccountMenuDao entityDao;

	public AccountMenu getById(String id) {
		return entityDao.getById(id);
	}

	public List<AccountMenu> listWxMenus(AccountMenu entity) {
		return entityDao.listWxMenus(entity);
	}

	public List<AccountMenu> listParentMenu(AccountMenu entity) {
		return entityDao.listParentMenu(entity);
	}

	public void add(AccountMenu entity) {
		entityDao.add(entity);
	}

	public void update(AccountMenu entity) {
		entityDao.update(entity);
	}

	public void delete(AccountMenu entity) {
		entityDao.delete(entity);
	}



}
