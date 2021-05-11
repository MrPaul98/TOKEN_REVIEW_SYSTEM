package com.Admin.TokenReviewSystem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Admin.TokenReviewSystem.error.AdminDoctorTokenException;
import com.Admin.TokenReviewSystem.error.AdminElectricianTokenException;
import com.Admin.TokenReviewSystem.model.AdminGroundlevelDoctorToken;
import com.Admin.TokenReviewSystem.repository.AdminDoctorTokenRepository;

@Service
public class AdminDoctorServices {

	@Autowired
	AdminDoctorTokenRepository AdminDoctortokenrepository;

	public ResponseEntity<AdminGroundlevelDoctorToken> addtoken(
			AdminGroundlevelDoctorToken doctorToken) {
	 Optional<AdminGroundlevelDoctorToken> doctordata = AdminDoctortokenrepository.findById(doctorToken.getAD_id());
	try {
	 if(!doctordata.isPresent()) {
		return new ResponseEntity<AdminGroundlevelDoctorToken>
		(AdminDoctortokenrepository.save(doctorToken),HttpStatus.OK);
	 }
	 else {
		 throw new AdminDoctorTokenException("Token is Data present");
	 }
	}
	 catch (Exception e) {
		return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
	}
	}

	public ResponseEntity<List<AdminGroundlevelDoctorToken>> getalltoken() {
		try {
		if(AdminDoctortokenrepository.findAll().size() > 0) {
			return new ResponseEntity<List<AdminGroundlevelDoctorToken>>(
					AdminDoctortokenrepository.findAll(),HttpStatus.OK);
			}
			else
			{
			    throw new AdminDoctorTokenException("No Token is present for you Sir");	
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
	
	public ResponseEntity<AdminGroundlevelDoctorToken> deletetoken(int eid) {
		
		Optional<AdminGroundlevelDoctorToken> doctordata = 
				AdminDoctortokenrepository.findById(eid);
		try {
		 if(doctordata.isPresent()) {
			 AdminDoctortokenrepository.deleteById(eid);
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
