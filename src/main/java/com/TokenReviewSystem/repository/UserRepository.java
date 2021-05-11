package com.TokenReviewSystem.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.TokenReviewSystem.model.UserloginData;

@Repository
public interface UserRepository extends JpaRepository<UserloginData, Integer>{

	public Optional<UserloginData> findByEmailId(String emailId);
	
	public Optional<UserloginData> findAllByEmailIdAndPassword(String emailID, String password);

	 public Optional<UserloginData> findAllByEmailIdAndPasswordAndUsertype(String emailID, String password, String customertype);

	 
	 @Query(value="select userdata_id_data from userlogin_data where email_id = ?1",nativeQuery = true)
	 public int findidandupdate(String email);
	 
	 @Query(value="select * from userlogin_data where email_id = ?1",nativeQuery = true)
	 public List<UserloginData> findalldatafromemail(String email);
	 
	 @Transactional
	 @Modifying
	 @Query(value="update userlogin_data set password=?3 where email_id = ?1 and password=?2",nativeQuery = true)
     public int updatepassword(String email, String prevpassword, String newpassword);
}
