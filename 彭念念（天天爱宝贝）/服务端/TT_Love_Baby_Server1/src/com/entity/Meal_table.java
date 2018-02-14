package com.entity;

public class Meal_table {
	private int Meal_id;
	private int Meal_type;
	private String Mealcontent;
	private int Meal_image_id;
	public int getMeal_id() {
		return Meal_id;
	}
	public void setMeal_id(int mealId) {
		Meal_id = mealId;
	}
	public int getMeal_type() {
		return Meal_type;
	}
	public void setMeal_type(int mealType) {
		Meal_type = mealType;
	}
	public String getMealcontent() {
		return Mealcontent;
	}
	public void setMealcontent(String mealcontent) {
		Mealcontent = mealcontent;
	}
	public int getMeal_image_id() {
		return Meal_image_id;
	}
	public void setMeal_image_id(int mealImageId) {
		Meal_image_id = mealImageId;
	}
	@Override
	public String toString() {
		return "Meal_table [Meal_id=" + Meal_id + ", Meal_image_id="
				+ Meal_image_id + ", Meal_type=" + Meal_type + ", Mealcontent="
				+ Mealcontent + "]";
	}
	
	
}
