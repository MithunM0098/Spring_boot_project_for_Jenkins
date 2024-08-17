package com.example.ApiCreations.ApiDemo.Model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name="user_login")
public class UserLoginApi {
	@Column(name="username")
	String username;
	@Column(name="passwords")
	
	String passwords;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	Long user_id;
	  @Column(name = "salary")
	String salary;
	  @Column(name = "mob")
	String mob;
	  @Column(name = "address")
	String address;
	
	public UserLoginApi() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserLoginApi(String username, Long userId, String salary, String mob, String address) {
		super();
		this.username = username;
		this.user_id = userId;
		this.salary = salary;
		this.mob = mob;
		this.address = address;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasswords() {
		return passwords;
	}
	public void setPasswords(String passwords) {
		this.passwords = passwords;
	}
	public Long getUserId() {
		return user_id;
	}
	public void setUserId(Long userId) {
		this.user_id = userId;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getMob() {
		return mob;
	}
	public void setMob(String mob) {
		this.mob = mob;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public int hashCode() {
		return Objects.hash(address, mob, passwords, salary, user_id, username);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserLoginApi other = (UserLoginApi) obj;
		return Objects.equals(address, other.address) && Objects.equals(mob, other.mob)
				&& Objects.equals(passwords, other.passwords) && Objects.equals(salary, other.salary)
				&& Objects.equals(user_id, other.user_id) && Objects.equals(username, other.username);
	}
	@Override
	public String toString() {
		return "UserLoginApi [username=" + username  + ", userId=" + user_id + ", salary="
				+ salary + ", mob=" + mob + ", address=" + address + "]";
	}
	
	
	
}
