package com.wxmp.wxcms.service;

import com.wxmp.core.util.StringUtil;
import com.wxmp.wxapi.process.MsgType;
import com.wxmp.wxcms.domain.MsgBase;
import com.wxmp.wxcms.domain.MsgText;
import com.wxmp.wxcms.mapper.MsgBaseDao;
import com.wxmp.wxcms.mapper.MsgTextDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;


@Service
public class MsgTextService {

	@Resource
	private MsgTextDao entityDao;

	@Resource
	private MsgBaseDao baseDao;

	public MsgText getById(String id){
		return entityDao.getById(id);
	}

	public List<MsgText> getMsgTextByPage(MsgText searchEntity){
		return entityDao.getMsgTextByPage(searchEntity);
	}

	public void add(MsgText entity){
		MsgBase base = new MsgBase();
		base.setInputcode(entity.getInputcode());
		base.setCreateTime(new Date());
		base.setMsgtype(MsgType.Text.toString());
		baseDao.add(base);
		entity.setBaseId(base.getId());
		entityDao.add(entity);
	}

	public void update(MsgText entity){
		MsgBase base = baseDao.getById(entity.getBaseId().toString());
		base.setInputcode(entity.getInputcode());
		baseDao.updateInputcode(base);
		entityDao.update(entity);
	}

    public void delete(String baseIds) {
        String[] ids = StringUtil.split(baseIds, ",");
        for (String id : ids) {
            MsgBase base = new MsgBase();
            MsgText msgText = new MsgText();
            base.setId(Long.valueOf(id));
            msgText.setBaseId(Long.valueOf(id));
            entityDao.delete(msgText);
            baseDao.delete(base);
        }
    }

	//根据用户发送的文本消息，随机获取一条文本消息
	public MsgText getRandomMsg(String inputCode){
		return entityDao.getRandomMsg(inputCode);
	}
	public MsgText getRandomMsg2(){
		return entityDao.getRandomMsg2();
	}

	public MsgText getByBaseId(String baseid) {
		// TODO Auto-generated method stub
		return entityDao.getByBaseId(baseid);
	}
}
