package com.usemodj.jpetstore.mappers;

import com.usemodj.jpetstore.domain.Account;

public interface AccountMapper {
	public Account selectAccount( String userid);
	public void insertAccount( Account account);
	public void updateAccount( Account account);
	public void deleteAccount( String userid);

}
