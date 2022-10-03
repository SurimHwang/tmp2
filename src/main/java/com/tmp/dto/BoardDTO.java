package com.tmp.dto;

import java.sql.Date;

public class BoardDTO {
	private String table;
	private String bdName;
	private String bdTitle;
	private String bdContent;
	private Date bdDate;
	
	
	public String getBdName() {
		return bdName;
	}
	public void setBdName(String bdName) {
		this.bdName = bdName;
	}
	public String getBdTitle() {
		return bdTitle;
	}
	public void setBdTitle(String bdTitle) {
		this.bdTitle = bdTitle;
	}  
	public String getBdContent() {
		return bdContent;
	}
	public void setBdContent(String bdContent) {
		this.bdContent = bdContent;
	}
	public Date getBdDate() {
		return bdDate;
	}
	public void setBdDate(Date bdDate) {
		this.bdDate = bdDate;
	}
	
	
}
