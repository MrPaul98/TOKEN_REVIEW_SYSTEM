package com.TokenReviewSystem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.TokenReviewSystem.error.UserException;
import com.TokenReviewSystem.model.UserData;
import com.TokenReviewSystem.model.UserloginData;
import com.TokenReviewSystem.repository.UserDataRepository;
import com.TokenReviewSystem.repository.UserRepository;

@Service
public class UserServices {
	
	@Autowired
	UserDataRepository userdatarepository;
	@Autowired
	UserRepository userrepository;
	
	public ResponseEntity<UserloginData> signinuser(UserloginData userlog){
		Optional<UserloginData> data = userrepository.findByEmailId(userlog.getEmailId());
		try {
		if(!data.isPresent()) {
			
			userdatarepository.save(userlog.getUserdata());
			return new ResponseEntity<UserloginData>(userrepository.save(userlog),HttpStatus.OK);
		}
		else {
			throw new UserException("User "+userlog.getUserdata()
			.getFirstname()+" "+userlog.getUserdata().getLastname()+" already present");
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
				throw new UserException("Please check the data entered or please create an account"); 
			}
		} catch (Exception e) {
			
			return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}





	public ResponseEntity<UserData> Updateuserdata(String emailid, String firstname,
			String mname, String lname,String city, int pincode,
			String phonenumber, String state) {
		int ID  = userrepository.findidandupdate(emailid);
		Optional<UserData> updatedata = userdatarepository.findById(ID);
	    try {
		if (updatedata.isPresent()) {
			userdatarepository.UpdateUserdata(ID, city, firstname, lname, mname, phonenumber, pincode, state);
			return new ResponseEntity("YOUR DATA IS UPDATED SIR",HttpStatus.OK);
	    }
	    else {
	    	throw new UserException("Update not possible User not present");
	    }
	   }catch (Exception e) {
			// TODO: handle exception
	    	return new ResponseEntity(e.getMessage() ,HttpStatus.NOT_FOUND);
		}
	}


	public ResponseEntity forgetpassword(String email, String prevpassword, String newpassword) {
		Optional<UserloginData> getdata = userrepository.findAllByEmailIdAndPassword(email, prevpassword);
		try {
			if(getdata.isPresent()) {
				userrepository.updatepassword(email,prevpassword,newpassword);
				return new ResponseEntity("NEW PASSWORD UPDATED SIR",HttpStatus.OK);
			}
			else {
				throw new UserException("ENTERED EMAILID OR PREVPASSWORD IS WROMG PLEASE ENTER THE CORRECT DATA");
			}
		} catch (Exception e) {
                
			return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	} 
	
	
	//no need for reference
//	public Optional<UserData> UpdateData(String email) {
//		List<UserloginData> data = userrepository.findalldatafromemail(email);
//		int ID = userrepository.findidandupdate(email);
//		return userdatarepository.findById(ID);
////		for (UserloginData userloginData : data) {
////			return (List<UserData>) (userloginData.getClass(UserData.class));
////		}
//	
//	}
}
