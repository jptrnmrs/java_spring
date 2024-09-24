package com.jboard.dto;

import java.util.List;

public class ArticleDTO {
	private int ano;
	private String cate;
	private String title;
	private String content;
	private int comment;
	private int file;
	private int hit;
	private String writer;
	private String regip;
	private String rdate;
	
	// 나도 먹고 살아야하니까 생겨나는 추가필드
	private String writerNick;
	private int articleNo;
	private List<FileDTO> files;
	
	public List<FileDTO> getFiles() {
		return files;
	}
	public void setFiles(List<FileDTO> files) {
		this.files = files;
	}
	public String getWriterNick() {
		return writerNick;
	}
	public int getArticleNo() {
		return articleNo;
	}
	public void setArticleNo(int articleNo) {
		this.articleNo = articleNo;
	}
	public void setWriterNick(String writerNick) {
		this.writerNick = writerNick;
	}
	@Override
	public String toString() {
		return "ArticleDTO [ano=" + ano + ", cate=" + cate + ", title=" + title + ", content=" + content + ", comment="
				+ comment + ", file=" + file + ", hit=" + hit + ", writer=" + writer + ", regip=" + regip + ", rdate="
				+ rdate + "]";
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public String getCate() {
		return cate;
	}
	public void setCate(String cate) {
		this.cate = cate;
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
	public int getComment() {
		return comment;
	}
	public void setComment(int comment) {
		this.comment = comment;
	}
	public int getFile() {
		return file;
	}
	public void setFile(int file) {
		this.file = file;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getRegip() {
		return regip;
	}
	public void setRegip(String regip) {
		this.regip = regip;
	}
	public String getRdate() {
		return rdate;
	}
	public void setRdate(String rdate) {
		this.rdate = rdate;
	}
	public void setRdateSubstring(String rdate) {
		this.rdate = rdate.substring(0, 10);
	}
}
