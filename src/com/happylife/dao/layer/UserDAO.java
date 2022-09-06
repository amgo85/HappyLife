package com.happylife.dao.layer;

import java.util.List;

import com.happylife.pojo.User;

public interface UserDAO {
	public User doLogin(String email, String password) throws UserDAOException;
	public User doHibernateLogin(String email, String password) throws UserDAOException;
	public String doSignUp(User user)throws UserDAOException;
	public String doHibernateSignUp(User user)throws UserDAOException;
	//public void updateUser(User user)throws UserDAOException;
	//public void updateUserHibernate(User user)throws UserDAOException;	//to be implemented
	public List<User> searchBy(User sessionUser, String ...v)throws UserDAOException;
	//public List<User> searchByLocationHibernate(String matchgender, String ...v)throws UserDAOException;
	public User getUserByUserId(long id)throws UserDAOException;
	//public User getUserHibernate(long id)throws UserDAOException;
	public User getUserByEmail(String email)throws UserDAOException;
	//public User getUserByEmailHibernate(String email)throws UserDAOException;
	public String updateUser(long userId, String ...v)throws UserDAOException;			//need to find out what the problem is
	//public String updateUserHibernate(long userId, String ...v)throws UserDAOException;
	public String updateAboutMe(User user, String aboutme)throws UserDAOException;
	//public String updateAboutMeHibernate(User user, String aboutme)throws UserDAOException;
	public String updateLookingFor(User user, String lookingfor)throws UserDAOException;
	//public String updateLookingForHibernate(User user, String lookingfor)throws UserDAOException;
	public String getAboutMe(long userId) throws UserDAOException;
	//public String getAboutMeHibernate(long userId) throws UserDAOException;
	public String getLookingFor(long userId) throws UserDAOException;
	//public String getLookingForHibernate(long userId) throws UserDAOException;
	public String updateUserPhoto(long userId, String photoName)throws UserDAOException;
	//public String updateUserPhotoHibernate(long userId, String photoName)throws UserDAOException;
	public String add2MyFavorites(long userId, String ids)throws UserDAOException;
	public String removeFromMyFavorites(long userId, long candidId)throws UserDAOException;
	public String getMyFavorites(long userId)throws UserDAOException;
	public String getNotifications(long userId) throws UserDAOException;
	public String updateNotifications(long userId, String content) throws UserDAOException;
	
}
