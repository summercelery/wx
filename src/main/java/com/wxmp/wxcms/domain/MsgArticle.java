package com.wxmp.wxcms.domain;

import com.wxmp.core.page.Page;
import lombok.Data;

import java.io.Serializable;


@Data
public class MsgArticle  extends Page implements Serializable {

	private Integer arId;
	private String title;
	private String author;
	private String content;
	private String digest;
	private Integer showCoverPic;
	private String picUrl;
	private String url;
	private String thumbMediaId;
	private String contentSourceUrl;
	private String mediaId;
	private Integer newsIndex;
	private Integer newsId;
}
