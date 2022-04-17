

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public TestServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

@WebServlet("/Filter")
public class Filter extends HttpServlet{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		ArrayList<Restaurant> allRestaurants = new ArrayList<Restaurant>();
		Restaurant arbys = new Restaurant("Arbys");
		Restaurant fiveGuys = new Restaurant("Five Guys");
		Restaurant chicknBubbly = new Restaurant("Chickn Bubbly");
		
		arbys.addFoodItem("Roast Beef Sandwich", 4.99);
		arbys.getFoodItem("Roast Beef Sandwich").setDietType("Peanut Free");
		arbys.addDietType("Peanut Free");
		fiveGuys.addFoodItem("Hamburger", 11.15);
		fiveGuys.getFoodItem("Hamburger").setFoodType("Burger");
		fiveGuys.addFoodType("Burger");
		fiveGuys.addFoodItem("Cheese Burger", 12.23);
		fiveGuys.getFoodItem("Cheese Burger").setFoodType("Burger");
		fiveGuys.addFoodItem("Bacon Burger", 13.55);
		fiveGuys.getFoodItem("Bacon Burger").setFoodType("Burger");
		fiveGuys.addFoodItem("Little Hamburger", 8.27);
		fiveGuys.getFoodItem("Little Hamburger").setFoodType("Burger");
		fiveGuys.addFoodItem("Little Cheese Burger", 9.35);
		fiveGuys.getFoodItem("Little Cheese Burger").setFoodType("Burger");
		fiveGuys.addFoodItem("Regular Fries", 6.35);
		fiveGuys.getFoodItem("Regular Fries").setDietType("Vegetarian");
		fiveGuys.getFoodItem("Regular Fries").setDietType("Vegan");
		fiveGuys.addDietType("Vegan");
		fiveGuys.addDietType("Vegetarian");
		fiveGuys.addFoodItem("Grilled Cheese Sandwich", 7.19);
		fiveGuys.getFoodItem("Grilled Cheese Sandwich").setDietType("Vegetarian");
		chicknBubbly.addFoodItem("Korean Style Fried Chicken", 15.60);
		chicknBubbly.addFoodType("Korean");
		chicknBubbly.addFoodItem("Calamari Tempura", 8.50);
		chicknBubbly.addFoodType("Seafood");
		
		allRestaurants.add(arbys);
		allRestaurants.add(fiveGuys);
		allRestaurants.add(chicknBubbly);
		
		String[] dietType = request.getParameterValues("diet_type");
		ArrayList<Restaurant> dietRestaurants = new ArrayList<Restaurant>();
		if(dietType != null) {
			//Check specified diet type against all restaurants. Throw out non-matches
			boolean check = false;
			for(Restaurant currRest : allRestaurants) {
				//Checks for diet will need at least 1 satisfaction
				//If the restaurant is labeled to offer 1 type of diet selection, then it will be added to the list of valid restaurants
				for(String currDietType : currRest.getDietTypes()) {
					for(String desiredDiet : dietType) {
						if(desiredDiet.equals(currDietType)) {
							dietRestaurants.add(currRest);
							check = true;
							break;
						}
					}
					if(check) {
						check = false;
						break;
					}
				}
			}
		}else{
			//Added in the case of no diet types being selected
			for(Restaurant currRest : allRestaurants) {
				dietRestaurants.add(currRest);
			}
		}
		
		String foodType[] = request.getParameterValues("foodtype_type");
		ArrayList<Restaurant> foodRestaurants = new ArrayList<Restaurant>();
		if(foodType != null) {
			//Check specified food type against all remaining restaurants. Throw out non-matches
			for(Restaurant currRest : dietRestaurants) {
				//Checks for food will need at least 1 satisfaction
				boolean check = false;
				//If the restaurant is labeled to offer 1 type of food selection, then it will be added to the list of valid restaurants
				for(String currDietType : currRest.getDietTypes()) {
					for(String desiredDiet : dietType) {
						if(desiredDiet.equals(currDietType)) {
							dietRestaurants.add(currRest);
							check = true;
							break;
						}
					}
					if(check) {
						check = false;
						break;
					}
				}
			}
		}else{
			//Added in the case of no food types being selected
			for(Restaurant currRest : dietRestaurants) {
				foodRestaurants.add(currRest);
			}
		}
		
		//Display the left-over restaurants as search results
		//Not sure if this would print new HTML to the current page or if a new page would be made to show results
	}
}