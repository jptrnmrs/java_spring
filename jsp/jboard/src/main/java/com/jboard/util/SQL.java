package com.jboard.util;

public class SQL {
	public final static String SELECT_TERMS = "select * from `terms`";
	public final static String SELECT_COUNT_USER = "select count(*) from `user`";
	public final static String WHERE_UID = "where `uid`=?";
	public final static String WHERE_NICK = "where `nick`=?";
	public final static String WHERE_EMAIL = "where `email`=?";
	public final static String WHERE_HP = "where `hp`=?";

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
	public final static String UPDATE_USER = "update `user` set "
											+"`pass`=SHA2(?,256), "
											+"`name`=?, "
											+"`nick`=?, "
											+"`email`=?, "
											+"`hp`=?, "
											+"`zip`=?, "
											+"`addr1`=?, "
											+"`addr2`=?, "
											+"where `uid`=? ";
	public final static String SELECT_USER = "select * from `user` where `uid`=?";
	public final static String SELECT_USERS = "select * from `user`";
	public final static String DELETE_USER = "delete from `user` where `uid`=?";
	
}
