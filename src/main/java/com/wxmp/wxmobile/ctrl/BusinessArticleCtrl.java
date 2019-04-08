package com.wxmp.wxmobile.ctrl;

import com.wxmp.core.common.BaseCtrl;
import com.wxmp.core.common.Constants;
import com.wxmp.core.util.AjaxResult;
import com.wxmp.wxmobile.domain.BusinessArticle;
import com.wxmp.wxmobile.domain.BusinessArticleType;
import com.wxmp.wxmobile.service.BusinessArticleService;
import com.wxmp.wxmobile.service.BusinessArticleTypeService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("article")
public class BusinessArticleCtrl extends BaseCtrl {

    @Autowired
    private BusinessArticleService businessArticleService;


    @RequestMapping(value = "getList",method = RequestMethod.POST)
    public AjaxResult listByTypeId(Long typeId){
        List<BusinessArticle> list = businessArticleService.getBusinessArticleByType(typeId);
        return AjaxResult.success(list);
    }

    @RequestMapping(value = "list")
    public AjaxResult list(BusinessArticle article){
        List<BusinessArticle>list = businessArticleService.list(article);
        return getResult(article, list);
    }

    @RequestMapping(value ="getArticle")
    public AjaxResult getArticle(Long articleId){
        BusinessArticle article = businessArticleService.getArticleById(articleId);
        return AjaxResult.success(article);
    }


    @RequestMapping(value = "save")
    public AjaxResult save(BusinessArticle article){
        if(StringUtils.isNotBlank(article.getId())){
            article.setUpdateTime(new Date());
            businessArticleService.updateBusinessArticle(article);
        }else{
            article.setCreateTime(new Date());
            article.setUrl(Constants.DOMAIN_NAMW+"/mobileViews/article.html?articleId=");
            businessArticleService.createBusinessArticle(article);
        }

        return AjaxResult.success();
    }


    @RequestMapping("delArticle")
    public AjaxResult delArticle(BusinessArticle article){
        businessArticleService.delete(article);
        return AjaxResult.success();
    }


}
