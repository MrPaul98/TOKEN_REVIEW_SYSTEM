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

import com.TokenReviewSystem.model.DoctorTokenData;
import com.TokenReviewSystem.model.UserData;
import com.TokenReviewSystem.services.DoctorTokenServices;

@RestController
@RequestMapping("/DTRS")
public class DoctorTokenController {
	
	@Autowired
	DoctorTokenServices dtservice;

	@PostMapping("/AddDoctoken")
	public ResponseEntity<DoctorTokenData> addDoctorToken(@RequestBody DoctorTokenData doctorTokenData) {
		
		return dtservice.addtoken(doctorTokenData);
	}
	
	@GetMapping("/getDoctoken")
	public ResponseEntity<List<DoctorTokenData>> Getalltoken(){
		
		return dtservice.getalltoken();
	}
	
	@GetMapping("/getpatientdata/{email}")
	public ResponseEntity<UserData> getpatientdata(@PathVariable("email") String email){
		
		return dtservice.findpatientdata(email);
		
	}
}
