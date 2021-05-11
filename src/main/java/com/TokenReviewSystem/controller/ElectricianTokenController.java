package com.TokenReviewSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TokenReviewSystem.model.ElectricianTokenData;
import com.TokenReviewSystem.model.UserData;
import com.TokenReviewSystem.services.ElectricianTokenServices;

@RestController
@RequestMapping("/ETRS")
public class ElectricianTokenController {

	@Autowired
	ElectricianTokenServices eleservices;

	@PostMapping("/AddEletoken")
	public ResponseEntity<ElectricianTokenData> addDoctorToken(@RequestBody ElectricianTokenData electricianTokenData) {
		
		return eleservices.addtoken(electricianTokenData);
	}
	
	@GetMapping("/getEletoken")
	public ResponseEntity<List<ElectricianTokenData>> Getalltoken(){
		
		return eleservices.getalltoken();
	}
	
	@GetMapping("/getpatientdata/{email}")
	public ResponseEntity<UserData> getpatientdata(@PathVariable("email") String email){
		
		return eleservices.findpatientdata(email);
		
	}
}
