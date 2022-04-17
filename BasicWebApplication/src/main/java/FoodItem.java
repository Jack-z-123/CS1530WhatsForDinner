import java.util.*;

public class FoodItem {
	String name;
	double price;
	//list of diets the food fulfills
	ArrayList<String> dietTypes;
	//list of food types this food falls under
	ArrayList<String> foodTypes;
	
	public FoodItem(String n , double p) {
		name = n;
		price = p;
		dietTypes = new ArrayList<String>();
		foodTypes = new ArrayList<String>();
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String n) {
		name = n;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double p) {
		price = p;
	}
	
	public ArrayList<String> getDietTypes() {
		return dietTypes;
	}
	
	public void setDietType(String diet) {
		dietTypes.add(diet);
	}
	
	public ArrayList<String> getFoodTypes() {
		return foodTypes;
	}
	
	public void setFoodType(String food) {
		foodTypes.add(food);
	}
	
	public boolean hasDietType(String tag) {
		//searches the existing diet types and then returns true or false based on if the food is assigned that diet type
		for(String currType : dietTypes) {
			if(currType.equals(tag))
				return true;
		}
		return false;
	}
	
	public boolean hasFoodType(String tag) {
		//searches the existing food types and then returns true or false based on if the food is assigned that food type
		for(String currType : foodTypes) {
			if(currType.equals(tag))
				return true;
		}
		return false;
	}
}
