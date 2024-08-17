package com.example.ApiCreations.ApiDemo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ApiCreations.ApiDemo.Exception.IncorrectCredentialsException;
import com.example.ApiCreations.ApiDemo.Exception.UserFavFoodNotFound;
import com.example.ApiCreations.ApiDemo.Exception.UserLoginNotFoundException;
import com.example.ApiCreations.ApiDemo.Model.UserFavFoodProjection;
import com.example.ApiCreations.ApiDemo.Model.UserLoginApi;
import com.example.ApiCreations.ApiDemo.Model.userfavFood;
import com.example.ApiCreations.ApiDemo.Response.ApiResponse;
import com.example.ApiCreations.ApiDemo.Response.UserLoginResponse;
import com.example.ApiCreations.ApiDemo.Service.UserLoginService;

@RestController
@RequestMapping("/UserLoginApi")
public class UserLoginController {
	
	UserLoginService userLoginService;
	@Autowired
	public UserLoginController(UserLoginService userLoginService) {
		super();
		this.userLoginService = userLoginService;
	}
	
	/*
	 * @PostMapping("/login") public UserLoginApi userLogin(
	 * 
	 * @RequestParam("username") String username,
	 * 
	 * @RequestParam("password") String password) { return
	 * userLoginService.getUserDetailsByLogin(username, password); }
	 */
	
	@GetMapping("/login")
	public ResponseEntity<Object> userLogin(@RequestParam("username") String username, @RequestParam("password") String password) {
	    try {
	        UserLoginApi userDetails = userLoginService.getUserDetailsByLogin(username, password);
	        return UserLoginResponse.loginrespoonseEntity("Success", userDetails, "Yes");
	    } catch (IncorrectCredentialsException | UserLoginNotFoundException e) {
	    	//ApiResponse apirepsone=new ApiResponse("Incorrect username or password");
	        return UserLoginResponse.loginrespoonseEntity("Incorrect username or password","", "no");
	    }
	}
	
	@PostMapping(value = "/createuser", consumes = "application/json")
	public ResponseEntity<Object> postingLoginDetails(@RequestBody UserLoginApi api) {
	    try {
	        userLoginService.postUserDetails(api);
	        String str=new String();
	        str="PostedSuccessfully";
	        return UserLoginResponse.loginrespoonseEntity("Success", str, "Yes");
	    } catch (Exception e) {
	        return UserLoginResponse.loginrespoonseEntity("failed", "", "no");
	    }
	}

	@GetMapping("/getUserById")
	public ResponseEntity<Object> getUserDetailsById(@RequestParam("user_id") Long userid) {
	    try {
	        UserLoginApi userDetails = userLoginService.getUserDetails(userid);
	        return UserLoginResponse.loginrespoonseEntity("Success", userDetails, "Yes");
	    } catch (UserLoginNotFoundException e) {
	    	String str=new String(e.getMessage());
	        return UserLoginResponse.loginrespoonseEntity("Failed", str, "No");
	    } catch (IncorrectCredentialsException e) {
	    	String str=new String(e.getMessage());
	        return UserLoginResponse.loginrespoonseEntity("Unauthorized", str, "No");
	    }
	}

	@GetMapping()
	public ResponseEntity<Object> getAllUserDetails(){
		try {
			List<UserLoginApi> userLoginApi=userLoginService.getAllUsers();
			return UserLoginResponse.AllUserrespoonseEntity("Success", userLoginApi, "Yes");
			} catch (UserLoginNotFoundException e) {
	    	String str=new String(e.getMessage());
	        return UserLoginResponse.loginrespoonseEntity("Failed", str, "No");
	    } catch (IncorrectCredentialsException e) {
	    	String str=new String(e.getMessage());
	        return UserLoginResponse.loginrespoonseEntity("Unauthorized", str, "No");
	    }
	}
	
	@GetMapping("/getMyUserFavFood")
	public ResponseEntity<Object> getMyUserFavFood(@RequestParam Long user_id){
		try {
			UserFavFoodProjection user=userLoginService.getUserFavoriteFoodById(user_id);
			return UserLoginResponse.AllUserfavfoodrespoonseEntity("Success", user, "Yes");
		}catch(UserFavFoodNotFound e) {
			String str=new String(e.getMessage());
			return UserLoginResponse.loginrespoonseEntity("Failed", str, "No");
		}
	}
	
	@GetMapping("/getAllFavFoodDetails")
	public ResponseEntity<Object> getAllFavFoodDetails(){
		try {
			List<userfavFood> userfavFood=userLoginService.getAllFoodItems();
			return UserLoginResponse.AllFavfoodrespoonseEntity("Success", userfavFood, "Yes");
			} catch (UserFavFoodNotFound e) {
	    	String str=new String(e.getMessage());
	        return UserLoginResponse.loginrespoonseEntity("Failed", str, "No");
	    } catch (IncorrectCredentialsException e) {
	    	String str=new String(e.getMessage());
	        return UserLoginResponse.loginrespoonseEntity("Unauthorized", str, "No");
	    }
	}

}
