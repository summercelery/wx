package com.wxmp.wxcms.ctrl;
import com.wxmp.core.common.BaseCtrl;
import com.wxmp.core.util.AjaxResult;
import com.wxmp.core.util.MD5Util;
import com.wxmp.core.util.UUIDUtil;
import com.wxmp.wxapi.process.WxMemoryCacheClient;
import com.wxmp.wxcms.domain.Account;
import com.wxmp.wxcms.domain.SysUser;
import com.wxmp.wxcms.service.AccountService;
import com.wxmp.wxcms.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@RestController
@RequestMapping("user")
@Slf4j
public class SysUserCtrl extends BaseCtrl {

	@Autowired
	private SysUserService sysUserService;
	@Autowired
	private AccountService accountService;


	@PostMapping(value = "/login")
	public AjaxResult login(SysUser user, Boolean rememberMe) {

		log.debug(user.getAccount() + "正在登陆........");
		UsernamePasswordToken token = new UsernamePasswordToken(user.getAccount(), user.getPwd(), rememberMe);
		Subject currentSubject = SecurityUtils.getSubject();
		//设置登陆者默认公众号
		Account account = accountService.getSingleAccount();
		if (account != null) {
			WxMemoryCacheClient.setAccount(account.getAccount());
		}
		try {
			currentSubject.login(token);
		} catch (UnknownAccountException | IncorrectCredentialsException e) {
			return AjaxResult.failure("用户名或密码错误");
		}
		log.debug(user.getAccount() + "登陆成功........");
		SysUser sysUser = (SysUser) currentSubject.getPrincipal();
		return AjaxResult.success(sysUser.getTrueName());
	}

	@PostMapping(value = "/updatepwd")
	public AjaxResult updatepwd(SysUser user) {
		if (!((SysUser)SecurityUtils.getSubject().getPrincipal()).getPwd().equals(MD5Util.getShiroMD5(user.getPwd(),user.getId()))) {
			return AjaxResult.failure("用户名或密码错误");
		}
		user.setNewpwd(MD5Util.getShiroMD5(user.getNewpwd(),user.getId() ));
		this.sysUserService.updateLoginPwd(user);
		//注销用户
		SecurityUtils.getSubject().logout();
		return AjaxResult.success();
	}

	/**
	 * 用户退出
	 * @return
	 */
	@RequestMapping("logout")
	public AjaxResult logout(HttpServletRequest request) {
		SecurityUtils.getSubject().logout();
		return AjaxResult.success();
	}

	/**
	 * 注册
	 * @param user
	 * @return
	 */
	@PostMapping(value = "/register")
	public AjaxResult register(SysUser user) {
		SysUser user1 = new SysUser();
		user1.setAccount(user.getAccount());
		user.setId(UUIDUtil.getUUID());
		user1.setId(user.getId());
		String a = MD5Util.getShiroMD5(user.getPwd(),user.getId());
		user1.setPwd(a);
		sysUserService.createUser(user1);
		return AjaxResult.success();
	}

}
