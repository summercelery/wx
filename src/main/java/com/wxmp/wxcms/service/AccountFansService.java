package com.wxmp.wxcms.service;

import com.wxmp.wxcms.domain.AccountFans;
import com.wxmp.wxcms.mapper.AccountFansDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class AccountFansService {

	@Resource
	private AccountFansDao entityDao;

	public AccountFans getById(String id){
		return entityDao.getById(id);
	}

	public AccountFans getByOpenId(String openId){
		return entityDao.getByOpenId(openId);
	}
	
	public List<AccountFans> list(AccountFans searchEntity){
		return entityDao.list(searchEntity);
	}

	public List<AccountFans> getFansListByPage(AccountFans searchEntity){
		return entityDao.getFansListByPage(searchEntity);
	}
	
	public AccountFans getLastOpenId(){
		return entityDao.getLastOpenId();
	}
	
	public void sync(AccountFans searchEntity){
		AccountFans lastFans = entityDao.getLastOpenId();
		String lastOpenId = "";
		if(lastFans != null){
			lastOpenId = lastFans.getOpenId();
		}
	}
	public void add(AccountFans entity){
		entityDao.add(entity);
	}

	public void update(AccountFans entity){
		entityDao.update(entity);
	}

	public void delete(AccountFans entity){
		entityDao.delete(entity);
	}

	public void deleteByOpenId(String openId){
		entityDao.deleteByOpenId(openId);
	}
	public List<AccountFans> getFansByOpenIdListByPage(List<AccountFans> openIds) {
		return entityDao.getFansByOpenIdListByPage(openIds);
	}
}
