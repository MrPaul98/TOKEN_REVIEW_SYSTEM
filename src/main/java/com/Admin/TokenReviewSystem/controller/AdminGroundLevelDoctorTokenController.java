package com.Admin.TokenReviewSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Admin.TokenReviewSystem.model.AdminGroundlevelDoctorToken;
import com.Admin.TokenReviewSystem.services.AdminDoctorServices;

@RestController
@RequestMapping("/ADTRS")
public class AdminGroundLevelDoctorTokenController {
	

	@Autowired
	AdminDoctorServices adservice;

	@PostMapping("/AddDoctoken")
	public ResponseEntity<AdminGroundlevelDoctorToken> addDoctorToken(@RequestBody 
			AdminGroundlevelDoctorToken adminGroundlevelDoctorToken) {
		
		return adservice.addtoken(adminGroundlevelDoctorToken);
	}
	
	@GetMapping("/getDoctoken")
	public ResponseEntity<List<AdminGroundlevelDoctorToken>> Getalltoken(){
		
		return adservice.getalltoken();
	}
	
	@DeleteMapping("/deletetoken/{D_id}")
	public ResponseEntity<AdminGroundlevelDoctorToken> deletetoken(@PathVariable("D_id") int Did){
		
		return adservice.deletetoken(Did); 
	}
}
