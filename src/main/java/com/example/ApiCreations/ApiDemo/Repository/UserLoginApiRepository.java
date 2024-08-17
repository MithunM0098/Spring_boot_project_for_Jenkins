package com.example.ApiCreations.ApiDemo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.JpaRepositoryConfigExtension;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.ApiCreations.ApiDemo.Model.UserFavFoodProjection;
import com.example.ApiCreations.ApiDemo.Model.UserLoginApi;
import com.example.ApiCreations.ApiDemo.Model.userfavFood;

@Repository
public interface UserLoginApiRepository extends JpaRepository<UserLoginApi, Long> {

	@Query(value = "SELECT user_id, username, salary, mob, address,passwords FROM user_login WHERE username = :username AND passwords = :password ", nativeQuery = true)
	UserLoginApi Login(String username, String password);
	
	@Query(value = "SELECT u.user_id AS userID, u.username AS UserName, f.food_name AS FoodName, f.food_price AS FoodPrice FROM user_login u INNER JOIN food_items f ON u.user_id = f.user_id WHERE u.user_id = :userId", nativeQuery = true)
	UserFavFoodProjection getUserFavFoodByUserId(@Param("userId") Long userId);

}
