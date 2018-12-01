package com.wxmp.wxcms.ctrl;

import com.wxmp.core.common.Constants;
import com.wxmp.core.util.AjaxResult;
import com.wxmp.core.util.StringUtil;
import com.wxmp.core.util.UUIDUtil;
import com.wxmp.wxcms.domain.BusinessArticleType;
import com.wxmp.wxcms.service.BusinessArticleTypeService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@Slf4j
@RequestMapping("articleType")
public class BusinessArticleCtrl {


    @Autowired
    private BusinessArticleTypeService businessArticleTypeService;

    public AjaxResult save(BusinessArticleType type){
        businessArticleTypeService.saveBusinessArticleType(type);
        return AjaxResult.success();
    }

}
