package com.wxmp.wxcms.mapper;

import com.wxmp.wxcms.domain.SysUser;

/**
 *
 * @author hermit
 * @version 2.0
 * @date 2018-04-17 10:54:58
 */
public interface SysUserDao {

	/**
	 * 根据用户名密码查询
	 * @param sysUser
	 * @return
	 */
    public SysUser getSysUser(SysUser sysUser);
    
	/**
	 * 根据用户名密码查询
	 * @param userId
	 * @return
	 */
    public SysUser getSysUserById(String userId);
    
    /**
     * 修改登录密码
     * @param sysUser
     */
    public void updateLoginPwd(SysUser sysUser);

	/**
	 * 根据账户名查找用户
	 * @return
	 */
	public SysUser getSysUserByAccount(String account);

	public void createSysUser(SysUser sysUser);
}
