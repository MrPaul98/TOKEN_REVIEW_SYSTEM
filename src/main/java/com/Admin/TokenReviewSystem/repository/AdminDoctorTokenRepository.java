package com.Admin.TokenReviewSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Admin.TokenReviewSystem.model.AdminGroundlevelDoctorToken;

public interface AdminDoctorTokenRepository extends JpaRepository<AdminGroundlevelDoctorToken, Integer> {

}
