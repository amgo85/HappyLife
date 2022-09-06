# HappyLife


create table HL_USERS (userId bigint AUTO_INCREMENT, FNAME varchar(15), LNAME varchar(15), 
                       EMAIL varchar(200), username varchar(10), PASSWD varchar(12), 
                       GENDER varchar(5), LOOKINGIN varchar(20), PHONE varchar(20), 
                       IMAGE varchar(50), DOB date, RESIDENCY_STATUS varchar(10), 
                       ABOUT_MYSELF varchar(1000),  MY_FAV varchar(50), 
                       PUBLIC_PHOTO varchar(10),  LastLogin timestamp, 
                       ProfilePostedBy varchar(20), EthnicOrigin varchar(10), 
                       religiousHistory varchar(10), HairColor varchar(10), BodyType varchar(10), 
                       NOTIFICATIONS varchar(10), Hijab_Beard varchar(8), Height varchar(10), 
                       Pray varchar(10), Sect varchar(10), MaritalStatus varchar(10), 
                       Children varchar(10), LikeToHaveChildren varchar(10), 
                       Language varchar(20), Profession varchar(10), HighestQual varchar(10),
                       PRIMARY KEY (userId) );



Create table MESSAGES (msgId bigint, senderId bigint, recipientId bigint, msgContent varchar(200),
                       msgTime timestamp, msgRead boolean	, msgApproved boolean);


create table LOOKING_FOR (ID bigint AUTO_INCREMENT, userId bigint, AgeL varchar(5), 
                          AgeH varchar(5), LOOKINGIN varchar(30), 
                          RESIDENCY_STATUS varchar(20), WILLING_TO_RELOCATE 
                          varchar(10), ethnicOrigin varchar(20), religiousHistory varchar(20), 
                          Living_With_InLaws varchar(20), Pray varchar(20), Sect varchar(15), 
                          MaritalStatus varchar(20), HasChildren varchar(10), 
                          HasPDisability varchar(10), LikeToHaveChildren varchar(10), 
	                        Polygamy varchar(10), BodyType varchar(20), HeightL varchar(10), 
                          HeightH varchar(10), Hijab_Beard varchar(8),
                       		Profession varchar(20),  MinimumQual varchar(10), 
                          LOOKING_FOR varchar(1000), PRIMARY KEY (ID));
                          
                          
create table viewed (id bigint, uid1 bigint, uid2 bigint, historyContent varchar(1000), 
                     user1vieweduser2 boolean, user2vieweduser1 boolean, 
                     user1inviteduser2 boolean, user2inviteduser1 boolean, 
                     user1Notes varchar(200), user2Notes varchar(200));

create table message_approval (msgId bigint, AdminId bigint, msgApproved boolean);


create table Admin (AdminId integer, EMAIL varchar(25), FNAME varchar(15), LNAME varchar(15), 
                    username varchar(10), PASSWD varchar(12), GENDER varchar(5), DOB date, 
                    PHONE varchar(20));


create table RESET_PASS (TOKEN VARCHAR(126) NOT NULL,
				EMAIL VARCHAR(50) NOT NULL,         
				CREATION_TIME DATETIME NOT NULL,        
				PRIMARY KEY(TOKEN) );
