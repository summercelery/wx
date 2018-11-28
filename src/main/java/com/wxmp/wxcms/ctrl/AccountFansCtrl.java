package com.wxmp.wxcms.ctrl;

import com.wxmp.core.common.BaseCtrl;
import com.wxmp.core.util.AjaxResult;
import com.wxmp.wxcms.domain.AccountFans;
import com.wxmp.wxcms.service.AccountFansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping("/accountfans")
public class AccountFansCtrl extends BaseCtrl {

	@Autowired
	private AccountFansService entityService;

	@RequestMapping(value = "/info")
	@ResponseBody
	public AjaxResult getById(String id){
		AccountFans fans = entityService.getById(id);
		return AjaxResult.success(fans);
	}

	@RequestMapping(value = "/list")
	@ResponseBody
	public AjaxResult list(AccountFans searchEntity){
		List<AccountFans> fansList = this.entityService.getFansListByPage(searchEntity);
		return getResult(searchEntity,fansList);
	}
	
}
