package com.wxmp.wxcms.service;

import com.wxmp.core.util.StringUtil;
import com.wxmp.wxapi.process.MsgType;
import com.wxmp.wxcms.domain.MsgBase;
import com.wxmp.wxcms.domain.TplMsgText;
import com.wxmp.wxcms.mapper.MsgBaseDao;
import com.wxmp.wxcms.mapper.TplMsgTextDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;


@Service
public class TplMsgTextService  {

	@Resource
	private TplMsgTextDao entityDao;

	@Resource
	private MsgBaseDao baseDao;

	public TplMsgText getById(String id){
		return entityDao.getById(id);
	}

	public List<TplMsgText> getTplMsgTextByPage(TplMsgText searchEntity){
		return entityDao.getTplMsgTextByPage(searchEntity);
	}

	public void add(TplMsgText entity){
		MsgBase base = new MsgBase();
		base.setInputcode(entity.getInputcode());
		base.setCreateTime(new Date());
		base.setMsgtype(MsgType.Text.toString());
		baseDao.add(base);
		
		entity.setBaseId(base.getId());
		entityDao.add(entity);
	}

	public void update(TplMsgText entity){
		MsgBase base = baseDao.getById(entity.getBaseId().toString());
		base.setInputcode(entity.getInputcode());
		baseDao.updateInputcode(base);
		entityDao.update(entity);
	}

    public void delete(String baseIds) {
        String[] ids = StringUtil.split(baseIds, ",");
        for (String id : ids) {
            MsgBase base = new MsgBase();
            TplMsgText tplMsgText = new TplMsgText();
            base.setId(Long.valueOf(id));
            tplMsgText.setBaseId(Long.valueOf(id));
            entityDao.delete(tplMsgText);
            baseDao.delete(base);
        }
    }

	public TplMsgText getByBaseId(String baseid) {
		return entityDao.getByBaseId(baseid);
	}
}
