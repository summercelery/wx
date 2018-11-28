package com.wxmp.wxcms.service;

import com.wxmp.wxcms.domain.SysUser;
import com.wxmp.wxcms.mapper.SysUserDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SysUserService {

	@Resource
	private SysUserDao sysUserDao;
	
	public SysUser getSysUser(SysUser sysUser) {
		return this.sysUserDao.getSysUser(sysUser);

	}

	public SysUser getSysUserByAccount(String account) {
		return this.sysUserDao.getSysUserByAccount(account);

	}

	public SysUser getSysUserById(String userId) {
		return this.sysUserDao.getSysUserById(userId);
	}

	public void updateLoginPwd(SysUser sysUser) {
		sysUserDao.updateLoginPwd(sysUser);
	}

	public void createUser(SysUser sysUser){
		sysUserDao.createSysUser(sysUser);
	}
}
