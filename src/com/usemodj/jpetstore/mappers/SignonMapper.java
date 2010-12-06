package com.usemodj.jpetstore.mappers;

import org.apache.ibatis.annotations.Param;

import com.usemodj.jpetstore.domain.Signon;

public interface SignonMapper {
	public Signon selectSignon( String username);
	public void insertSignon( Signon signon);
	public void updateSignon( Signon signon);
	public void deleteSignon( String username);
	public void insertSignon2(@Param("username")String username, @Param("password")String password, @Param("role")String role);
	public void updatePassword(Signon signon);
	public void updateRole(Signon signon);
}
