package com.TokenReviewSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TokenReviewSystem.model.DoctorTokenData;

public interface DoctorTokenRepository extends JpaRepository<DoctorTokenData, Integer> {

}
