package com.wxmp.wxmobile.mapper;

import com.wxmp.wxmobile.domain.BusinessArticleType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BusinessArticleTypeDao {

    BusinessArticleType findById(Long id);

    List<String> getTypePics(Long typeId);

    Long createBusinessArticleType(BusinessArticleType type);

    void updateBusinessArticleType(BusinessArticleType type);

    List<BusinessArticleType> list(BusinessArticleType type);

    void deleteBusinessArticleType(BusinessArticleType type);

    void insertPic( @Param("picId")String picId,@Param("typeId")Long typeId);

}
