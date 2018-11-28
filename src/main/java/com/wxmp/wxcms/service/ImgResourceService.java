package com.wxmp.wxcms.service;

import com.wxmp.core.common.Constants;
import com.wxmp.core.util.CommonUtil;
import com.wxmp.wxapi.process.MediaType;
import com.wxmp.wxcms.domain.ImgResource;
import com.wxmp.wxcms.domain.MediaFiles;
import com.wxmp.wxcms.domain.MsgBase;
import com.wxmp.wxcms.mapper.ImgResourceDao;
import com.wxmp.wxcms.mapper.MediaFilesDao;
import com.wxmp.wxcms.mapper.MsgBaseDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ImgResourceService  {

	@Resource
    private ImgResourceDao imgResourceDao;
	@Resource
	private MediaFilesDao mediaFilesDao;
	@Resource
	private MsgBaseDao baseDao;
	
	public ImgResource getImg(String id) {
		return imgResourceDao.getImgById(id);
	}

	public String addImg(ImgResource img) {
		img.setFlag(Constants.IMG_FLAG0);
		img.setCreateTime(new Date(System.currentTimeMillis()));
		img.setUpdateTime(img.getCreateTime());
		//主键id
		String id = CommonUtil.getUID();
		img.setId(id);
		imgResourceDao.add(img);

		//添加base表
		MsgBase base = new MsgBase();
		base.setCreateTime(new Date());
		base.setMsgtype(MediaType.Image.name());
		baseDao.add(base);
		//添加到素材表中
		MediaFiles entity = new MediaFiles();
		entity.setMediaId(img.getMediaId());
		entity.setMediaType(MediaType.Image.name());
		entity.setBaseId(base.getId());
		entity.setCreateTime(new Date(System.currentTimeMillis()));
		entity.setUpdateTime(new Date(System.currentTimeMillis()));
		mediaFilesDao.add(entity);
		return img.getUrl();
	}

	public List<ImgResource> getImgListByPage(ImgResource entity) {
		return imgResourceDao.getImgListByPage(entity);
	}
	
	public boolean removeOtherToImg(String otherId) {
		return false;
	}


	public boolean updateImgFlag(String id, Integer flag) {
		return false;
	}

	public boolean delImg(String id) {
		ImgResource img = imgResourceDao.getImgById(id);
//		MsgBase base = new MsgBase();
//		base.setId(img.);
//		baseDao.delete(base);
		mediaFilesDao.deleteByMediaId(img.getMediaId());
		imgResourceDao.deleteByMediaId(img.getMediaId());
		
		return true;
	}



}
