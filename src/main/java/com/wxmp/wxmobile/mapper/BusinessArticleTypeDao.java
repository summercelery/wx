package com.wxmp.wxmobile.mapper;

import com.wxmp.wxmobile.domain.BusinessArticleType;

import java.util.List;

public interface BusinessArticleTypeDao {

    BusinessArticleType findById(Long id);

    List<String> getTypePics(Long typeId);

    BusinessArticleType createBusinessArticleType(BusinessArticleType type);

    void updateBusinessArticleType(BusinessArticleType type);
}
