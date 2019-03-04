package com.wxmp.wxmobile.ctrl;

import com.wxmp.core.util.AjaxResult;
import com.wxmp.wxmobile.domain.BusinessArticleType;
import com.wxmp.wxmobile.service.BusinessArticleTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
