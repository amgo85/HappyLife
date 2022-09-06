package com.happylife.dao.layer;


/*
 * I didn't create POJO, I think it is Ok as long as I don't want to receive object of type RESET  
 * */
public interface ResetDAO {
	public String activateAccount(String emailId, String token) throws ResetDAOException;
	public String addResetLink(String email)throws ResetDAOException;
	public String validateToken(String token) throws ResetDAOException;
}