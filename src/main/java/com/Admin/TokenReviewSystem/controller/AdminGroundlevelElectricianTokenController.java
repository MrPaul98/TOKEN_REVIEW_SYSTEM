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

import com.Admin.TokenReviewSystem.model.AdminGroundlevelElectricianToken;
import com.Admin.TokenReviewSystem.services.AdminElectricianservices;

@RestController
@RequestMapping("/AETRS")
public class AdminGroundlevelElectricianTokenController {

	@Autowired
	AdminElectricianservices aeservices;
	
	@PostMapping("/AddEletoken")
	public ResponseEntity<AdminGroundlevelElectricianToken> addElectricianToken(@RequestBody 
			AdminGroundlevelElectricianToken adminGroundlevelElectricianToken) {
		
		return aeservices.addtoken(adminGroundlevelElectricianToken);
	}
	
	@GetMapping("/getEletoken")
	public ResponseEntity<List<AdminGroundlevelElectricianToken>> Getalltoken(){
		
		return aeservices.getalltoken();
	}
	@DeleteMapping("/deletetoken/{E_id}")
	public ResponseEntity<AdminGroundlevelElectricianToken> deletetoken(@PathVariable("E_id") int Eid){
		
		return aeservices.deletetoken(Eid); 
	}
}
