package com.Admin.TokenReviewSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Admin.TokenReviewSystem.model.AdminGroundlevelLawyerToken;

public interface AdminLawyerTokenRepository extends JpaRepository<AdminGroundlevelLawyerToken, Integer> {

}
