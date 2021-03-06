package com.wxmp.wxmobile.mapper;

import com.wxmp.wxmobile.domain.BusinessArticle;

import java.util.List;

public interface BusinessArticleDao {


    List<BusinessArticle> findByTypeId(Long id);
    List<BusinessArticle> list(BusinessArticle article);


    BusinessArticle findById(Long id);

    void createBusinessArticle(BusinessArticle article);
    void updateBusinessArticle(BusinessArticle article);
    void deleteBusinessArticle(BusinessArticle article);

}
