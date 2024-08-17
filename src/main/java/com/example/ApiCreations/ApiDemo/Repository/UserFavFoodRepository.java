package com.example.ApiCreations.ApiDemo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ApiCreations.ApiDemo.Model.userfavFood;

@Repository
public interface UserFavFoodRepository extends JpaRepository<userfavFood, Long> {

}
