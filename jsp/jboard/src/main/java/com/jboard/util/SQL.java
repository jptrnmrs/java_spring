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
											+"`rDate`=NOW()";
// Article
	public final static String SELECT_MAX_NO = "select MAX(`ano`) from `article`";
	public final static String INSERT_ARTICLE = "insert into `article` set "
												+"`title`=?, "
												+"`content`=?, "
												+"`file`=?, "
												+"`writer`=?, "
												+"`regip`=?, "
												+"`rdate`=now() ";
	public final static String SELECT_ARTICLE = "select a.*,c.`nick` ,b.* from `article` AS a "
											+ "left join `file` AS b using(ano) "
											+ "JOIN `user` c ON a.writer = c.uid "
											+ "where a.`ano`=?";
	public final static String SELECT_COUNT_TOTAL = "select count(*) from `article`";
	
	public final static String SELECT_ARTICLES = "SELECT a.*, b.`nick` FROM `article` a "
												+ "JOIN `user` b ON a.writer = b.uid "
												+ "ORDER BY `ano` DESC "
												+ "LIMIT 10 OFFSET ? ";
	public final static String VIEW_ARTICLE = "update `article` set `hit` = hit+1 where `ano`=?";
	public final static String COMMENT_ARTICLE = "update `article` set `comment` = ? where `ano`=?";
	public final static String SELECT_WRITER = "select `nick` from `user` where `uid`= ?";
	
// Comment
	public final static String INSERT_COMMENT = "insert into `comment` set "
												+ "`ano`=?, "
												+ "`content`=?, "
												+ "`writer`=?, "
												+ "`regip`=?, "
												+ "`rdate`=NOW()";			
	public final static String SELECT_COMMENT = "select a.*, b.nick from `comment` a join `user` b on a.writer=b.uid where `cno`=?";			
	public final static String SELECT_COMMENTS = "select a.*, b.nick from `comment` a join `user` b on a.writer=b.uid where a.`ano`=? order by `cno`";			
	public final static String COUNT_COMMENTS = "select COUNT(`no`) from `comment` where `ano`= ?";			
	public final static String UPDATE_COUNT = "update `article` set `comment`=? where `no`=?";			
	public final static String UPDATE_COMMENT = "update `comment` set `content`=? where `no`=?";			
	public final static String DELETE_COMMENT = "delete from `comment` where `no`=?";			
	
	
// File
	public final static String INSERT_FILE = "insert into `file` set "
											+ "`ano` = ?, "
											+ "`oName` = ?, "
											+ "`sName` = ?, "
											+ "`rdate` = NOW()";	
	
	public final static String SELECT_FILE = "select * from `file` where `fno`=?";			
	public final static String UPDATE_FILE_DOWNLOAD_COUNT
											= "update `file` set `download`=`download`+1 where `fno`=?";			


}
