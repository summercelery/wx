package com.wxmp.wxcms.service;

import com.wxmp.core.common.Constants;
import com.wxmp.core.util.UUIDUtil;
import com.wxmp.wxcms.domain.BusinessArticleType;
import com.wxmp.wxcms.mapper.BusinessArticleTypeDao;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class BusinessArticleTypeService {

    @Autowired
    private BusinessArticleTypeDao businessArticleTypeDao;

    public void saveBusinessArticleType(BusinessArticleType type){

        if(StringUtils.isBlank(type.getId())){
            String id = UUIDUtil.getUUID();
            type.setId(id);
            type.setCreateTime(new Date());
            type.setUpdateTime(new Date());
            type.setUrl(Constants.DOMAIN_NAMW+"/mobileViews/articleList.html?"+id);
            businessArticleTypeDao.createBusinessArticleType(type);
        }else {
            type.setUpdateTime(new Date());
            businessArticleTypeDao.updateBusinessArticleType(type);
        }
    }
}
