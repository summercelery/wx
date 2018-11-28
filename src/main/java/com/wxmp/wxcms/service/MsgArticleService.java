package com.wxmp.wxcms.service;

import com.wxmp.wxcms.domain.MsgArticle;
import com.wxmp.wxcms.domain.MsgNews;
import com.wxmp.wxcms.mapper.MsgArticleDao;
import com.wxmp.wxcms.mapper.MsgNewsDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class MsgArticleService {

	@Resource
	private MsgArticleDao articleDao;
	
	@Resource
	private MsgNewsDao entityDao;
	
	public List<MsgArticle> getByNewsId(int id) {
		// TODO Auto-generated method stub
		return articleDao.getByNewsId(id);
	}

	public MsgArticle getById(int id) {
		// TODO Auto-generated method stub
		return articleDao.getById(id);
	}

	public void add(MsgArticle article) {
		// TODO Auto-generated method stub
		articleDao.add(article);
	}

	public void insertByBatch(List<MsgArticle> articles) {
		// TODO Auto-generated method stub
		articleDao.insertByBatch(articles);
	}

	public void update(MsgArticle article) {
		// TODO Auto-generated method stub
//		this.getById(business.getArId());
		if(article.getNewsIndex()==0){
			MsgNews news = entityDao.getById(String.valueOf(article.getNewsId()));
			news.setTitle(article.getTitle());
			news.setAuthor(article.getAuthor());
			news.setBrief(article.getDigest());
			news.setDescription(article.getContent());
			news.setPicpath(article.getPicUrl());
			news.setThumbMediaId(article.getThumbMediaId());
			news.setFromurl(article.getContentSourceUrl());
			news.setShowpic(article.getShowCoverPic());
			entityDao.update(news);
		}
		articleDao.update(article);
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		articleDao.delete(id);
	}

	public void deleteByBatch(int id) {
		// TODO Auto-generated method stub
		articleDao.deleteByBatch(id);
	}

}
