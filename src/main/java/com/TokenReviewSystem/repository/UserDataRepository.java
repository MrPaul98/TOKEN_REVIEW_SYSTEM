package com.TokenReviewSystem.repository;



import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.TokenReviewSystem.model.UserData;

@Repository
public interface UserDataRepository extends JpaRepository<UserData, Integer>{

	 @Transactional
	 @Modifying
	 @Query(value = "update user_data set city = ?2,firstname = ?3 , lastname = ?4"
		 		+ ",middlename = ?5,phonenumber = ?6,pincode = ?7"
		 		+ ",state = ?8 where id_data = ?1" , nativeQuery = true)
		 public int UpdateUserdata(int id_data,String city,
				 String firstname ,String lastname,
				 String middlename,String phonenumber,
				 int pincode,String state);
	 
	
	 
	 
}
