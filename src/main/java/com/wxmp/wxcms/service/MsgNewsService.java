package com.wxmp.wxcms.service;

import com.wxmp.wxapi.process.MsgType;
import com.wxmp.wxcms.domain.MediaFiles;
import com.wxmp.wxcms.domain.MsgArticle;
import com.wxmp.wxcms.domain.MsgBase;
import com.wxmp.wxcms.domain.MsgNews;
import com.wxmp.wxcms.mapper.MediaFilesDao;
import com.wxmp.wxcms.mapper.MsgArticleDao;
import com.wxmp.wxcms.mapper.MsgBaseDao;
import com.wxmp.wxcms.mapper.MsgNewsDao;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class MsgNewsService {

	@Resource
	private MsgBaseDao baseDao;

	@Resource
	private MsgNewsDao msgNewsDao;

	@Resource
	private MediaFilesDao mediaFilesDao;
	
	@Resource
	private MsgArticleDao articleDao;

	public MsgNews getById(String id){
		return msgNewsDao.getById(id);
	}

	public List<MsgNews> listForPage(MsgNews searchEntity){
		return msgNewsDao.listForPage(searchEntity);
	}
	
	public List<MsgNews> getWebNewsListByPage(MsgNews searchEntity){
		return msgNewsDao.getWebNewsListByPage(searchEntity);
	}

	
	public void add(MsgNews entity){
		
		MsgBase base = new MsgBase();
		base.setInputcode(entity.getInputcode());
		base.setCreateTime(new Date());
		base.setMsgtype(MsgType.News.toString());
		baseDao.add(base);
		
		entity.setBaseId(base.getId());
		msgNewsDao.add(entity);
		
		if(StringUtils.isEmpty(entity.getFromurl())){
			entity.setUrl(entity.getUrl()+"?id="+entity.getId());
		}else{
			entity.setUrl("");
		}
		
		msgNewsDao.updateUrl(entity);
	}

	public void update(MsgNews entity){
		MsgBase base = baseDao.getById(entity.getBaseId().toString());
		base.setInputcode(entity.getInputcode());
		baseDao.updateInputcode(base);
		
		if(StringUtils.isEmpty(entity.getFromurl())){
			entity.setUrl(entity.getUrl()+"?id="+entity.getId());
		}else{
			entity.setUrl("");
		}
		
		msgNewsDao.update(entity);
	}

	public void delete(MsgNews entity){
		MsgBase base = new MsgBase();
		base.setId(entity.getBaseId());
		articleDao.deleteByBatch(entity.getId().intValue());
		msgNewsDao.delete(entity);
		baseDao.delete(entity);
		
	}

	public List<MsgNews> getRandomMsg(String inputCode, Integer num){
		return msgNewsDao.getRandomMsgByContent(inputCode,num);
	}
	
	public MsgNews getByBaseId(String baseid){
		return msgNewsDao.getByBaseId(baseid);
	}


	public int updateMediaId(MsgNews entity) {
		int n = 0 ;
		try {
			msgNewsDao.updateMediaId(entity);
			n = 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n;
	}


	@Transactional
	public int addSingleNews(MsgNews news, MediaFiles entity) {
		int n=0;
	    int m = 0;
	    try {
	    	//保存基本消息
			MsgBase base = new MsgBase();
			base.setCreateTime(new Date());
			base.setMsgtype(MsgType.News.toString());
			 baseDao.add(base);
	    	//保存图文信息
			news.setCreateTime(new Date());
			news.setBaseId(base.getId());
			Integer newId= this.msgNewsDao.addNews(news);
	    	MsgArticle art = new MsgArticle();
			art.setAuthor(news.getAuthor());
			art.setContent(news.getDescription());
			art.setContentSourceUrl(news.getFromurl());
			art.setDigest(news.getBrief());
			art.setMediaId(news.getMediaId());
			art.setNewsIndex(0);
			art.setPicUrl(news.getPicpath());
			art.setShowCoverPic(news.getShowpic());
			art.setThumbMediaId(news.getThumbMediaId());
			art.setTitle(news.getTitle());
			art.setUrl(news.getUrl());
			
			art.setNewsId(news.getId().intValue());
			articleDao.add(art);
	    	n = 1;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	    if(n > 0){
		    try {
		    	mediaFilesDao.add(entity);
		    	m = 1;
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
	    }
	    if(n >0 && m >0){
	    	return 1;
	    }else{
	    	return 0;
	    }
	}
	
	
	
	public int addMediaFiles(MediaFiles entity) {
		int n=0;
	    
		    try {
		    	mediaFilesDao.add(entity);
		    	n = 1;
			} catch (Exception e) {
				e.printStackTrace();
			}
	
	    
	    if(n >0){
	    	return 1;
	    }else{
	    	return 0;
	    }
	    
	}


	public List<MediaFiles> getMediaFileList() {
		return this.mediaFilesDao.getMediaFileList();
	}


	public List<MsgNews> getMsgNewsList() {
		return this.msgNewsDao.getMsgNewsList();
	}


	@Transactional
	public int addMoreNews(MsgNews news) {
		int n=0;
	   
	    try {
	    	List<MsgArticle> articles = news.getArticles();
	    	List<MsgArticle> list = new ArrayList<MsgArticle>();
			//保存基本消息
			MsgBase base = new MsgBase();
			base.setCreateTime(new Date());
			base.setMsgtype(MsgType.News.toString());
			baseDao.add(base);
			news.setBaseId(base.getId());
			news.setCreateTime(new Date());
	    	//保存图文信息
	    	this.msgNewsDao.addNews(news);
	    	for (int i = 0; i < articles.size(); i++) {
	    		MsgArticle article=articles.get(i);
	    		article.setNewsId(news.getId().intValue());
	    		list.add(article);
			}
	    	articleDao.insertByBatch(list);
	    	n = 1;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	    if(n==1){
			MediaFiles entity = new MediaFiles();
			entity.setMediaId(news.getMediaId());
			entity.setMediaType("news");
			entity.setCreateTime(news.getCreateTime());
			entity.setUpdateTime(news.getCreateTime());
			mediaFilesDao.add(entity);
	    }
	    return n;
	}

	public Boolean addMoreNews(List<MsgNews> news) {
		// TODO Auto-generated method stub
		try {
			//保存基本消息
			Date date = new Date(System.currentTimeMillis());
			MsgBase base = new MsgBase();
			base.setCreateTime(date);
			base.setMsgtype(MsgType.News.toString());
			baseDao.add(base);
			for (int i = 0; i < news.size(); i++) {
				MsgNews one = news.get(i);
				one.setBaseId(base.getId());
				one.setCreateTime(date);
				//保存图文信息
				this.msgNewsDao.addNews(one);
			}
			//添加到素材表中
			MediaFiles entity = new MediaFiles();
			entity.setMediaId(news.get(0).getMediaId());
			entity.setMediaType("news");
			entity.setCreateTime(date);
			entity.setUpdateTime(date);
			mediaFilesDao.add(entity);
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public void deleteNews(String mediaId) {
		this.mediaFilesDao.deleteByMediaId(mediaId);
		this.msgNewsDao.deleteByMediaId(mediaId);
	}


	@Transactional
	public void updateSingleNews(MsgNews news) {
    	MsgArticle art = new MsgArticle();
		art.setAuthor(news.getAuthor());
		art.setContent(news.getDescription());
		art.setContentSourceUrl(news.getFromurl());
		art.setDigest(news.getBrief());
		art.setMediaId(news.getMediaId());
		art.setNewsIndex(0);
		art.setPicUrl(news.getPicpath());
		art.setShowCoverPic(news.getShowpic());
		art.setThumbMediaId(news.getThumbMediaId());
		art.setTitle(news.getTitle());
		art.setUrl(news.getUrl());
		
		art.setNewsId(news.getId().intValue());
		int arId=articleDao.getByNewsId(news.getId().intValue()).get(0).getArId();
		art.setArId(arId);
		articleDao.update(art);
		this.msgNewsDao.updateNews(news);
	}


	public List<MsgNews> getByMediaId(String mediaId) {
		// TODO Auto-generated method stub
		return this.msgNewsDao.getByMediaId(mediaId);
	}


	
}
