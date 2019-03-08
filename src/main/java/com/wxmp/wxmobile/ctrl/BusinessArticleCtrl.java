package com.wxmp.wxmobile.ctrl;

import com.wxmp.core.util.AjaxResult;
import com.wxmp.wxmobile.domain.BusinessArticle;
import com.wxmp.wxmobile.domain.BusinessArticleType;
import com.wxmp.wxmobile.service.BusinessArticleService;
import com.wxmp.wxmobile.service.BusinessArticleTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("article")
public class BusinessArticleCtrl {


    @Autowired
    private BusinessArticleTypeService businessArticleTypeService;


    @Autowired
    private BusinessArticleService businessArticleService;


    @RequestMapping(value = "getList",method = RequestMethod.POST)
    public AjaxResult list(Long typeId){
        List<BusinessArticle> list = businessArticleService.getBusinessArticleByType(typeId);
        return AjaxResult.success(list);
    }

    @RequestMapping(value ="getArticle")
    public AjaxResult getArticle(Long articleId){
        BusinessArticle article = businessArticleService.getArticleById(articleId);
        return AjaxResult.success(article);
    }


    @RequestMapping(value = "save")
    public AjaxResult save(BusinessArticle article){
        businessArticleService.createBusinessArticle(article);
        return AjaxResult.success();
    }

}
