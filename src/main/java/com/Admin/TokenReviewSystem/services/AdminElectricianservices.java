package com.Admin.TokenReviewSystem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Admin.TokenReviewSystem.error.AdminElectricianTokenException;
import com.Admin.TokenReviewSystem.model.AdminGroundlevelElectricianToken;
import com.Admin.TokenReviewSystem.repository.AdminElectricianTokenRepository;

@Service
public class AdminElectricianservices {

	@Autowired
	AdminElectricianTokenRepository repository;

	public ResponseEntity<AdminGroundlevelElectricianToken> addtoken(
			AdminGroundlevelElectricianToken electritionToken) {
		
	 Optional<AdminGroundlevelElectricianToken> Electriciandata = 
			 repository.findById(electritionToken.getAE_id());
	try {
	 if(!Electriciandata.isPresent()) {
		return new ResponseEntity<AdminGroundlevelElectricianToken>
		(repository.save(electritionToken),HttpStatus.OK);
	 }
	 else {
		 throw new AdminElectricianTokenException("Token is Data present");
	 }
	}
	 catch (Exception e) {
		return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
	}
	}

	public ResponseEntity<List<AdminGroundlevelElectricianToken>> getalltoken() {
		try {
		if(repository.findAll().size() > 0) {
			
			return new ResponseEntity<List<AdminGroundlevelElectricianToken>>(
					repository.findAll(),HttpStatus.OK);
			}
			else
			{
			    throw new AdminElectricianTokenException("No Token is present for you Sir");	
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<AdminGroundlevelElectricianToken> deletetoken(int eid) {
		
		Optional<AdminGroundlevelElectricianToken> Electriciandata = 
				 repository.findById(eid);
		try {
		 if(Electriciandata.isPresent()) {
			 repository.deleteById(eid);
			return new ResponseEntity("DATA DELETED SUCCESFULLY",HttpStatus.OK);
		 }
		 else {
			 throw new AdminElectricianTokenException("Token Data is not present");
		 }
		}
		 catch (Exception e) {
			return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
}
