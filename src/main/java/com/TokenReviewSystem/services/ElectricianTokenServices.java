package com.TokenReviewSystem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.TokenReviewSystem.error.ElectricianException;
import com.TokenReviewSystem.error.UserException;
import com.TokenReviewSystem.model.ElectricianTokenData;
import com.TokenReviewSystem.model.UserData;
import com.TokenReviewSystem.repository.ElectricianTokenRepository;
import com.TokenReviewSystem.repository.UserDataRepository;
import com.TokenReviewSystem.repository.UserRepository;

@Service
public class ElectricianTokenServices {
	
	@Autowired
	ElectricianTokenRepository electricianrepository;
	@Autowired
	UserDataRepository userdatarepo;
	@Autowired
	UserRepository userrepository;

	public ResponseEntity<ElectricianTokenData> addtoken(ElectricianTokenData electricianTokenData) {
	 Optional<ElectricianTokenData> Electriciandata = electricianrepository.findById(electricianTokenData.getE_id());
	try {
	 if(!Electriciandata.isPresent()) {
		return new ResponseEntity<ElectricianTokenData>
		(electricianrepository.save(electricianTokenData),HttpStatus.OK);
	 }
	 else {
		 throw new ElectricianException("Token Data is present");
	 }
	}
	 catch (Exception e) {
		return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
	}
	}

	public ResponseEntity<List<ElectricianTokenData>> getalltoken() {
		try {
		if(electricianrepository.findAll().size() > 0) {
			return new ResponseEntity<List<ElectricianTokenData>>(
					electricianrepository.findAll(),HttpStatus.OK);
			}
			else
			{
			    throw new ElectricianException("No Token is present for you Sir");	
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
