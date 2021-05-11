package com.TokenReviewSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TokenReviewSystem.model.ElectricianTokenData;

public interface ElectricianTokenRepository extends JpaRepository<ElectricianTokenData, Integer> {

}
