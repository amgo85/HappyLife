package com.happylife.dao.layer;

import java.util.List;

import com.happylife.pojo.Viewed;

public interface ViewedDAO {
	public String insertViewed(Viewed v) throws ViewedDAOException;
	public String checkIfRecordExists(long uid1, long uid2)throws ViewedDAOException;
	public String updateViewed(long uid1,long uid2, String ...v) throws ViewedDAOException;
	public List<Viewed> getViewedForUser(long userId, String gender) throws ViewedDAOException;
}
