package com.Admin.TokenReviewSystem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Admin.TokenReviewSystem.error.AdminElectricianTokenException;
import com.Admin.TokenReviewSystem.error.AdminLaywerTokenException;
import com.Admin.TokenReviewSystem.model.AdminGroundlevelLawyerToken;
import com.Admin.TokenReviewSystem.repository.AdminLawyerTokenRepository;

@Service
public class AdminLawyerService {

	@Autowired
	AdminLawyerTokenRepository repository;

	public ResponseEntity<AdminGroundlevelLawyerToken> addtoken(
			AdminGroundlevelLawyerToken lawyerToken) {
		
	 Optional<AdminGroundlevelLawyerToken> lawyerdata = 
			 repository.findById(lawyerToken.getAL_id());
	try {
	 if(!lawyerdata.isPresent()) {
		return new ResponseEntity<AdminGroundlevelLawyerToken>
		(repository.save(lawyerToken),HttpStatus.OK);
	 }
	 else {
		 throw new AdminLaywerTokenException("Token is Data present");
	 }
	}
	 catch (Exception e) {
		return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
	}
	}

	public ResponseEntity<List<AdminGroundlevelLawyerToken>> getalltoken() {
		try {
		if(repository.findAll().size() > 0) {
			
			return new ResponseEntity<List<AdminGroundlevelLawyerToken>>(
					repository.findAll(),HttpStatus.OK);
			}
			else
			{
			    throw new AdminLaywerTokenException("No Token is present for you Sir");	
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<AdminGroundlevelLawyerToken> deletetoken(int eid) {
		
		Optional<AdminGroundlevelLawyerToken> lawyerdata = 
				 repository.findById(eid);
		try {
		 if(lawyerdata.isPresent()) {
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
