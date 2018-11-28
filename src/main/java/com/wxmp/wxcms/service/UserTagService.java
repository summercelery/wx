package com.wxmp.wxcms.service;

import com.wxmp.wxcms.domain.UserTag;
import com.wxmp.wxcms.mapper.UserTagDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserTagService  {

	@Resource
	private UserTagDao userTagDao;
	
	public UserTag getById(Integer id) {
		return userTagDao.getById(id);
	}

	public List<UserTag> listForPage(UserTag searchEntity) {
		return userTagDao.getUserTagListByPage(searchEntity);
	}

	public void add(UserTag entity) {
		userTagDao.add(entity);
	}

	public void update(UserTag entity) {
		userTagDao.update(entity);

	}

	public void delete(UserTag entity) {
		userTagDao.delete(entity);
	}


	public Integer deleteBatchIds(String[] ids) {
		return userTagDao.deleteBatchIds(ids);
	}


	public Integer getMaxId() {
		return userTagDao.getMaxId();
	}

}
