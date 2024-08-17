package com.example.ApiCreations.ApiDemo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ApiCreations.ApiDemo.Exception.UserFavFoodNotFound;
import com.example.ApiCreations.ApiDemo.Exception.UserLoginNotFoundException;
import com.example.ApiCreations.ApiDemo.Model.UserFavFoodProjection;
import com.example.ApiCreations.ApiDemo.Model.UserLoginApi;
import com.example.ApiCreations.ApiDemo.Model.userfavFood;
import com.example.ApiCreations.ApiDemo.Repository.UserFavFoodRepository;
import com.example.ApiCreations.ApiDemo.Repository.UserLoginApiRepository;


@Service
public class UserLoginServiceImpl implements UserLoginService {
	
	@Autowired
	UserLoginApiRepository userLoginApiRepository;
	
	@Autowired
	UserFavFoodRepository userFavFoodRepository;
	
	public UserLoginServiceImpl(UserLoginApiRepository userLoginApiRepository) {
		super();
		this.userLoginApiRepository = userLoginApiRepository;
	}

	@Override
	public UserLoginApi getUserDetailsByLogin(String username, String password) {
	
		if(username.isEmpty()) {
			throw new UserLoginNotFoundException("username is empty!");
		}
		if(password.isEmpty()) {
			throw new UserLoginNotFoundException("password is empty!");
		}
		UserLoginApi user = userLoginApiRepository.Login(username, password);

	    if (user == null) {
	        throw new UserLoginNotFoundException("Incorrect username or password!");
	    }
		return user;
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserLoginApi postUserDetails(UserLoginApi userloginapi) {
		// TODO Auto-generated method stub
		if(userloginapi.getUsername().isEmpty() || userloginapi.getUsername().equals(null)) {
			throw new UserLoginNotFoundException("username is empty!");
		}
		UserLoginApi user = userLoginApiRepository.save(userloginapi);
		 if (user == null) {
		        throw new UserLoginNotFoundException("User Details cannot be empty!!!");
		    }
			return user;
		 
	}

	@Override
	public UserLoginApi getUserDetails(Long userid) {
	    return userLoginApiRepository.findById(userid)
	            .orElseThrow(() -> new UserLoginNotFoundException("No details found for this ID"));
	}

	@Override
	public List<UserLoginApi> getAllUsers() {
	    List<UserLoginApi> users = userLoginApiRepository.findAll();
	    
	    if (users.isEmpty()) {
	        throw new UserLoginNotFoundException("No User Details Found!!");
	    }
	    
	    return users;
	}

	@Override
	public UserFavFoodProjection getUserFavoriteFoodById(Long id) {
	 UserFavFoodProjection favoriteFoods = userLoginApiRepository.getUserFavFoodByUserId(id);
	    if (favoriteFoods==null) {
	        throw new UserFavFoodNotFound("No Fav Food found for this user id !!!");
	    }
	    // Assuming you want to return the first entry or handle it in some other way.
	    return favoriteFoods; // or process the list as needed
	}

	@Override
	public List<userfavFood> getAllFoodItems() {
		// TODO Auto-generated method stub
		List<userfavFood> favfood=userFavFoodRepository.findAll();
		if(favfood.isEmpty()) {
			throw new UserFavFoodNotFound("No fav foods of user found!!!");
		}
		return favfood;
	}



	
	

}
