package com.wxmp.wxcms.service;

import com.wxmp.wxcms.domain.SysConfig;
import com.wxmp.wxcms.mapper.SysConfigDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service("sysConfigService")
public class SysConfigService  {
    @Resource
    private SysConfigDao configDao;


    public List<SysConfig> getConfigList() {
        return configDao.getConfigList();
    }

    public Map<String, String> getSysConfigToMap() {
        List<SysConfig> allList = this.getConfigList();
        Map<String,String> map = new HashMap<>();
        for (SysConfig config : allList) {
            map.put(config.getJkey(),config.getJvalue());
        }
        return map;
    }

    public String getValue(String key) {
        return configDao.getValue(key);
    }

    public void update(Map<String, String> params, HttpServletRequest request) {
        for(Map.Entry entry : params.entrySet()){
                configDao.update((String)entry.getKey(),(String)entry.getValue());
            }
    }
    public String getMysqlVsesion() {
        return configDao.getMysqlVsesion();
    }
}
