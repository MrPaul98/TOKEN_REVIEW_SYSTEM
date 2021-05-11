package com.TokenReviewSystem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.TokenReviewSystem.error.LawyerException;
import com.TokenReviewSystem.error.UserException;
import com.TokenReviewSystem.model.LawyerTokenData;
import com.TokenReviewSystem.model.UserData;
import com.TokenReviewSystem.repository.LawyerTokenRepository;
import com.TokenReviewSystem.repository.UserDataRepository;
import com.TokenReviewSystem.repository.UserRepository;

@Service
public class LawyerTokenServices {

	
	@Autowired
    LawyerTokenRepository lawrepository;
	@Autowired
	UserDataRepository userdatarepo;
	@Autowired
	UserRepository userrepository;

	public ResponseEntity<LawyerTokenData> addtoken(LawyerTokenData lawyerTokenData) {
	 Optional<LawyerTokenData> Lawyerdata = lawrepository.findById(lawyerTokenData.getL_id());
	try {
	 if(!Lawyerdata.isPresent()) {
		return new ResponseEntity<LawyerTokenData>
		(lawrepository.save(lawyerTokenData),HttpStatus.OK);
	 }
	 else {
		 throw new LawyerException("Token Data is present");
	 }
	}
	 catch (Exception e) {
		return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
	}
	}

	public ResponseEntity<List<LawyerTokenData>> getalltoken() {
		try {
		if(lawrepository.findAll().size() > 0) {
			return new ResponseEntity<List<LawyerTokenData>>(
					lawrepository.findAll(),HttpStatus.OK);
			}
			else
			{
			    throw new LawyerException("No Token is present for you Sir");	
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<UserData> findpatientdata(String email) {
		
		int ID = userrepository.findidandupdate(email);
		Optional<UserData> patientdata = userdatarepo.findById(ID);
		try {
			if(patientdata.isPresent()) {
				return new ResponseEntity<UserData>(patientdata.get(),HttpStatus.OK);
			}
			else {
				throw new UserException("No User found Sir");
			}
		} catch (Exception e) {
			
			return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
		}
		
	}
}
