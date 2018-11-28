package com.wxmp.wxcms.service;

import com.wxmp.wxcms.domain.MediaFiles;
import com.wxmp.wxcms.domain.MsgBase;
import com.wxmp.wxcms.mapper.MediaFilesDao;
import com.wxmp.wxcms.mapper.MsgBaseDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class MediaFileService  {

	@Resource
	private MediaFilesDao mediaFilesDao;
	@Resource
	private MsgBaseDao baseDao;
	
	public void add(MediaFiles entity) {
		MsgBase base = new MsgBase();
		base.setCreateTime(new Date());
		base.setMsgtype(entity.getMediaType());
		baseDao.add(base);
		//关联回复表
		entity.setBaseId(base.getId());
		//需要对base表添加数据
		mediaFilesDao.add(entity);
	}

	public void deleteByMediaId(String mediaId) {
		MediaFiles media = mediaFilesDao.getFileByMediaId(mediaId);
		MsgBase base = new MsgBase();
		base.setId(media.getBaseId());
		baseDao.delete(base);
		mediaFilesDao.deleteByMediaId(mediaId);
	}

	public MediaFiles getFileByMediaId(String mediaId) {
		return mediaFilesDao.getFileByMediaId(mediaId);
	}

	public List<MediaFiles> getMediaListByPage(MediaFiles entity) {
		return mediaFilesDao.getMediaListByPage(entity);
	}

}
