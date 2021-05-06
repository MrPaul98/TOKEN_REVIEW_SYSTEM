package com.TokenReviewSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TokenReviewSystem.model.UserData;

@Repository
public interface UserDataRepository extends JpaRepository<UserData, Integer>{

}
