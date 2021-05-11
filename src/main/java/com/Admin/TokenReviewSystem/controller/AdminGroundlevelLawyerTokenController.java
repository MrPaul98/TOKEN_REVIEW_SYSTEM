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

import com.Admin.TokenReviewSystem.model.AdminGroundlevelLawyerToken;
import com.Admin.TokenReviewSystem.services.AdminLawyerService;

@RestController
@RequestMapping("/ALTRS")
public class AdminGroundlevelLawyerTokenController {

	@Autowired
	AdminLawyerService alservices;
	
	@PostMapping("/AddLawtoken")
	public ResponseEntity<AdminGroundlevelLawyerToken> addLawyerToken(@RequestBody 
			AdminGroundlevelLawyerToken adminGroundlevellawyerToken) {
		
		return alservices.addtoken(adminGroundlevellawyerToken);
	}
	
	@GetMapping("/getLawtoken")
	public ResponseEntity<List<AdminGroundlevelLawyerToken>> Getalltoken(){
		
		return alservices.getalltoken();
	}
	@DeleteMapping("/deletetoken/{L_id}")
	public ResponseEntity<AdminGroundlevelLawyerToken> deletetoken(@PathVariable("L_id") int Lid){
		
		return alservices.deletetoken(Lid); 
	}
}
