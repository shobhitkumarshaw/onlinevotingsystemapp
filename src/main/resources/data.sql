INSERT INTO ADMIN (ADMIN_NAME,ADMIN_PASSWORD)values('SHOBHIT','PASSWORD');
INSERT INTO ADMIN (ADMIN_NAME,ADMIN_PASSWORD)values('ABHISHEK','PASSWORD');
INSERT INTO ADMIN (ADMIN_NAME,ADMIN_PASSWORD)values('EKANSH','PASSWORD');

INSERT INTO ELECTION_OFFICER (ADDRESS1,ADDRESS2,DISTRICT,EMAIL_ID,FIRST_NAME,GENDER,LAST_NAME,MOBILENO,PASSWORD,PINCODE) values('ad12','ad23','dis11','pawan@gmail.com','pawan','male','Tiwari','987654231','Bcrec11',123654);
INSERT INTO ELECTION_OFFICER (ADDRESS1,ADDRESS2,DISTRICT,EMAIL_ID,FIRST_NAME,GENDER,LAST_NAME,MOBILENO,PASSWORD,PINCODE) values('ad23','ad34','dis22','raja@gmail.com','raja','male','babu','487654231','Bcrec22',223654);
INSERT INTO ELECTION_OFFICER (ADDRESS1,ADDRESS2,DISTRICT,EMAIL_ID,FIRST_NAME,GENDER,LAST_NAME,MOBILENO,PASSWORD,PINCODE) values('ad34','ad45','dis33','papu@gmail.com','papu','male','yadav','387654231','Bcrec33',323654);
INSERT INTO ELECTION_OFFICER (ADDRESS1,ADDRESS2,DISTRICT,EMAIL_ID,FIRST_NAME,GENDER,LAST_NAME,MOBILENO,PASSWORD,PINCODE) values('ad45','ad56','dis44','anmol@gmail.com','anmol','male','Tiwari','287654231','Bcrec44',523654);


INSERT INTO ELECTION_RESULT (CANDIDATE_VOTES_PERCENTAGE,POLLING_DATE ,RESULT ,TOTAL_CANDIDATE_VOTES ,TOTAL_POLLED_VOTES ,TOTAL_POLLING_PERCENTAGE ,TOTAL_SOCIETY_VOTES) values(40,'2021-06-26','Loss',4000,10000,33.33,30000);
INSERT INTO ELECTION_RESULT (CANDIDATE_VOTES_PERCENTAGE,POLLING_DATE ,RESULT ,TOTAL_CANDIDATE_VOTES ,TOTAL_POLLED_VOTES ,TOTAL_POLLING_PERCENTAGE ,TOTAL_SOCIETY_VOTES) values(20,'2021-04-14','Loss',2000,10000,25,40000);
INSERT INTO ELECTION_RESULT (CANDIDATE_VOTES_PERCENTAGE,POLLING_DATE ,RESULT ,TOTAL_CANDIDATE_VOTES ,TOTAL_POLLED_VOTES ,TOTAL_POLLING_PERCENTAGE ,TOTAL_SOCIETY_VOTES) values(60,'2021-08-18','Win',6000,10000,25,50000);
INSERT INTO ELECTION_RESULT (CANDIDATE_VOTES_PERCENTAGE,POLLING_DATE ,RESULT ,TOTAL_CANDIDATE_VOTES ,TOTAL_POLLED_VOTES ,TOTAL_POLLING_PERCENTAGE ,TOTAL_SOCIETY_VOTES) values(50,'2021-05-25','Draw',5000,10000,50,20000);


INSERT INTO REGISTERED_SOCIETY_VOTERS (ADDRESS ,CASTED_VOTE ,DISTRICT, EMAIL_ID,FIRST_NAME ,GENDER ,LAST_NAME ,MANDAL ,MOBILENO ,PASSWORD ,PINCODE ,RESERVATION_CATEGORY ,STATUS ,VOTER_ID_CARD_NO ,COOPERATIVE_SOCIETY_FK ) VALUES  ('BTM Layout', False, 'Banglore South', 'ritik.kumar@gmail.com', 'Ritik', 'Male', 'Kumar', 'BTM Mandal', '9938667700', 'password', 560068, 'gen', 'active', 'v12345', null);
INSERT INTO REGISTERED_SOCIETY_VOTERS (ADDRESS ,CASTED_VOTE ,DISTRICT, EMAIL_ID,FIRST_NAME ,GENDER ,LAST_NAME ,MANDAL ,MOBILENO ,PASSWORD ,PINCODE ,RESERVATION_CATEGORY ,STATUS ,VOTER_ID_CARD_NO ,COOPERATIVE_SOCIETY_FK ) VALUES  ('Pujariput', False, 'Banglore North', 'aditya.mohapatra@gmail.com', 'Adiya', 'Male', 'mohapatra', 'Pujariput Mandal', '9517536548', 'pass124', 258369, 'gen', 'active', 'v22345', null);
INSERT INTO REGISTERED_SOCIETY_VOTERS (ADDRESS ,CASTED_VOTE ,DISTRICT, EMAIL_ID,FIRST_NAME ,GENDER ,LAST_NAME ,MANDAL ,MOBILENO ,PASSWORD ,PINCODE ,RESERVATION_CATEGORY ,STATUS ,VOTER_ID_CARD_NO ,COOPERATIVE_SOCIETY_FK ) VALUES  ('DNK Chock', False, 'Banglore East', 'bhanu.Ngidi@gmail.com', 'Bhanu', 'Male', 'Ngidi', 'DNK Mandal', '4123657896', 'pas8526', 456987, 'gen', 'active', 'v32345', null);
INSERT INTO REGISTERED_SOCIETY_VOTERS (ADDRESS ,CASTED_VOTE ,DISTRICT, EMAIL_ID,FIRST_NAME ,GENDER ,LAST_NAME ,MANDAL ,MOBILENO ,PASSWORD ,PINCODE ,RESERVATION_CATEGORY ,STATUS ,VOTER_ID_CARD_NO ,COOPERATIVE_SOCIETY_FK ) VALUES  ('HSR Layout', False, 'Banglore South', 'govind.k@gmail.com', 'Govind', 'Male', 'k', 'HSR Mandal', '6523149875', 'pasdfsdgf', 23529, 'gen', 'active', 'v42345', null);
INSERT INTO REGISTERED_SOCIETY_VOTERS (ADDRESS ,CASTED_VOTE ,DISTRICT, EMAIL_ID,FIRST_NAME ,GENDER ,LAST_NAME ,MANDAL ,MOBILENO ,PASSWORD ,PINCODE ,RESERVATION_CATEGORY ,STATUS ,VOTER_ID_CARD_NO ,COOPERATIVE_SOCIETY_FK ) VALUES  ('Kormangala', False, 'Banglore West', 'shobhit.kumar@gmail.com', 'Shobhit', 'Male', 'Kumar', 'Kormangala Mandal', '2581473695', 'passtr4rd', 453697, 'gen', 'active', 'v52345', null);

INSERT INTO NOMINATED_CANDIDATES (APPROVED_BY_ELECTION_OFFICER ,NOMINATION_FORM_NO ,OATH_OR_AFFIRMATION_SUMMITED ,PARTY_NAME ,POLICE_VERIFICATION_DONE ,SECURITY_DEPOSIT ,SYMBOL ,COOPERATIVE_SOCIETY_FK ,REGISTERED_SOCIETY_VOTER_FK ) VALUES (false, 125, false, 'bikash', false, 55000, 'flag', null, null);

