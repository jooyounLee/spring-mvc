package kr.mz.study.spring.article.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

import kr.mz.study.spring.article.groups.ArticleGroups.Delete;
import kr.mz.study.spring.article.groups.ArticleGroups.Password;
import kr.mz.study.spring.article.groups.ArticleGroups.Save;
import kr.mz.study.spring.article.groups.ArticleGroups.Update;

public class Article {
	
	@NotNull(groups= {Update.class, Delete.class, Password.class})
	private Integer idx;

	@NotNull(groups= {Save.class, Update.class})
	private String userName;
	
	@NotNull(groups= {Save.class, Update.class, Password.class})
	private String password;
	
	@NotNull(groups= {Save.class, Update.class})
	private String title;
	
	@NotNull(groups= {Save.class, Update.class})
	private String content;
	
	private Date created;
	
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
