import java.io.*;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Filter
 */
@WebServlet("/Filter")
public class Filter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Filter() {
        super();
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
		//doGet(request, response);
		response.setContentType("text/html");
		
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
		fiveGuys.addDietType("Vegetarian");
		fiveGuys.addDietType("Vegan");
		fiveGuys.addFoodItem("Grilled Cheese Sandwich", 7.19);
		fiveGuys.getFoodItem("Grilled Cheese Sandwich").setDietType("Vegetarian");
		
		chicknBubbly.addFoodItem("Korean Style Fried Chicken", 15.60);
		chicknBubbly.getFoodItem("Korean Style Fried Chicken").setDietType("Peanut Free");
		chicknBubbly.getFoodItem("Korean Style Fried Chicken").setFoodType("Korean");
		chicknBubbly.addDietType("Peanut Free");
		chicknBubbly.addFoodType("Korean");
		chicknBubbly.addFoodItem("Calamari Tempura", 8.50);
		chicknBubbly.getFoodItem("Calamari Tempura").setDietType("Peanut Free");
		chicknBubbly.getFoodItem("Calamari Tempura").setFoodType("Seafood");
		chicknBubbly.addDietType("Peanut Free");
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
						if(currDietType.equals(desiredDiet)) {
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
		
		String foodType[] = request.getParameterValues("food_type");
		ArrayList<Restaurant> foodRestaurants = new ArrayList<Restaurant>();
		if(foodType != null) {
			//Check specified food type against all remaining restaurants. Throw out non-matches
			for(Restaurant currRest : dietRestaurants/*dietRestaurants*/) {
				//Checks for food will need at least 1 satisfaction
				boolean check = false;
				//If the restaurant is labeled to offer 1 type of food selection, then it will be added to the list of valid restaurants
				for(String currFoodType : currRest.getFoodTypes()) {
					for(String desiredFood : foodType) {
						if(currFoodType.equals(desiredFood)) {
							foodRestaurants.add(currRest);
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
			for(Restaurant currRest : dietRestaurants/*dietRestaurants*/) {
				foodRestaurants.add(currRest);
			}
		}
		
		//Display the left-over restaurants as search results
		//Not sure if this would print new HTML to the current page or if a new page would be made to show results
		//response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.println("<style>\r\n"
				+ "	input[type=text], input[type=password] { \r\n"
				+ "        width: 96%; \r\n"
				+ "        padding: 30px 30px; \r\n"
				+ "        display: inline-block; \r\n"
				+ "        border: 2px solid #f1f1f1;; \r\n"
				+ "        box-sizing: border-box; \r\n"
				+ "    }\r\n"
				+ "    button {\r\n"
				+ "  		background-color: #cef5ae; \r\n"
				+ "       	width: 100%;\r\n"
				+ "        color: orange; \r\n"
				+ "        padding: 15px; \r\n"
				+ "        margin: 10px 0px; \r\n"
				+ "        border: 2px solid green; \r\n"
				+ "        cursor: pointer; \r\n"
				+ "	}\r\n"
				+ "	button:hover {\r\n"
				+ "  		opacity: 0.7;\r\n"
				+ "	}\r\n"
				+ "	.container{\r\n"
				+ "		padding: 25px;\r\n"
				+ "		background-color: #ffc085;\r\n"
				+ "		width: 96%;\r\n"
				+ "	}\r\n"
				+ "</style>  \r\n"
				+ "	<head>\r\n"
				+ "		<meta charset = \"UTF-8\">   \r\n"
				+ "		<title>Search Results</title>\r\n"
				+ "		<link rel=\"stylesheet\" href=\"style.css\">\r\n"
				+ "	</head>  \r\n"
				+ "	<body>\r\n"
				+ "		<nav class = \"navbar\">\r\n"
				+ "    		<a class=\"navbar__link\" href=\"index.html\">Home</a>\r\n"
				+ "    		<!-- <a class=\"navbar__link\" href=\"search.html\">Search</a> -->\r\n"
				+ "    		<a class=\"navbar__link\" href=\"logIn.html\">Login</a>\r\n"
				+ "    		<a class=\"navbar__link\" href=\"signUp.html\">Sign Up</a>\r\n"
				+ "    		<a class=\"navbar__link\" href=\"account.html\">Account</a>\r\n"
				+ "    	</nav>\r\n"
				+ "    	 \r\n"
				+ "		<ul> \r\n"
				+ "		<center> \r\n"
				+ "  			<h1>What's For Dinner?</h1>\r\n"
				+ "  		</center>");
		if(!foodRestaurants.isEmpty()) {
			for(Restaurant currRestFiltered : foodRestaurants) {
				pw.println("<div class=container>");
				//show name of restaurant
				pw.println("<h1>" + currRestFiltered.getName() + "</h1>");
				//Display applicable food items and their assigned tags
				for(FoodItem x : currRestFiltered.getMenu()) {
					pw.println("<h2>" + x.getName() + "</h2>");
					if(x.getDietTypes().size() != 0) {
						pw.println("<p>Diet type(s): ");
						for(String d : x.getDietTypes()) {
							pw.println(d);
						}
						pw.println("</p>");
					}
					if(x.getFoodTypes().size() != 0) {
						pw.println("<p>Food type(s): ");
						for(String f : x.getFoodTypes()) {
							pw.println(f);
						}
						pw.println("</p>");
					}
				}
				pw.println("</div>");
				pw.println("<p></p>");
			}
		}else {
			pw.println("<h2>No results</h2>");
		}
	}

}
