package com.luv2code.springdemo.mvc;

import java.util.LinkedHashMap;

public class Student {
	
	private String firstName;
	private String lastName;
	private String country;
	private String favoriteLanguage;
	private String favoriteFood;
	private String[] favoriteOperatingSystems;
	
	private LinkedHashMap<String, String> countryOptions;
	private LinkedHashMap<String, String> foodOptions;
	private LinkedHashMap<String, String> osOptions;
	
	public Student() {
		countryOptions = new LinkedHashMap<>();
		
		countryOptions.put("BR", "Brazil");
		countryOptions.put("FR", "France");
		countryOptions.put("DE", "Germany");
		countryOptions.put("IN", "India");
		
		foodOptions = new LinkedHashMap<>();
		
		foodOptions.put("MacNCheese", "MacNCheese");
		foodOptions.put("Pizza", "Pizza");
		foodOptions.put("Chicken Curry", "Chicken Curry");
		foodOptions.put("Pho", "Pho");
		
		osOptions = new LinkedHashMap<>();
		osOptions.put("MS Windows", "MS Windows");
		osOptions.put("Mac OS", "Mac OS");
		osOptions.put("Linux", "Linux");
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public LinkedHashMap<String, String> getCountryOptions() {
		return countryOptions;
	}

	public String getFavoriteLanguage() {
		return favoriteLanguage;
	}

	public void setFavoriteLanguage(String favoriteLanguage) {
		this.favoriteLanguage = favoriteLanguage;
	}
	

	public LinkedHashMap<String, String> getFoodOptions() {
		return foodOptions;
	}

	public String getFavoriteFood() {
		return favoriteFood;
	}

	public void setFavoriteFood(String favoriteFood) {
		this.favoriteFood = favoriteFood;
	}

	public String[] getFavoriteOperatingSystems() {
		return favoriteOperatingSystems;
	}

	public void setFavoriteOperatingSystems(String[] favoriteOperatingSystems) {
		this.favoriteOperatingSystems = favoriteOperatingSystems;
	}

	public LinkedHashMap<String, String> getOsOptions() {
		return osOptions;
	}

	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName + ", country=" + country
				+ ", favoriteLanguage=" + favoriteLanguage + ", favoriteFood=" + favoriteFood
				+ ", favoriteOperatingSystems=" + favoriteOperatingSystems + "]";
	}

}
