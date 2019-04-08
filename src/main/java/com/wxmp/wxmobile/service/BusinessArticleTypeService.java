package com.wxmp.wxmobile.service;

import com.wxmp.core.common.Constants;
import com.wxmp.core.util.UUIDUtil;
import com.wxmp.wxmobile.domain.BusinessArticleType;
import com.wxmp.wxmobile.mapper.BusinessArticleTypeDao;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BusinessArticleTypeService {

    @Autowired
    private BusinessArticleTypeDao businessArticleTypeDao;

    public List<BusinessArticleType> listAll(){
        return businessArticleTypeDao.list(null);
    }

    public List<BusinessArticleType> list(BusinessArticleType type){
     return businessArticleTypeDao.list(type);
    }

    public BusinessArticleType findById(Long id){
        return businessArticleTypeDao.findById(id);
    }

    public void delete(BusinessArticleType type){
        businessArticleTypeDao.deleteBusinessArticleType(type);
    }

    public void saveBusinessArticleType(BusinessArticleType type){
        if(null == type.getId()){
            type.setCreateTime(new Date());
            type.setUpdateTime(new Date());
            type.setUrl(Constants.DOMAIN_NAMW+"/mobileViews/articleList.html?typeId=");
            BusinessArticleType resultType = businessArticleTypeDao.createBusinessArticleType(type);
            for(String picId :type.getPicUrl()){
                businessArticleTypeDao.insertPic(picId,resultType.getId());
            }

        }else {
            type.setUpdateTime(new Date());
            businessArticleTypeDao.updateBusinessArticleType(type);
        }
    }
}
