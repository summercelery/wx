package com.wxmp.wxcms.mapper;

import com.wxmp.wxcms.domain.BusinessArticleType;

public interface BusinessArticleTypeDao {

    BusinessArticleType findById(String id);

    BusinessArticleType createBusinessArticleType(BusinessArticleType type);

    void updateBusinessArticleType(BusinessArticleType type);
}
