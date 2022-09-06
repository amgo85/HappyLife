package com.happylife.dao.implementation;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.happylife.DoMath;
import com.happylife.dao.layer.LookingForDAO;
import com.happylife.dao.layer.LookingForDAOException;
import com.happylife.dao.layer.UserDAO;
import com.happylife.dao.layer.UserDAOException;
import com.happylife.dao.registry.RegistryDAO;
import com.happylife.pojo.LookingFor;
import com.happylife.pojo.Messages;
import com.happylife.pojo.User;

public class UserDAOImpl implements UserDAO {
	static Connection conn;
	static PreparedStatement pstmt;
	static ResultSet rs;
	
	
	User userWithFieldsAssigned() throws SQLException {
		
		long userId  = rs.getLong(1);					// rs.getLong("userId");
		String fname  = rs.getString(2);				// rs.getString("FNAME");
		String lname = rs.getString(3);					// rs.getString("LNAME");
		String emailId  = rs.getString(4);				// rs.getString("EMAIL");
		String uname  = rs.getString(5);				// rs.getString("username");
		String pass  = rs.getString(6);					// rs.getString("PASSWD");
		String gender  = rs.getString(7);				// rs.getString("GENDER");
		String country  = rs.getString(8);				// rs.getString("COUNTRY");
		String phone  = rs.getString(9);				// rs.getString("PHONE");
		String image  = rs.getString(10);				// rs.getString("IMAGE");
		Date dob = rs.getDate(11);
		String residencyStatus = rs.getString(12);
		String aboutMyself = rs.getString(13);
		String lookingFor = rs.getString(14);
		String publicPhoto  = rs.getString(15);			// rs.getString("PUBLIC_PHOTO");
		Timestamp lastLogin = rs.getTimestamp(16);
		String profilePostedBy  = rs.getString(17);
		String origin  = rs.getString(18);
		String religiousHistory  = rs.getString(19);
		String hairColor  = rs.getString(20);
		String bodyType  = rs.getString(21);
		String notifications  = rs.getString(22);
		String hijabBeard  = rs.getString(23);
		String height = rs.getString(24);
		String pray = rs.getString(25);
		String sect = rs.getString(26);
		String maritalStatus = rs.getString(27);
		String children = rs.getString(28);
		String likeToHaveChildren = rs.getString(29);
		String langs = rs.getString(30);
		String profession = rs.getString(31);
		String highestQual = rs.getString(32);
		
		User user = new User(userId, fname, lname, emailId, uname, gender, country, phone, image, dob, residencyStatus, 
				aboutMyself, lookingFor, publicPhoto, lastLogin, profilePostedBy, origin, religiousHistory, hairColor,
				bodyType, notifications, hijabBeard, height, pray, sect, maritalStatus, children, likeToHaveChildren, langs, 
				profession, highestQual );
		
		return user;
	}
	
	@Override
	public User doLogin(String email, String password) throws UserDAOException {
		User userToFetch = null;
		
		try{
			conn = DatabaseConnectivity.doDBConnection();
			PreparedStatement pstmt = conn.prepareStatement("select * from HL_USERS where EMAIL=? and PASSWD=?"); 
			pstmt.setString(1,email);
			pstmt.setString(2,password);
			
			rs = pstmt.executeQuery();
			
			//ResultSet rs = statement.executeQuery("select * from HL_USERS where EMAIL='"+email+"' and PASSWD='"+password+"'");
			System.out.println("select count(*) from HL_USERS where EMAIL='"+email+"' and PASSWD='"+password+"'");
			int columnCount = 0;
			while(rs.next()){
				for (int i = 1; i <= columnCount; i++ ) {
					  String name = rs.getMetaData().getColumnName(i);
					  System.out.println("Column name: "+ name);
					}
				
				userToFetch = userWithFieldsAssigned();
				
				System.out.println("Height fetched from database inside UserDAOImpl.dologin: " + userToFetch.getHeight());
				
				
			}
			
			java.util.Date date = new java.util.Date();
			long time = date.getTime();
			Timestamp ts = new Timestamp(time);
			System.out.println("Timestamp after login is " + ts);
			pstmt = conn.prepareStatement("update HL_USERS set lastlogin=? where userId=?");
			pstmt.setLong(2,userToFetch.getUserId());
			pstmt.setTimestamp(1,ts);
			pstmt.executeUpdate();
			
			
			if(userToFetch == null){
				throw new UserDAOException("User not found");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				if(conn != null)	conn.close();
				if(pstmt != null)	pstmt.close();
				if(rs != null)		rs.close();
			} catch(Exception e){}
		}
		return userToFetch;
	}
	
	
	
	@Override
	public String doSignUp(User user) throws UserDAOException{
		boolean status = false;
		String signupStatus = "";
		try {
			conn = DatabaseConnectivity.doDBConnection();
			pstmt = conn.prepareStatement("insert into HL_USERS values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ");	// 32 total
			
			pstmt.setLong(1,user.getUserId());
			pstmt.setString(2,user.getFname());
			pstmt.setString(3,user.getLname());
			pstmt.setString(4,user.getEmail());
			pstmt.setString(5,user.getUsername());
			pstmt.setString(6,user.getPassword());
			pstmt.setString(7,user.getGender());
			pstmt.setString(8,user.getLookingIn());
			pstmt.setString(9,user.getPhone());
			pstmt.setString(10,user.getImage());
			pstmt.setDate(11,user.getDob());
			pstmt.setString(12,null);
			pstmt.setString(13,null);
			pstmt.setString(14,null);
			pstmt.setString(15,user.getPublicPhoto());
			java.util.Date date = new java.util.Date();
			long time = date.getTime();
			Timestamp ts = new Timestamp(time);
			pstmt.setTimestamp(16,ts);
			pstmt.setString(17,null);
			pstmt.setString(18,null);
			pstmt.setString(19,null);
			pstmt.setString(20,null);
			pstmt.setString(21,null);
			pstmt.setString(22," ");		// Notification with null value gives an error
			pstmt.setString(23,null);
			pstmt.setString(24,null);
			pstmt.setString(25,null);
			pstmt.setString(26,null);
			pstmt.setString(27,null);
			pstmt.setString(28,null);
			pstmt.setString(29,null);
			pstmt.setString(30,null);
			pstmt.setString(31,null);
			pstmt.setString(32,null);
			status = pstmt.execute();
						
			//statment.executeQuery("INSERT INTO 'spring'.'HL_USERS' ('userId', 'FNAME', 'LNAME', 'EMAIL', 'USERNAME', 'PASSWD', 'GENDER', 'COUNTRY', 'PHONE', 'PUBLIC_PHOTO') VALUES ('"+user.getId()+"', '"+user.getFname()+"', '"+user.getLname()+"', '"+user.getEmail()+"', '"+user.getUsername()+"', '"+user.getPassword()+"', '"+user.getGender()+"', '"+user.getCountry()+"', '"+user.getPhone()+"', '"+user.getPublicPhoto()+"')");
			
			signupStatus =  "Sign Up Successfully...";
		}catch(SQLException e) {
			System.out.println(e);
			signupStatus =  "Something went wrong with user signup please try again ! ! !";
		}
		
		return signupStatus;
	}

	@Override
	public List<User> searchBy(User sessionUser, String... v) throws UserDAOException {
		List<User> candidateList = new ArrayList<User>();
		List<User> moreLikeCandidateList = new ArrayList<User>();
		boolean isSessionUser = true;
		
		if (v.length %2 != 0) { 
			System.out.println( "wrong number of arguments, number of Arguments must be even" );
			return null;
		}
		try {
			conn = DatabaseConnectivity.doDBConnection();
			for(int i=0 ; i< v.length; i+=2) {
				switch(v[i]) {
				case "lookingIn":
					System.out.println("Inside searchBy case lookingIn");
					candidateList = getByLocation(sessionUser, v[i+1]);
					if(candidateList == null) throw new UserDAOException("Your Location Search Criteria is not met") ;
					
					break;
					
				case "likecandid":
					System.out.println("Inside searchBy: case likecandid: ");
					isSessionUser = false;
					List<User> lookingForList = getLookingForGivenUser(sessionUser, isSessionUser);	// this represents candidateUser not sessionUser
					List<User> candidLookingForList = getIamLookingFor(sessionUser, isSessionUser);	// this represents candidateUser not sessionUser
					moreLikeCandidateList = retainAllofUser(lookingForList, candidLookingForList);
					System.out.println("uids common generated from lookingForMeList.retainAll(iamLookingForList) "+ candidateList.size());
					if(moreLikeCandidateList == null) throw new UserDAOException("More like candidate Search Criteria is not met") ;
					
					break;
					
				case "lookformecb":
					System.out.println("Inside searchBy: case LookForMe");
					isSessionUser = true;
					candidateList = getLookingForGivenUser(sessionUser, isSessionUser);
					if(candidateList == null) throw new UserDAOException("You Looking_For_Me Search Criteria is not met") ;
					
					break;
				case "ilookfcb":
					System.out.println("Inside searchBy: case whom I am looking for: ");
					isSessionUser = true;
					candidateList = getIamLookingFor(sessionUser, isSessionUser);
					if(candidateList == null) throw new UserDAOException("Your whom_I_am_Looking_For Search Criteria is not met") ;
					
					break;
					
				case "idealcb":
					System.out.println("Inside searchBy: case Ideal: ");
					isSessionUser = true;
					List<User> lookingForMeList = getLookingForGivenUser(sessionUser, isSessionUser);
					List<User> iamLookingForList = getIamLookingFor(sessionUser, isSessionUser);
					candidateList = retainAllofUser(lookingForMeList, iamLookingForList);
					System.out.println("uids common generated from lookingForMeList.retainAll(iamLookingForList) "+ candidateList.size());
					if(candidateList == null) throw new UserDAOException("Your Ideal Match Search Criteria is not met") ;
					
					break;
					
				case "online":
					System.out.println("Inside searchBy: case Online: ");
					candidateList = getByOnline(sessionUser);
					if(candidateList == null) throw new UserDAOException("Your Ideal Match Search Criteria is not met") ;
					
					break;
					
				case "agel":	// this now works for ageh & agelow
					System.out.println("Inside searchBy case age");
					System.out.println("Age low inside searchBy(), agel case, agel = " + v[i+1]);
					System.out.println("Age high inside searchBy(), agel case, ageh case = " + v[i+3]);
					List<User> ageList = getByAge(sessionUser, v[i+1], v[i+3]);
					candidateList = ageList;
					//boolean isLocationInArray = Arrays.stream(v).anyMatch("location"::equals);
					//boolean isOnlineInArray = Arrays.stream(v).anyMatch("isOnline"::equals);
					//System.out.println("Does search url contain 'location'? " + isLocationInArray + ", does it contain 'online'? " + isOnlineInArray);
					List<User> list = new ArrayList<User>();
					if(!(v[i+5].equalsIgnoreCase("Any"))) { 
						list = getByLocation(sessionUser, v[i+5]);
						candidateList = retainAllofUser(candidateList, list);
						System.out.println("uids common generated from ageList.retainAll(countryList) "+ candidateList.size());
					}else if((v[i+7].equals("true"))) {
						System.out.println("v[i+7] which is online flag is "+ v[i+7]);
						list = getByOnline(sessionUser);
						candidateList = retainAllofUser(candidateList, list);
						System.out.println("uids common generated from ageList.retainAll(onlineList) "+ candidateList.size());
					}else if((v[i+9].equals("true"))) {
						System.out.println("v[i+9] which is photouploaded flag is "+ v[i+9]);
						list = getByPhotoUploaded(sessionUser);
						candidateList = retainAllofUser(candidateList, list);
						System.out.println("uids common generated from ageList.retainAll(photouploadedList) "+ candidateList.size());
					}else if((v[i+11].equals("true"))) {
						System.out.println("v[i+11] which is isNotmsged flag is "+ v[i+11]);
						List<Long> recipientIdsList = getByMessaged(sessionUser);
						/*List<Long> ageListUids = new ArrayList<Long>();
						for(User user:ageList) {
							long userId = user.getUserId();
							ageListUids.add(userId);	
						}
						List<Long> commonList = recipientIdsList;
						commonList.retainAll(ageListUids);*/
						List<User> notMessagedUserList = getNotMessagedUserList(sessionUser, recipientIdsList); 
						
						candidateList = retainAllofUser(candidateList, notMessagedUserList);
						System.out.println("uids common generated from ageList.retainAll(notMessagedUserList) "+ candidateList.size());
					}else candidateList = ageList;
					if(candidateList == null) throw new UserDAOException("You Search Criteria is not met") ;
					
					break;
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
			throw new UserDAOException(e.getMessage());
		}finally {
			try {
				if(conn != null)	conn.close();
				if(pstmt != null)	pstmt.close();
				if(rs != null)		rs.close();
			} catch(Exception e){}
		}
		
		return candidateList;
	}


	/*
	 * this user can be sessionUser
	 * it can also be used more like 'candidate'
	 * due to this fact flag to indicate which user has to passed  
	 * */
	private List<User> getLookingForGivenUser(User user, boolean isSessionUser) {
		List<User> candidateList = new ArrayList<User>();
		String matchGender = getMatchGender(user.getGender(), isSessionUser);
		
		LookingForDAO lfDao = new LookingForDAOImpl(); 
		try {
			List<Long> userIds  = lfDao.getLookingForUserIds(user);
			if(userIds.size() != 0) {
				DoMath doM = new DoMath();
				String query = doM.constructQuery(userIds, matchGender);
				System.out.println("Inside getLookingForGivenUser(): constructed Query from DoMath is: " + query);
				
				pstmt = conn.prepareStatement(query);
				rs = pstmt.executeQuery();
				
				while (rs.next()){
					
					User candidate = userWithFieldsAssigned();
					candidateList.add(candidate);
				}
			}else System.out.println("You Search Criteria is not met");
		} catch (LookingForDAOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return candidateList;
	}
	
	private List<User> getIamLookingFor(User sessionUser, boolean isSessionUser){
		List<User> candidateList = new ArrayList<User>();
		
		String matchGender = getMatchGender(sessionUser.getGender(), isSessionUser);
		
		LookingForDAO lfDao2 = new LookingForDAOImpl(); 
		try {
			LookingFor lf = lfDao2.getLookingForById(sessionUser.getUserId());
			// dummy user to hold the data got from looking_for table
			User ilookforUser = new User();
			// all these values in lookingfor table should never be equal to null
			if(lf.getLookingIn().equalsIgnoreCase("dontmind")) ilookforUser.setLookingIn(null); else ilookforUser.setLookingIn(lf.getLookingIn());
			if(lf.getEthnicOrigin().equalsIgnoreCase("dontmind")) ilookforUser.setEthnicOrigin(null); else ilookforUser.setEthnicOrigin(lf.getEthnicOrigin());
			if(lf.getBodyType().equalsIgnoreCase("dontmind"))ilookforUser.setBodyType(null);	else ilookforUser.setBodyType(lf.getBodyType());
			if(lf.getHijabBeard().equalsIgnoreCase("dontmind")) ilookforUser.setHijabBeard(null); else ilookforUser.setHijabBeard(lf.getHijabBeard());
			if(lf.getPray().equalsIgnoreCase("dontmind")) ilookforUser.setPray(null); else ilookforUser.setPray(lf.getPray());
			if(lf.getSect().equalsIgnoreCase("dontmind")) ilookforUser.setSect(null); else ilookforUser.setSect(lf.getSect());
			if(lf.getMaritalStatus().equalsIgnoreCase("dontmind")) ilookforUser.setMaritalStatus(null); else ilookforUser.setMaritalStatus(lf.getMaritalStatus());
			if(lf.getProfession().equalsIgnoreCase("dontmind")) ilookforUser.setProfession(null); else ilookforUser.setProfession(lf.getProfession());
			// I need to write sql for that
			if(lf.getReligiousHistory().equalsIgnoreCase("dontmind")) ilookforUser.setReligiousHistory(null); else ilookforUser.setReligiousHistory(lf.getReligiousHistory());
			if(lf.getResidencyStatus().equalsIgnoreCase("dontmind")) ilookforUser.setResidencyStatus(null); else ilookforUser.setResidencyStatus(lf.getResidencyStatus());
			if(lf.getHasChildren().equalsIgnoreCase("dontmind")) ilookforUser.setChildren(null); else ilookforUser.setChildren(lf.getHasChildren());
			// I need to add willingtorelocate to user object
			
			DoMath doM = new DoMath();
			String query = doM.constructQuery(ilookforUser, "select * from hl_users where ");
			if(query.equalsIgnoreCase("select * from hl_users where "))	query = query + "gender='" +matchGender+ "'";
			else query = query + " and gender='" +matchGender+ "'";
			pstmt = conn.prepareStatement(query);
			System.out.println("Inside getIamLookingFor(): constructed Query from DoMath is: " + query);
			rs = pstmt.executeQuery();
			while (rs.next()){
				
				User candidate = userWithFieldsAssigned();
				/*
				 * the candidate fetched from database user table is not checked against age criteria from looking_for table
				 * here is the if condition for that.
				 * condition to check the age may have been added to sql query but the age column is taken off
				 * & the doMath.getAge() has been used instead
				 * another option would be is to do the following to append the sql query 
				 * int year = nowCal.get(Calendar.YEAR);
				 * int yearL = year - Integer.parseInt(lf.getAgeL());	// you need to check that (!lf.getAgeL().equals("Any"))
				 * int yearH = year - Integer.parseInt(lf.getAgeH());	// you need to check that (!lf.getAgeH().equals("Any"))
				 * 
				 * query = query + " and dob BETWEEN '"+yearH+"-01-01' AND '"+yearL+"-12-31'";
				 * */
				int candidage = doM.getAge(candidate.getDob());
				if((lf.getAgeL().equals("Any")) && (lf.getAgeH().equals("Any")))	candidateList.add(candidate);
				else if(!(lf.getAgeL().equals("Any")) && (candidage >= Integer.parseInt(lf.getAgeL())))	{
					if((lf.getAgeH().equals("Any"))) candidateList.add(candidate);
					else if(candidage <= Integer.parseInt(lf.getAgeH())) candidateList.add(candidate);
				}
			}
		} catch (LookingForDAOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return candidateList;
	}
	
	private Date constructDate(String age) {
		Date dateSql = null;
		if(!age.equalsIgnoreCase("Any"))	{
			int year = Calendar.getInstance().get(Calendar.YEAR);
			int agel = Integer.parseInt(age);
			int yearL = year - agel;
			String dateStr = yearL+"-01-01";
			
			dateSql = Date.valueOf(dateStr);
		}
		return dateSql;
	}
	
	private List<User> getByAge(User sessionUser, String agelow, String agehigh) {
		List<User> candidateList = new ArrayList<User>();
		boolean isSessionUser = true;
		String matchGender = getMatchGender(sessionUser.getGender(), isSessionUser);
		Date dateLow = constructDate(agelow);
		Date dateHigh = constructDate(agehigh);
		System.out.println("Inside getByAge dateLowr = " + dateLow);
		System.out.println("Inside getByAge dateHigh = " + dateHigh);
		
		try {
			if((dateLow != null) && (dateHigh != null)) { 
				System.out.println("Inside if((dateLow != null) && (dateHigh != null))");
				pstmt = conn.prepareStatement("select * from HL_USERS where gender='"+matchGender+"' and dob between '"+dateHigh+"' and '"+dateLow+"'");
				System.out.println("select * from HL_USERS where gender='"+matchGender+"' and dob between '"+dateHigh+"' and '"+dateLow+"'");
				rs = pstmt.executeQuery();
				//pstmt.setDate(2,dateHigh);
				//pstmt.setDate(3,dateLow);
				//pstmt.setString(1,matchGender);
			}else if(dateLow != null) {
				System.out.println("Inside if(dateLow != null)");
				pstmt = conn.prepareStatement("select * from HL_USERS where gender='"+matchGender+"' and dob <= '"+dateLow+"'");
				System.out.println("select * from HL_USERS where gender='"+matchGender+"' and dob <= '"+dateLow+"'");
				rs = pstmt.executeQuery();
				//pstmt.setDate(2,dateLow);
				//pstmt.setString(1,matchGender);
			}else if(dateHigh != null) {
				System.out.println("Inside if(dateHigh != null)");
				pstmt = conn.prepareStatement("select * from HL_USERS where gender='"+matchGender+"' and dob >= '"+dateHigh+"'");
				System.out.println("select * from HL_USERS where gender='"+matchGender+"' and dob >= '"+dateHigh+"'");
				rs = pstmt.executeQuery();
				//pstmt.setDate(2,dateHigh);
				//pstmt.setString(1,matchGender);
			}else  {
				System.out.println("Inside else");
				pstmt = conn.prepareStatement("select * from HL_USERS where gender='"+matchGender+"'");		// I dont want to call out all the users
				System.out.println("select * from HL_USERS where gender='"+matchGender+"'");
				rs = pstmt.executeQuery();
				//pstmt.setString(1,matchGender);
			}
			
			while (rs.next()){
				
				User candidate = userWithFieldsAssigned();
				candidateList.add(candidate);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		return candidateList;
	}
	
	private List<User> retainAllofUser(List<User> list1, List<User> list2){
		List<Long> list1Uids = new ArrayList<Long>();
		List<Long> list2Uids = new ArrayList<Long>();;
		for(User user:list1) {
			long userId = user.getUserId();
			list1Uids.add(userId);	
		}
		for(User user:list2) {
			long userId = user.getUserId();
			list2Uids.add(userId);	
		}
		List<Long> commonUids = new ArrayList<Long>(list1Uids);
		commonUids.retainAll(list2Uids);
		List<User> candidateList = new ArrayList<User>();
		for(User u:list1.size()<list2.size()?list1:list2) {
			if(commonUids.contains(u.getUserId())) candidateList.add(u);
		}
		return candidateList;
	}
	
	private String getMatchGender(String gender, boolean isSessionUser) {
		String matchGender = "";
		if((gender.equals("M")) && (isSessionUser == true))	matchGender = "F";
		else if((gender.equals("M")) && (isSessionUser == false))	matchGender = "M";
		else if((gender.equals("F")) && (isSessionUser == true))	matchGender = "M";
		else if((gender.equals("F")) && (isSessionUser == false))	matchGender = "F";
		return matchGender;
	}

	private List<User> getByLocation(User sessionUser, String desiredLocation){
		List<User> candidateList = new ArrayList<User>();
		boolean isSessionUser = true;
		String matchGender = getMatchGender(sessionUser.getGender(), isSessionUser);
		try {
			pstmt = conn.prepareStatement("select * from HL_USERS where gender=? and lookingin=?");
			System.out.println("select * from HL_USERS where gender='"+matchGender+"' and lookingin='"+desiredLocation+"'");
			pstmt.setString(2,desiredLocation);
			pstmt.setString(1,matchGender);
			rs = pstmt.executeQuery();
			
			while (rs.next()){
				
				User candidate = userWithFieldsAssigned();
				candidateList.add(candidate);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return candidateList;
	}	
	
	private List<User> getByOnline(User sessionUser){
		List<User> candidateList = new ArrayList<User>();
		boolean isSessionUser = true;
		String matchGender = getMatchGender(sessionUser.getGender(), isSessionUser);
		
		try {
			pstmt = conn.prepareStatement("select * from HL_USERS where gender=? and lastlogin>=?");
			System.out.println("select * from HL_USERS where gender=? and lastlogin>=?");
			//java.util.Date date = new java.util.Date();
            //Timestamp current = new Timestamp(date.getTime());  
            Timestamp current = new Timestamp(System.currentTimeMillis());
            String currentStr = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(current);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime datetime = LocalDateTime.parse(currentStr.toString(), formatter);
            System.out.println("Before subtraction of minutes from date: "+ current);
            System.out.println("Before subtraction of minutes from date: "+ currentStr);
            
            datetime = datetime.minusMinutes(30);
            Timestamp tsPrevious = Timestamp.valueOf(datetime);
            String aftersubtraction = datetime.format(formatter);
            System.out.println("After 30 minutes subtraction from date: "+ aftersubtraction);
            pstmt.setString(1,matchGender);
			pstmt.setTimestamp(2,tsPrevious);
			rs = pstmt.executeQuery();
			
			while (rs.next()){
				
				User candidate = userWithFieldsAssigned();
				candidateList.add(candidate);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return candidateList;
	}
	
	private List<User> getByPhotoUploaded(User sessionUser){
		List<User> candidateList = new ArrayList<User>();
		boolean isSessionUser = true;
		String matchGender = getMatchGender(sessionUser.getGender(), isSessionUser);
		
		try {
			pstmt = conn.prepareStatement("select * from HL_USERS where gender=? and (image<>?) and (image<>?)");
			System.out.println("select * from HL_USERS where gender='"+matchGender+"' and (image<>'manonymous.png') and (image<>'fanonymous.png')");
            pstmt.setString(1,matchGender);
			pstmt.setString(2,"manonymous.png");
			pstmt.setString(3,"fanonymous.png");
			rs = pstmt.executeQuery();
			
			while (rs.next()){
				
				User candidate = userWithFieldsAssigned();
				candidateList.add(candidate);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return candidateList;
	}
	
	private List<Long> getByMessaged(User sessionUser){
		List<Long> candidateList = new ArrayList<Long>();
		
		try {
			pstmt = conn.prepareStatement("select DISTINCT recipientId from messages where senderId=?");
			System.out.println("select DISTINCT recipientId from messages where senderId='"+sessionUser.getUserId()+"'");
            pstmt.setLong(1,sessionUser.getUserId());
			rs = pstmt.executeQuery();
			
			while (rs.next()){
				//long msgId  = rs.getLong(1);
				//long senderId  = rs.getLong(2);
				long recipientId = rs.getLong(1);
				//String msgContent  = rs.getString(4);
				//Timestamp ts  = rs.getTimestamp(5);
				//boolean msgRead  = rs.getBoolean(6);
				
				//Messages msg = new Messages(msgId, senderId, recipientId, msgContent, ts, msgRead);
				candidateList.add(recipientId);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return candidateList;
	}
	
	private List<User> getNotMessagedUserList(User sessionUser, List<Long> messagedIds) {
		List<User> candidateList = new ArrayList<User>();
		boolean isSessionUser = true;
		String matchGender = getMatchGender(sessionUser.getGender(), isSessionUser);
		String query = "select * from HL_USERS where gender='"+matchGender+"' ";
		for(Long id:messagedIds) {
			query = query + "and ";
			query = query + "userId<>'"+id+"' ";
		}
		System.out.println("Constructed query inside getNotMessagedUserList() is: " + query);
		try {
			//pstmt = conn.prepareStatement("select * from HL_USERS where gender=? and userId<>?");
			pstmt = conn.prepareStatement(query);
			System.out.println("select * from HL_USERS where gender='"+matchGender+"' and userId<>?");
            //pstmt.setString(1,matchGender);
			//pstmt.setString(2,"manonymous.png");
			rs = pstmt.executeQuery();
			
			while (rs.next()){
				
				User candidate = userWithFieldsAssigned();
				candidateList.add(candidate);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return candidateList;
	}
	
	
	@Override
	public User getUserByUserId(long id) throws UserDAOException {
		User candidate = null;
		try {
			conn = DatabaseConnectivity.doDBConnection();
			pstmt = conn.prepareStatement("select * from HL_USERS where userId=?");
			pstmt.setLong(1,id);
			rs = pstmt.executeQuery();
			
			while (rs.next()){
				
				candidate = userWithFieldsAssigned();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn != null)	conn.close();
				if(pstmt != null)	pstmt.close();
				if(rs != null)		rs.close();
			} catch(Exception e){}
		}
		return candidate;
	}
	
	@Override
	public User getUserByEmail(String email) throws UserDAOException {
		User candidate = null;
		try {
			conn = DatabaseConnectivity.doDBConnection();
			pstmt = conn.prepareStatement("select * from HL_USERS where Email=?");
			pstmt.setString(1,email);
			rs = pstmt.executeQuery();
			
			while (rs.next()){
				
				candidate = userWithFieldsAssigned();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn != null)	conn.close();
				if(pstmt != null)	pstmt.close();
				if(rs != null)		rs.close();
			} catch(Exception e){}
		}
		return candidate;
	}
	
	
	// In the v array, the even index represents the key 
	@Override
	public String updateUser(long userId, String... v) throws UserDAOException {
		String msg = "";
		if (v.length %2 != 0) return "wrong number of arguments, number of Arguments must be even";
		try {
			conn = DatabaseConnectivity.doDBConnection();
			for(int i=0 ; i< v.length; i+=2) {
				switch(v[i]) {
				case "password":
					pstmt = conn.prepareStatement("update HL_USERS set passwd=? where userId=?");
					pstmt.setString(1,v[i+1]);
					pstmt.setLong(2,userId);
					pstmt.executeUpdate();
					msg = msg + "\nLPassword Updated Successfully";
					System.out.println(msg);
					break;
				/*case "Age":
					pstmt = conn.prepareStatement("update HL_USERS set age=? where userId=?");
					pstmt.setString(1,v[i+1]);
					pstmt.setLong(2,userId);
					pstmt.executeUpdate();
					msg = msg + "\nAge Updated Successfully";
					System.out.println(msg);
					break; */
				case "AboutMe":
					pstmt = conn.prepareStatement("update HL_USERS set About_Myself=? where userId=?");
					pstmt.setString(1,v[i+1]);
					pstmt.setLong(2,userId);
					pstmt.executeUpdate();
					msg = msg + "\nAboutMyself Updated Successfully";
					System.out.println(msg);
					break;
				case "language":
					pstmt = conn.prepareStatement("update HL_USERS set languages=? where userId=?");
					pstmt.setString(1,v[i+1]);
					pstmt.setLong(2,userId);
					pstmt.executeUpdate();
					msg = msg + "\nLanguages Updated Successfully";
					System.out.println(msg);
					break;
				case "personalphoto":
					pstmt = conn.prepareStatement("update HL_USERS set image=? where userId=?");
					pstmt.setString(1,v[i+1]);
					pstmt.setLong(2,userId);
					pstmt.executeUpdate();
					msg = msg + "\nPhoto Updated Successfully";
					System.out.println(msg);
					break;
				case "pcreatedby":
					pstmt = conn.prepareStatement("update HL_USERS set profilepostedby=? where userId=?");
					pstmt.setString(1,v[i+1]);
					pstmt.setLong(2,userId);
					pstmt.executeUpdate();
					msg = msg + "\nProfilePostedBy Updated Successfully";
					System.out.println(msg);
					break;
				case "residencystatus":
					pstmt = conn.prepareStatement("update HL_USERS set residency_status=? where userId=?");
					pstmt.setString(1,v[i+1]);
					pstmt.setLong(2,userId);
					pstmt.executeUpdate();
					msg = msg + "\nResidency status updated Successfully";
					System.out.println(msg);
					break;
				case "ethnic":
					pstmt = conn.prepareStatement("update HL_USERS set EthnicOrigin=? where userId=?");
					pstmt.setString(1,v[i+1]);
					pstmt.setLong(2,userId);
					pstmt.executeUpdate();
					msg = msg + "\nEthnic Origin updated Successfully";
					System.out.println(msg);
					break;
				case "rhistory":
					pstmt = conn.prepareStatement("update HL_USERS set ReligiousHistory=? where userId=?");
					pstmt.setString(1,v[i+1]);
					pstmt.setLong(2,userId);
					pstmt.executeUpdate();
					msg = msg + "\nReligious History updated Successfully";
					System.out.println(msg);
					break;
				case "pray":
					pstmt = conn.prepareStatement("update HL_USERS set Pray=? where userId=?");
					pstmt.setString(1,v[i+1]);
					pstmt.setLong(2,userId);
					pstmt.executeUpdate();
					msg = msg + "\nPray updated Successfully";
					System.out.println(msg);
					break;
				case "sect":
					pstmt = conn.prepareStatement("update HL_USERS set Sect=? where userId=?");
					pstmt.setString(1,v[i+1]);
					pstmt.setLong(2,userId);
					pstmt.executeUpdate();
					msg = msg + "\nSect updated Successfully";
					System.out.println(msg);
					break;
				case "mstatus":
					pstmt = conn.prepareStatement("update HL_USERS set MaritalStatus=? where userId=?");
					pstmt.setString(1,v[i+1]);
					pstmt.setLong(2,userId);
					pstmt.executeUpdate();
					msg = msg + "\nMaritial status updated Successfully";
					System.out.println(msg);
					break;
				case "havekids":
					pstmt = conn.prepareStatement("update HL_USERS set Children=? where userId=?");
					pstmt.setString(1,v[i+1]);
					pstmt.setLong(2,userId);
					pstmt.executeUpdate();
					msg = msg + "\nChildren updated Successfully";
					System.out.println(msg);
					break;
				case "liketohavekids":
					pstmt = conn.prepareStatement("update HL_USERS set LikeToHaveChildren=? where userId=?");
					pstmt.setString(1,v[i+1]);
					pstmt.setLong(2,userId);
					pstmt.executeUpdate();
					msg = msg + "\nLikeToHaveChildren updated Successfully";
					System.out.println(msg);
					break;
				case "bodytype":
					pstmt = conn.prepareStatement("update HL_USERS set BodyType=? where userId=?");
					pstmt.setString(1,v[i+1]);
					pstmt.setLong(2,userId);
					pstmt.executeUpdate();
					msg = msg + "\nBodyType updated Successfully";
					System.out.println(msg);
					break;
				case "haircolor":
					pstmt = conn.prepareStatement("update HL_USERS set HairColor=? where userId=?");
					pstmt.setString(1,v[i+1]);
					pstmt.setLong(2,userId);
					pstmt.executeUpdate();
					msg = msg + "\nHairColor updated Successfully";
					System.out.println(msg);
					break;
				case "hijaborbeard":
					pstmt = conn.prepareStatement("update HL_USERS set Hijab_Beard=? where userId=?");
					pstmt.setString(1,v[i+1]);
					pstmt.setLong(2,userId);
					pstmt.executeUpdate();
					msg = msg + "\nBeard updated Successfully";
					System.out.println(msg);
					break;
				case "height":
					pstmt = conn.prepareStatement("update HL_USERS set Height=? where userId=?");
					pstmt.setString(1,v[i+1]);
					pstmt.setLong(2,userId);
					pstmt.executeUpdate();
					msg = msg + "\nHeight updated Successfully";
					System.out.println(msg);
					break;
				case "profession":
					pstmt = conn.prepareStatement("update HL_USERS set Profession=? where userId=?");
					pstmt.setString(1,v[i+1]);
					pstmt.setLong(2,userId);
					pstmt.executeUpdate();
					msg = msg + "\nProfession updated Successfully";
					System.out.println(msg);
					break;
				case "hqual":
					pstmt = conn.prepareStatement("update HL_USERS set HighestQual=? where userId=?");
					pstmt.setString(1,v[i+1]);
					pstmt.setLong(2,userId);
					pstmt.executeUpdate();
					msg = msg + "\nHighestQual updated Successfully";
					System.out.println(msg);
					break;
				case "LookingFor":
					pstmt = conn.prepareStatement("update HL_USERS set looking_for=? where userId=?");
					pstmt.setString(1,v[i+1]);
					pstmt.setLong(2,userId);
					pstmt.executeUpdate();
					msg = msg + "\nLookingFor updated Successfully";
					System.out.println(msg);
					break;
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
			return "Something went wrong please try again ! ! !";
		}finally {
			try {
				if(conn != null)	conn.close();
				if(pstmt != null)	pstmt.close();
				if(rs != null)		rs.close();
			} catch(Exception e){}
		}
		return msg;
	}
	
	@Override
	public String updateAboutMe(User user, String aboutme) throws UserDAOException {
		try {
			conn = DatabaseConnectivity.doDBConnection();
			pstmt = conn.prepareStatement("update HL_USERS set about_myself=? where userId=?");
			pstmt.setLong(2,user.getUserId());
			pstmt.setString(1,aboutme);
			pstmt.executeUpdate();
			
			return "About Myself updated Successfully...";
		}catch(Exception e) {
			e.printStackTrace();
			return "Something went wrong please try again ! ! !";
		}finally {
			try {
				if(conn != null)	conn.close();
				if(pstmt != null)	pstmt.close();
				if(rs != null)		rs.close();
			} catch(Exception e){}
		}
	}
	
	@Override
	public String getAboutMe(long userId) throws UserDAOException {
		String aboutmefetched = "";
		try {
			conn = DatabaseConnectivity.doDBConnection();
			PreparedStatement pstmt = conn.prepareStatement("select about_myself from HL_USERS where userId=?");
			pstmt.setLong(1,userId);
			rs = pstmt.executeQuery();			// you have to write code for not creating more than one user with same emailid
			while (rs.next()){
				aboutmefetched  = rs.getString(1);
			}
			
			System.out.println("About me from IMPL is " + aboutmefetched);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn != null)	conn.close();
				if(pstmt != null)	pstmt.close();
				if(rs != null)		rs.close();
			} catch(Exception e){}
		}
		return aboutmefetched;
	}

	@Override
	public String getLookingFor(long userId) throws UserDAOException {
		String lookingforfetched = "";
		try {
			conn = DatabaseConnectivity.doDBConnection();
			PreparedStatement pstmt = conn.prepareStatement("select looking_for from HL_USERS where userId=?");
			pstmt.setLong(1,userId);
			rs = pstmt.executeQuery();
			while (rs.next()){
				lookingforfetched  = rs.getString(1);
			}
			System.out.println("Looking For from IMPL is " + lookingforfetched);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn != null)	conn.close();
				if(pstmt != null)	pstmt.close();
				if(rs != null)		rs.close();
			} catch(Exception e){}
		}
		return lookingforfetched;
	}

	@Override
	public String updateLookingFor(User user, String lookingfor) throws UserDAOException {
		try {
			conn = DatabaseConnectivity.doDBConnection();
			pstmt = conn.prepareStatement("update HL_USERS set looking_for=? where userId=?");
			pstmt.setLong(2,user.getUserId());
			pstmt.setString(1,lookingfor);
			pstmt.executeUpdate();
			
			return "Looking For updated Successfully...";
		}catch(Exception e) {
			e.printStackTrace();
			return "Something went wrong please try again ! ! !";
		}finally {
			try {
				if(conn != null)	conn.close();
				if(pstmt != null)	pstmt.close();
				if(rs != null)		rs.close();
			} catch(Exception e){}
		}
	}
	
	@Override
	public String updateUserPhoto(long userId, String photoName) throws UserDAOException {
		try {
			conn = DatabaseConnectivity.doDBConnection();
			pstmt = conn.prepareStatement("update HL_USERS set image=? where userId=?");
			pstmt.setLong(2,userId);
			pstmt.setString(1,photoName);
			pstmt.executeUpdate();
			
			return "Image updated Successfully...";
		}catch(Exception e) {
			e.printStackTrace();
			return "Something went wrong please try again ! ! !";
		}finally {
			try {
				if(conn != null)	conn.close();
				if(pstmt != null)	pstmt.close();
				if(rs != null)		rs.close();
			} catch(Exception e){}
		}
	}
	
	@Override
	public String add2MyFavorites(long userId, String ids) throws UserDAOException {
		String status = "";
		try { 
			conn = DatabaseConnectivity.doDBConnection(); 
			pstmt = conn.prepareStatement("update HL_USERS set MY_FAV=? where userId=?");
			pstmt.setLong(2,userId); 
			pstmt.setString(1,ids); 
			pstmt.executeUpdate();
			status = "success";
		}catch(Exception e) { 
			status = "failed";
			e.printStackTrace(); 
		}finally { 
			try { 
				if(conn != null) conn.close(); 
				if(pstmt != null) pstmt.close(); 
				if(rs != null) rs.close(); }
		 catch(Exception e){}
		}
		return status;
	}
	
	@Override
	public String removeFromMyFavorites(long userId, long candidId) throws UserDAOException {
		System.out.println("Inside removeFromMyFavorites, removing " + candidId + "....");
		String status = "";
		String myFav = getMyFavorites(userId);
		DoMath doM = new DoMath();
		List<Long> ids = doM.string2List(myFav);
		ids.remove(candidId);
		myFav = ids.toString();
		status = add2MyFavorites(userId,myFav);
		return status;
	}
	
	@Override
	public String getMyFavorites(long userId)throws UserDAOException{
		String myFavFetched = "";
		try {
			conn = DatabaseConnectivity.doDBConnection();
			PreparedStatement pstmt = conn.prepareStatement("select my_fav from HL_USERS where userId=?");
			pstmt.setLong(1,userId);
			rs = pstmt.executeQuery();
			while (rs.next()){
				myFavFetched  = rs.getString(1);
			}
			System.out.println("inside getMyFavorites(), is " + myFavFetched);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn != null)	conn.close();
				if(pstmt != null)	pstmt.close();
				if(rs != null)		rs.close();
			} catch(Exception e){}
		}
		return myFavFetched;
	}
	
	@Override
	public String updateNotifications(long userId, String content) throws UserDAOException {
		String Notification = "";
		Notification = getNotifications(userId);
		System.out.println("Inside UserDAOImpl.updateNotification()");
		System.out.println("Notification from User with id = "+ userId + " is: " + Notification);
		if(!Notification.equals("") || Notification != null)	Notification = Notification + ", " + content;
		String status = "";
		try { 
			conn = DatabaseConnectivity.doDBConnection();
			pstmt = conn.prepareStatement("update HL_USERS set notifications=? where userId=?");
			pstmt.setLong(2,userId); 
			pstmt.setString(1,content); 
			pstmt.executeUpdate();
			status = "success";
		}catch(Exception e) { 
			status = "failed";
			e.printStackTrace(); 
		}finally { 
			try { 
				if(conn != null) conn.close(); 
				if(pstmt != null) pstmt.close(); 
				if(rs != null) rs.close(); }
		 catch(Exception e){}
		}
		return status;
	}
	
	@Override
	public String getNotifications(long userId)throws UserDAOException{
		String myNotification = "";
		try {
			conn = DatabaseConnectivity.doDBConnection();
			PreparedStatement pstmt = conn.prepareStatement("select notifications from HL_USERS where userId=?");
			pstmt.setLong(1,userId);
			rs = pstmt.executeQuery();
			while (rs.next()){
				myNotification  = rs.getString(1);
			}
			System.out.println("inside getNotifications(), is " + myNotification);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn != null)	conn.close();
				if(pstmt != null)	pstmt.close();
				if(rs != null)		rs.close();
			} catch(Exception e){}
		}
		return myNotification;
	}
	
	/*
	 * @Override public void setLoginTime(long userId, Timestamp ts) throws
	 * UserDAOException { try { conn = DatabaseConnectivity.doDBConnection(); pstmt
	 * = conn.prepareStatement("update HL_USERS set lastlogin=? where userId=?");
	 * pstmt.setLong(2,userId); pstmt.setTimestamp(1,ts); pstmt.executeUpdate();
	 * 
	 * 
	 * }catch(Exception e) { e.printStackTrace(); }finally { try { if(conn != null)
	 * conn.close(); if(pstmt != null) pstmt.close(); if(rs != null) rs.close(); }
	 * catch(Exception e){} } }
	 */
	
	@Override
	public User doHibernateLogin(String email, String password) throws UserDAOException {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateConnection.doHibernateConnection();
		Session session = sessionFactory.openSession();
		try{	
			session.beginTransaction();
			List<User> user = session.createQuery("From User where email='"+email+"' and password='"+password+"'").list();
			
			if(user.size() == 1) return user.get(0);
			else throw new UserDAOException("user not found") ;
			
		}catch(Exception e){
			throw new UserDAOException(e.getMessage());
		}finally{
			session.close();
		}
	}

	@Override
	public String doHibernateSignUp(User user) {
		SessionFactory sessionFactory = HibernateConnection.doHibernateConnection();
		Session session = sessionFactory.openSession();
		try{
			System.out.println("Inside doHibernateSignUp");
			session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();
			return "Sign Up Successfully...";
			
		}catch(Exception e){
			e.printStackTrace();
			return "User is already there with this username";
		}finally{
			session.close();
		}
	}

}
