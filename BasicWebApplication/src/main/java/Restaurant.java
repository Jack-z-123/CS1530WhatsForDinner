import java.util.*;

public class Restaurant implements java.io.Serializable{
	private String name;
	//dietary preferences list
	ArrayList<String> dietTypes;
	//food type list
	ArrayList<String> foodTypes;
	//foodItemList
	ArrayList<FoodItem> menu;
	
	//location
	//hours open
	//phone number
	//reviewList
	
	/*
	 * the following methods definitely need to be completed for the project
	*/
	
	public Restaurant(String n) {
		name = n;
		dietTypes = new ArrayList<String>();
		foodTypes = new ArrayList<String>();
		menu = new ArrayList<FoodItem>();
	}
	
	public String getName() {
		return name;
	}
	
	public void addFoodItem(String name, double price) {
		FoodItem food = new FoodItem(name , price);
		menu.add(food);
	}
	
	public void editFoodItem(String name , String newName, double price) {
		FoodItem curr = this.getFoodItem(name);
		curr.setName(newName);
		curr.setPrice(price);
	}
	
	public FoodItem getFoodItem(String name) {
		for(FoodItem curr : menu) {
			if(curr.getName().equals(name))
				return curr;
		}
		return null;
	}
	
	public void deleteFoodItem(String name) {
		FoodItem temp = this.getFoodItem(name);
		menu.remove(temp);
	}
	
	public ArrayList<FoodItem> searchFoodType(String tag) {
		ArrayList<FoodItem> temp = new ArrayList<FoodItem>();
		for(FoodItem curr : menu) {
			ArrayList<String> currFoodTypes = curr.getFoodTypes();
			for(String currType : currFoodTypes) {
				if(currType.equals(tag)) {
					temp.add(curr);
					break;
				}
			}
		}
		if(temp.isEmpty())
			return null;
		return temp;
	}
	
	public ArrayList<FoodItem> searchDietType(String tag) {
		//search the restaurant for foods with this dietary restriction
		ArrayList<FoodItem> temp = new ArrayList<FoodItem>();
		for(FoodItem curr : menu) {
			ArrayList<String> currDietTypes = curr.getDietTypes();
			for(String currType : currDietTypes) {
				if(currType.equals(tag)) {
					temp.add(curr);
					break;
				}
			}
		}
		if(temp.isEmpty())
			return null;
		return temp;
	}
	
	public ArrayList<String> getDietTypes() {
		//get a list of the dietary restrictions that are fulfilled by different foods from this restaurant
		return dietTypes;
	}
	
	public ArrayList<String> getFoodTypes() {
		//get a list of the food types that are offered by this restaurant
		return foodTypes;
	}
	
	public void addDietType(String tag) {
		//add dietary restrictions to the restaurant
		this.dietTypes.add(tag);
	}
	
	public void addFoodType(String tag) {
		//add food types to the restaurant
		this.foodTypes.add(tag);
	}
	
	/*
	 *	the following methods probably won't be and don't need to be completed
	*/
	
	public void addReview() {
		//nope
	}
	
	public void deleteReview() {
		//again, nope
	}
	
	public void getLocation() {
		//get the location, I guess
	}
	
	public void setLocation() {
		//set the location
	}
	
	
}
