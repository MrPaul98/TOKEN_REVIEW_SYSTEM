package com.TokenReviewSystem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.TokenReviewSystem.model.UserloginData;
import com.TokenReviewSystem.repository.UserDataRepository;
import com.TokenReviewSystem.repository.UserRepository;

@Service
public class RepositoryUserServices {
	
	@Autowired
	UserDataRepository userdatarepository;
	@Autowired
	UserRepository userrepository;
	
	public ResponseEntity<UserloginData> reguser(UserloginData userlog){
		Optional<UserloginData> data = userrepository.findByEmailId(userlog.getEmailId());
		try {
		if(!data.isPresent()) {
			
			userdatarepository.save(userlog.getUserdata());
			return new ResponseEntity<UserloginData>(userrepository.save(userlog),HttpStatus.OK);
		}
		else {
			throw new Exception("Product "+userlog.getEmailId()+" already present");
		}
		}
		catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	
	public ResponseEntity<List<UserloginData>> getAlluaerdata() {

		if(userrepository.findAll().size() > 0) {
		return new ResponseEntity<List<UserloginData>>(userrepository.findAll(),HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<List<UserloginData>>(HttpStatus.NOT_FOUND);
		}
	}

    public ResponseEntity<UserloginData> login(String emailID, String password, String customertype) {
    	
	      Optional<UserloginData> auth = userrepository.findAllByEmailIdAndPasswordAndUsertype(emailID,password,customertype);
	      try {
			if(auth.isPresent()) {
				return new ResponseEntity<UserloginData>(auth.get(),HttpStatus.OK);
			}
			else {
				throw new Exception("Please check the data entered or please create an account"); 
			}
		} catch (Exception e) {
			
			return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	} 

}
