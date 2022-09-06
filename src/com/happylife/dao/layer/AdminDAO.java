package com.happylife.dao.layer;

import com.happylife.pojo.Admin;

public interface AdminDAO {
	public Admin doLogin(String email, String password) throws AdminDAOException;
	public String doSignUp(Admin admin)throws AdminDAOException;
}
