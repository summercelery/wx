package com.wxmp.wxmobile.mapper;

import com.wxmp.wxmobile.domain.BusinessArticle;

import java.util.List;

public interface BusinessArticleDao {


    List<BusinessArticle> findByTypeId(Long id);

}
