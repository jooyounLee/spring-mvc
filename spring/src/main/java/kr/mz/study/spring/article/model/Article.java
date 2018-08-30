package kr.mz.study.spring.article.model;

import java.util.Date;

public class Article {
	
	private Integer idx;
	
	private String userName;
	
	private String password;
	
	private String title;
	
	private String content;
	
	private Date created;
	
	public Article() {}
	
	public Article(Integer idx, String userName, String password, String title, String content, Date created) {
		super();
		this.idx = idx;
		this.userName = userName;
		this.password = password;
		this.title = title;
		this.content = content;
		this.created = created;
	}

	public Integer getIdx() {
		return idx;
	}

	public void setIdx(Integer idx) {
		this.idx = idx;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
