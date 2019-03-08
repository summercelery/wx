package com.wxmp.wxmobile.service;

import com.wxmp.wxapi.vo.Article;
import com.wxmp.wxmobile.domain.BusinessArticle;
import com.wxmp.wxmobile.domain.BusinessArticleType;
import com.wxmp.wxmobile.mapper.BusinessArticleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessArticleService {


    @Autowired
    private BusinessArticleDao businessArticleDao;

    public List<BusinessArticle> getBusinessArticleByType(Long typeId){
        return businessArticleDao.findByTypeId(typeId);
    }

    public BusinessArticle getArticleById(Long id ){
        return businessArticleDao.findById(id);
    }

    public void createBusinessArticle(BusinessArticle article){
        businessArticleDao.createBusinessArticle(article);
    }
}
