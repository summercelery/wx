package com.wxmp.wxcms.mapper;

import com.wxmp.wxcms.domain.MediaFiles;

import java.util.List;

/**
 *
 * @author hermit
 * @version 2.0
 * @date 2018-04-17 10:54:58
 */
public interface MediaFilesDao {

	public void add(MediaFiles entity);
	
	public List<MediaFiles> getMediaFileList();
	
	/**
	 *  分页
	 * @param entity
	 * @return
	 */
	public List<MediaFiles> getMediaListByPage(MediaFiles entity);
	
	/**
	 * 删除
	 * @param id
	 */
	public void deleteByMediaId(String mediaId);
	/**
	 * 获取单条数据
	 * @param mediaId
	 * @return
	 */
	public MediaFiles getFileByMediaId(String mediaId);
	/**
	 * 条件查询
	 * @param mediaId
	 * @return
	 */
	public MediaFiles getFileBySou(MediaFiles entity);
}
