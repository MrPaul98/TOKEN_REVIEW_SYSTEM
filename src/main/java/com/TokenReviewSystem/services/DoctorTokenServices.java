package com.TokenReviewSystem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.TokenReviewSystem.error.DoctorException;
import com.TokenReviewSystem.error.UserException;
import com.TokenReviewSystem.model.DoctorTokenData;
import com.TokenReviewSystem.model.UserData;
import com.TokenReviewSystem.repository.DoctorTokenRepository;
import com.TokenReviewSystem.repository.UserDataRepository;
import com.TokenReviewSystem.repository.UserRepository;

@Service
public class DoctorTokenServices {

	@Autowired
	DoctorTokenRepository doctortokenrepository;
	@Autowired
	UserDataRepository userdatarepo;
	@Autowired
	UserRepository userrepository;

	public ResponseEntity<DoctorTokenData> addtoken(DoctorTokenData doctortokendata) {
	 Optional<DoctorTokenData> doctordata = doctortokenrepository.findById(doctortokendata.getT_id());
	try {
	 if(!doctordata.isPresent()) {
		return new ResponseEntity<DoctorTokenData>
		(doctortokenrepository.save(doctortokendata),HttpStatus.OK);
	 }
	 else {
		 throw new DoctorException("Token is Data present");
	 }
	}
	 catch (Exception e) {
		return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
	}
	}

	public ResponseEntity<List<DoctorTokenData>> getalltoken() {
		try {
		if(doctortokenrepository.findAll().size() > 0) {
			return new ResponseEntity<List<DoctorTokenData>>(
					doctortokenrepository.findAll(),HttpStatus.OK);
			}
			else
			{
			    throw new DoctorException("No Token is present for you Sir");	
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
