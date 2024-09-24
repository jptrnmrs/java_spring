package com.jboard.dto;

public class CommentDTO {
	private int cno;
	private int ano;
	private String content;
	private String writer;
	private String regip;
	private String rdate;
	
	//추가필드
	private String nick;

	public int getCno() {
		return cno;
	}

	public void setCno(int cno) {
		this.cno = cno;
	}
	public void setCno(String cno) {
		this.cno = Integer.parseInt(cno);
	}

	public int getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = Integer.parseInt(ano);
	}
	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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
		this.rdate = rdate.substring(2, 10);
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	@Override
	public String toString() {
		return "CommentDTO [cno=" + cno + ", ano=" + ano + ", content=" + content + ", writer=" + writer + ", regip="
				+ regip + ", rdate=" + rdate + ", nick=" + nick + "]";
	}
	
	
	
}
