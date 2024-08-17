package com.example.ApiCreations.ApiDemo.Service;

import java.util.List;

import com.example.ApiCreations.ApiDemo.Model.UserFavFoodProjection;
import com.example.ApiCreations.ApiDemo.Model.UserLoginApi;
import com.example.ApiCreations.ApiDemo.Model.userfavFood;

public interface UserLoginService {

	public UserLoginApi getUserDetailsByLogin(String username,String password);
	public UserLoginApi postUserDetails(UserLoginApi userloginapi);
	public UserLoginApi getUserDetails(Long userid);
	public List<UserLoginApi> getAllUsers();
	public UserFavFoodProjection getUserFavoriteFoodById(Long id);
	public List<userfavFood> getAllFoodItems();
}
