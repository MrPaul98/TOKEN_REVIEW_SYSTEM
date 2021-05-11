package com.TokenReviewSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TokenReviewSystem.model.LawyerTokenData;

public interface LawyerTokenRepository extends JpaRepository<LawyerTokenData, Integer> {

}
