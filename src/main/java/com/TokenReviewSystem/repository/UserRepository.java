package com.TokenReviewSystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TokenReviewSystem.model.UserloginData;

@Repository
public interface UserRepository extends JpaRepository<UserloginData, Integer>{

	public Optional<UserloginData> findByEmailId(String emailId);

	 public Optional<UserloginData> findAllByEmailIdAndPasswordAndUsertype(String emailID, String password, String customertype);

}
