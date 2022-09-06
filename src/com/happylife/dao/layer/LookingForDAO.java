package com.happylife.dao.layer;

import java.util.List;

import com.happylife.pojo.LookingFor;
import com.happylife.pojo.User;

public interface LookingForDAO {
	public String insertLookingFor(LookingFor lookingfor)throws LookingForDAOException;
	public String updateLookingFor(long userId, String ...v)throws LookingForDAOException;
	public LookingFor getLookingForById(long userId)throws LookingForDAOException;
	public List<LookingFor> getAllLookingForGivenAge(int age)throws LookingForDAOException;
	public String [][] getAgeRangesForGivenAge(int age)throws LookingForDAOException;
	public List<LookingFor> getAllLookingForGivenHeight(String height)throws LookingForDAOException;
	public String [][] getHeightRangesForGivenHeight(String height)throws LookingForDAOException;
	public List<Long> getLookingForUserIds(User user )throws LookingForDAOException;
}
