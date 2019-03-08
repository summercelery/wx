package com.wxmp.wxmobile.ctrl;

import com.wxmp.core.common.BaseCtrl;
import com.wxmp.core.util.AjaxResult;
import com.wxmp.wxmobile.domain.BusinessArticle;
import com.wxmp.wxmobile.domain.BusinessArticleType;
import com.wxmp.wxmobile.service.BusinessArticleService;
import com.wxmp.wxmobile.service.BusinessArticleTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("articleType")
public class BusinessArticleTypeCtrl  extends BaseCtrl {


    @Autowired
    private BusinessArticleTypeService businessArticleTypeService;

    @RequestMapping("getType")
    public AjaxResult getType(Long typeId){
        BusinessArticleType type = businessArticleTypeService.findById(typeId);
        return AjaxResult.success(type);
    }

    @RequestMapping("list")
    public AjaxResult list(BusinessArticleType type){
        return getResult(type,businessArticleTypeService.list(type)) ;
    }


    @RequestMapping("save")
    public AjaxResult save(BusinessArticleType type){
        businessArticleTypeService.saveBusinessArticleType(type);
        return AjaxResult.success();
    }



}
