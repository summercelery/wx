package com.wxmp.wxcms.service;

import com.wxmp.wxcms.domain.Account;
import com.wxmp.wxcms.mapper.AccountDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service("accountService")
public class AccountService  {
    
    @Resource
    private AccountDao entityDao;
    
    public Account getById(Long id) {
        return entityDao.getById(id);
    }
    
    public Account getByAccount(String account) {
        return entityDao.getByAccount(account);
    }
    
    public List<Account> listForPage(Account searchEntity) {
        return entityDao.listAccount(searchEntity);
    }
    
    public void add(Account entity) {
        entityDao.add(entity);
    }
    
    public void update(Account entity) {
        entityDao.update(entity);
    }
    
    public void delete(Account entity) {
        entityDao.delete(entity);
    }
    
    public Account getSingleAccount() {
        return entityDao.getSingleAccount();
    }
    
}
