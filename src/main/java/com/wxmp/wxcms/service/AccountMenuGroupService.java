package com.wxmp.wxcms.service;

import com.wxmp.wxcms.domain.AccountMenu;
import com.wxmp.wxcms.domain.AccountMenuGroup;
import com.wxmp.wxcms.mapper.AccountMenuDao;
import com.wxmp.wxcms.mapper.AccountMenuGroupDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class AccountMenuGroupService {

	@Resource
	private AccountMenuGroupDao entityDao;

	@Resource
	private AccountMenuDao menuDao;

	public AccountMenuGroup getById(String id){
		return entityDao.getById(id);
	}

	public List<AccountMenuGroup> list(AccountMenuGroup searchEntity){
		return entityDao.list(searchEntity);
	}

	public List<AccountMenuGroup> getGroupListByPage(AccountMenuGroup searchEntity){
		return entityDao.getGroupListByPage(searchEntity);
	}

	public void add(AccountMenuGroup entity){
		entityDao.add(entity);
	}

	public void update(AccountMenuGroup entity){
		entityDao.update(entity);
	}

	public void delete(AccountMenuGroup entity){
		entityDao.deleteAllMenu(entity);
		entityDao.delete(entity);
	}


	public void deleteById(long id) {
		AccountMenu searchEntity = new AccountMenu();
		searchEntity.setGid(id);
		List<AccountMenu> menuList = menuDao.listForPage(searchEntity);
		if(menuList != null && menuList.size() > 0){
				//删除菜单组
				entityDao.deleteGroupById(id);
				//删除菜单
				entityDao.deleteMenuByGId(id);
		}else{
			entityDao.deleteGroupById(id);
		}
	}
}
