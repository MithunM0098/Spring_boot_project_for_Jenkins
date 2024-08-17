package com.example.ApiCreations.ApiDemo.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.ApiCreations.ApiDemo.Model.UserFavFoodProjection;
import com.example.ApiCreations.ApiDemo.Model.UserLoginApi;
import com.example.ApiCreations.ApiDemo.Model.userfavFood;

public class UserLoginResponse {
	
	public static ResponseEntity<Object> loginrespoonseEntity(String  message,Object response,String http){
		Map<String,Object> params=new HashMap<>();
		params.put("message", message);
		params.put("user_details", response);
		params.put("Status", http);
		
		return new ResponseEntity<>(params,HttpStatus.OK);
	}
	
	public static ResponseEntity<Object> AllUserrespoonseEntity(String  message,List<UserLoginApi> userLoginApi,String http){
		Map<String,Object> params=new HashMap<>();
		params.put("message", message);
		params.put("user_details", userLoginApi);
		params.put("Status", http);
		
		return new ResponseEntity<>(params,HttpStatus.OK);
	}
	
	public static ResponseEntity<Object> AllUserfavfoodrespoonseEntity(String  message,UserFavFoodProjection userLoginApi,String http){
		Map<String,Object> params=new HashMap<>();
		params.put("message", message);
		params.put("user_details", userLoginApi);
		params.put("Status", http);
		
		return new ResponseEntity<>(params,HttpStatus.OK);
	}
	
	public static ResponseEntity<Object> AllFavfoodrespoonseEntity(String  message,List<userfavFood> userLoginApi,String http){
		Map<String,Object> params=new HashMap<>();
		params.put("message", message);
		params.put("user_details", userLoginApi);
		params.put("Status", http);
		
		return new ResponseEntity<>(params,HttpStatus.OK);
	}
}
