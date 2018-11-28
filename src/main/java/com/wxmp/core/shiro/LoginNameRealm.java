package com.wxmp.core.shiro;

import com.wxmp.wxcms.domain.SysUser;
import com.wxmp.wxcms.service.SysUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * 用户名密码登陆的权限验证
 */
public class LoginNameRealm extends AuthorizingRealm {


    @Override
    public String getName(){
        return "loginNameRealm";
    }

    @Autowired
    private SysUserService sysUserService;


    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
        String loginName = token.getUsername();
        SysUser user = sysUserService.getSysUserByAccount(loginName);
        if(null == user){
            throw new UnknownAccountException();
        }

        return new SimpleAuthenticationInfo(user,user.getPwd(),getName());
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }
}
