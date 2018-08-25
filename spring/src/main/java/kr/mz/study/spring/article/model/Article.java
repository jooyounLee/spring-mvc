package kr.mz.study.spring.article.model;

import java.util.Date;

public class Article {
	
	private int idx;
	
	private String userNm;
	
	private String articlePw;
	
	private String title;
	
	private String content;
	
	private Date created;
	
	public Article() {}
	
	public Article(int idx, String userNm, String articlePw, String title, String content, Date created) {
		super();
		this.idx = idx;
		this.userNm = userNm;
		this.articlePw = articlePw;
		this.title = title;
		this.content = content;
		this.created = created;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getuserNm() {
		return userNm;
	}

	public void setuserNm(String userNm) {
		this.userNm = userNm;
	}

	public String getarticlePw() {
		return articlePw;
	}

	public void setarticlePw(String articlePw) {
		this.articlePw = articlePw;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}
		
}
