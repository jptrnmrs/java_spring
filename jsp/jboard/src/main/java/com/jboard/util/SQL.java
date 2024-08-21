package com.jboard.util;

public class SQL {
	public final static String SELECT_TERMS = "select * from `terms`";
	public final static String SELECT_COUNT_USER = "select count(*) from `user`";
	public final static String WHERE_UID = "where `uid`=?";
	public final static String WHERE_NICK = "where `nick`=?";
	public final static String WHERE_EMAIL = "where `email`=?";
	public final static String WHERE_HP = "where `hp`=?";

	public final static String SELECT_USER = "select * from `user` where `uid`= ? and `pass`= SHA2(?,256)";
	public final static String INSERT_USER = "insert into `user` set "
											+"`uid`=?, "
											+"`pass`=SHA2(?,256), "
											+"`name`=?, "
											+"`nick`=?, "
											+"`email`=?, "
											+"`hp`=?, "
											+"`zip`=?, "
											+"`addr1`=?, "
											+"`addr2`=?, "
											+"`regip`=?,"
											+"`regDate`=NOW()";
// Article
	public final static String SELECT_MAX_NO = "select MAX(`no`) from `article`";
	public final static String INSERT_ARTICLE = "insert into `article` set "
												+"`title`=?, "
												+"`content`=?, "
												+"`file`=?, "
												+"`writer`=?, "
												+"`regip`=?, "
												+"`rdate`=now() ";
	public final static String SELECT_ARTICLE = "select * from `article` where `no`=?";
	public final static String SELECT_ARTICLES = "SELECT "
												+ "	`no`, "
												+ "	`cate`, "
												+ "	`title`, "
												+ "	`content`, "
												+ "	`comment`, "
												+ "	`file`, "
												+ "	`hit`, "
												+ "	`writer`, "
												+ "	a.`regip`, "
												+ "	`rdate`, "
												+ "	`nick` "
												+ "FROM `article` a "
												+ "JOIN `user` b ON a.writer = b.uid ";
	public final static String VIEW_ARTICLE = "update `article` set `hit` = hit+1 where `no`=?";
	public final static String SELECT_WRITER = "select `nick` from `user` where `uid`= ?";
	
// File
	public final static String INSERT_FILE = "insert into `file` set "
											+ "`ano` = ?, "
											+ "`oName` = ?, "
											+ "`sName` = ?, "
											+ "`rdate` = NOW()";
	public final static String SELECT_FILE_FOR_ARTICLE = "select * from `file` where `ano`=?";			
	

// Comment
	public final static String SELECT_COMMENTS = "select * from `comment` where `parent`=?";			
	

}
