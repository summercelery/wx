package com.wxmp.core.listener;

import com.wxmp.core.spring.SpringContextHolder;
import com.wxmp.core.util.CacheUtils;
import com.wxmp.wxapi.process.WxMemoryCacheClient;
import com.wxmp.wxcms.domain.Account;
import com.wxmp.wxcms.domain.SysConfig;
import com.wxmp.wxcms.service.AccountService;
import com.wxmp.wxcms.service.SysConfigService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 springboot初始化执行
 */

@Component
public class InitListener implements CommandLineRunner {
    
    @Override
    public void run(String... args) throws Exception {
        try {
            //放入公众号
            AccountService accountService = SpringContextHolder.getBean("accountService");
            List<Account> accounts = accountService.listForPage(new Account());
            WxMemoryCacheClient.addMpAccount(accounts);
            //读取所有缓存
            SysConfigService configService = SpringContextHolder.getBean("sysConfigService");
            List<SysConfig> configList = configService.getConfigList();
            for (SysConfig config : configList) {
                CacheUtils.put(config.getJkey().toUpperCase(), config.getJvalue());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
