package com.wxmp.wxmobile.mapper;

import com.wxmp.wxmobile.domain.BusinessArticleType;

public interface BusinessArticleTypeDao {

    BusinessArticleType findById(String id);

    BusinessArticleType createBusinessArticleType(BusinessArticleType type);

    void updateBusinessArticleType(BusinessArticleType type);
}
