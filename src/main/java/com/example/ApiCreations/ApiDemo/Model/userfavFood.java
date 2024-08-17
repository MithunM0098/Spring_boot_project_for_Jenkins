package com.example.ApiCreations.ApiDemo.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "food_items")
public class userfavFood {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "food_id")  // Ensure this matches the column name in your database
    private Long foodId;
    
    @Column(name = "food_name")
    private String foodName;
    
    @Column(name = "food_price")
    private Double foodPrice;
    
    @Column(name = "user_id")
    private Long userId;

    // Default constructor (required by Hibernate)
    public userfavFood() {
    }

    // Parameterized constructor
    public userfavFood(String foodName, Double foodPrice, Long userId) {
        this.foodName = foodName;
        this.foodPrice = foodPrice;
        this.userId = userId;
    }

	public Long getFoodId() {
		return foodId;
	}

	public void setFoodId(Long foodId) {
		this.foodId = foodId;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public Double getFoodPrice() {
		return foodPrice;
	}

	public void setFoodPrice(Double foodPrice) {
		this.foodPrice = foodPrice;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

    // Getters and Setters

   
}
