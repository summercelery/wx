
package com.wxmp.core.common;

import com.wxmp.core.page.Page;
import com.wxmp.core.util.AjaxResult;
import com.wxmp.core.util.StringUtil;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Controller基础公共类
 *
 */
public class BaseCtrl {
    
    @Resource
    protected HttpServletRequest request;
    
    @Resource
    protected HttpServletResponse response;
    
    /**
     * 初始化属性，在每个方法执行前执行该赋值方法
     *
     * @param request
     * @param response
     * @author hermit
     * @date 2017 -10-17 15:57:10
     */
    @ModelAttribute
    public void setAttribute(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    public AjaxResult getResult(Page page, Object data){
        AjaxResult result = new AjaxResult();
        Page newPage = new Page();
        newPage.setPage(page.getPage());
        newPage.setPageSize(page.getPageSize());
        newPage.setTotal(page.getTotal());
        newPage.setTotalPage(page.getTotalPage());
        result.setPage(newPage);
        result.setData(data);
        result.setSuccess(true);
        return result;
    }

    protected static boolean validate(HttpServletRequest request, String validateCode) {
        if(StringUtil.isBlank(validateCode)) {
            return false;
        } else {
            String code = (String)request.getSession().getAttribute("adminVerifyCode");
            return validateCode.toUpperCase().equals(code);
        }
    }

//    /**
//     * 获取用户
//     * @return
//     */
//    public SysUser getUser() {
//        return SessionUtil.getUser();
//    }
}
