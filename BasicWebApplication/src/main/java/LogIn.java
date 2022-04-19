import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LogIn
 */
@WebServlet("/LogIn")
public class LogIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogIn() {
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
		System.out.println("Pls kill me, I crave death.");
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		ArrayList<Account> allAccounts = new ArrayList<Account>();
		Account account1 = new Account("jsmith1","password","user");
		Account account2 = new Account("a","a","user");
		allAccounts.add(account1);
		allAccounts.add(account2);

		String inpUsername = request.getParameter("username");
		String inpPassword = request.getParameter("password");
		
		for(Account currAccount : allAccounts) {
			boolean check = currAccount.trySignIn(inpUsername,inpPassword);
			System.out.println(check);
			System.out.println(inpUsername);
			System.out.println(inpPassword);
			System.out.println(account1.getUsername());
			System.out.println(account1.getPassword());
			if (currAccount.trySignIn(inpUsername,inpPassword))
	        {
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
						+ "	h2{\r\n"
						+ "		color: orange;\r\n"
						+ "	}\r\n"
						+ "</style>  \r\n"
						+ "	<head>\r\n"
						+ "		<meta charset = \"UTF-8\">   \r\n"
						+ "		<title>Home Page</title>\r\n"
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
						+ "		<ul> \r\n"
						+ "		<center> \r\n"
						+ "  			<h1>What's For Dinner?</h1>\r\n"
						+ "  		</center>\r\n"
						+ "  		<center> \r\n"
						+ "  			<h2>Search your restaurants</h2>\r\n"
						+ "  		</center>\r\n"
						+ "  		<p>\r\n"
						+ "		<form method=\"post\" action=\"Filter\" id=\"filter\">          \r\n"
						+ "        		<div class=\"container\">\r\n"
						+ "        		<legend>Do you have any dietary restrictions?</legend>              		\r\n"
						+ "        		<input type=\"checkbox\" name=\"diet_type\" value=\"Vegetarian\">Vegetarian<br>      \r\n"
						+ "        		<input type=\"checkbox\" name=\"diet_type\" value=\"Vegan\">Vegan<br>      \r\n"
						+ "        		<input type=\"checkbox\" name=\"diet_type\" value=\"Kosher\">Kosher<br>\r\n"
						+ "        		<input type=\"checkbox\" name=\"diet_type\" value=\"Halal\">Halal<br>\r\n"
						+ "        		<input type=\"checkbox\" name=\"diet_type\" value=\"Pescatarian\">Pescatarian<br>\r\n"
						+ "        		<input type=\"checkbox\" name=\"diet_type\" value=\"Gluten Free\">Gluten Free<br>\r\n"
						+ "        		<input type=\"checkbox\" name=\"diet_type\" value=\"Lactose Intolerance\">Lactose Intolerance<br>\r\n"
						+ "        		<input type=\"checkbox\" name=\"diet_type\" value=\"Peanut Free\">Peanut Free<br>\r\n"
						+ "        		<legend>What kind of food are you looking for?</legend>\r\n"
						+ "        		<input type=\"checkbox\" name=\"food_type\" value=\"Burger\">Burger<br>\r\n"
						+ "        		<input type=\"checkbox\" name=\"food_type\" value=\"Pizza\">Pizza<br>\r\n"
						+ "        		<input type=\"checkbox\" name=\"food_type\" value=\"Seafood\">Seafood<br>\r\n"
						+ "        		<input type=\"checkbox\" name=\"food_type\" value=\"Steak\">Steak<br>\r\n"
						+ "        		<input type=\"checkbox\" name=\"food_type\" value=\"Chinese\">Chinese<br>\r\n"
						+ "        		<input type=\"checkbox\" name=\"food_type\" value=\"Japanese\">Japanese<br>\r\n"
						+ "        		<input type=\"checkbox\" name=\"food_type\" value=\"Korean\">Korean<br>\r\n"
						+ "        		<input type=\"checkbox\" name=\"food_type\" value=\"Thai\">Thai<br>\r\n"
						+ "        		<input type=\"checkbox\" name=\"food_type\" value=\"Indian\">Indian<br>\r\n"
						+ "        		<input type=\"checkbox\" name=\"food_type\" value=\"Mexican\">Mexican<br>\r\n"
						+ "        		<input type=\"checkbox\" name=\"food_type\" value=\"Italian\">Italian<br>\r\n"
						+ "        		<br>        		\r\n"
						+ "        		<button type=\"submit\">Search (but better)</button>\r\n"
						+ "        		</div>\r\n"
						+ "		</form>\r\n"
						+ "		</ul>  \r\n"
						+ "	</body>");
				return;
	        }
		}
		pw.println("<head>\r\n"
				+ "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n"
				+ "<title> Login Page </title>\r\n"
				+ "<style> \r\n"
				+ "Body {\r\n"
				+ "  font-family: Calibri, Helvetica, sans-serif;\r\n"
				+ "  background-color: #cef5ae;\r\n"
				+ "}\r\n"
				+ "button { \r\n"
				+ "       background-color: #cef5ae; \r\n"
				+ "       width: 100%;\r\n"
				+ "        color: orange; \r\n"
				+ "        padding: 15px; \r\n"
				+ "        margin: 10px 0px; \r\n"
				+ "        border: 2px solid green; \r\n"
				+ "        cursor: pointer; \r\n"
				+ "         } \r\n"
				+ " form { \r\n"
				+ "        border: 3px solid #f1f1f1; \r\n"
				+ "    } \r\n"
				+ " input[type=text], input[type=password] { \r\n"
				+ "        width: 100%; \r\n"
				+ "        margin: 8px 0;\r\n"
				+ "        padding: 12px 20px; \r\n"
				+ "        display: inline-block; \r\n"
				+ "        border: 2px solid #f1f1f1;; \r\n"
				+ "        box-sizing: border-box; \r\n"
				+ "    }\r\n"
				+ " button:hover { \r\n"
				+ "        opacity: 0.7; \r\n"
				+ "    } \r\n"
				+ "  .cancelbtn { \r\n"
				+ "        width: auto; \r\n"
				+ "        padding: 10px 18px;\r\n"
				+ "        margin: 10px 5px;\r\n"
				+ "    } \r\n"
				+ "      \r\n"
				+ "   \r\n"
				+ " .container { \r\n"
				+ "        padding: 25px; \r\n"
				+ "        background-color:  #ffc085;\r\n"
				+ "    } \r\n"
				+ "    .alert {\r\n"
				+ "  padding: 20px;\r\n"
				+ "  background-color: #f44336;\r\n"
				+ "  color: white;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ ".closebtn {\r\n"
				+ "  margin-left: 15px;\r\n"
				+ "  color: white;\r\n"
				+ "  font-weight: bold;\r\n"
				+ "  float: right;\r\n"
				+ "  font-size: 22px;\r\n"
				+ "  line-height: 20px;\r\n"
				+ "  cursor: pointer;\r\n"
				+ "  transition: 0.3s;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ ".closebtn:hover {\r\n"
				+ "  color: black;\r\n"
				+ "}\r\n"
				+ "</style>\r\n"
				+ "<link rel=\"stylesheet\" href=\"style.css\">\r\n"
				+ "</head>  \r\n"
				+ "<body>\r\n"
				+ "	<nav class = \"navbar\">\r\n"
				+ "    	<a class=\"navbar__link\" href=\"index.html\">Home</a>\r\n"
				+ "    	<!-- <a class=\"navbar__link\" href=\"search.html\">Search</a> -->\r\n"
				+ "    	<a class=\"navbar__link\" href=\"logIn.html\">Login</a>\r\n"
				+ "    	<a class=\"navbar__link\" href=\"signUp.html\">Sign Up</a>\r\n"
				+ "    	<a class=\"navbar__link\" href=\"account.html\">Account</a>\r\n"
				+ "    </nav>\r\n"
				+ "    <center> <h1> Log In </h1> </center> \r\n"
				+ "    <form method=\"post\" action=\"LogIn\">\r\n"
				+ "        <div class=\"container\"> \r\n"
				+ "            <label>Username : </label> \r\n"
				+ "            <input type=\"text\" placeholder=\"Enter Username\" name=\"username\" required>\r\n"
				+ "            <label>Password : </label> \r\n"
				+ "            <input type=\"password\" placeholder=\"Enter Password\" name=\"password\" required>\r\n"
				+ "            <button type=\"submit\">Login</button> \r\n"
				+ "            <button type=\"button\" class=\"cancelbtn\"> <a href=\"index.html\">Cancel</a></button> \r\n"
				+ "            New to What's For Dinner? <a href=\"signUp.html\"> Sign Up! </a> \r\n"
				+ "        </div> \r\n"
				+ "    </form>\r\n"
				+ "    <div class=\"alert\">\r\n"
				+ "  		<span class=\"closebtn\" onclick=\"this.parentElement.style.display='none';\">&times;</span> \r\n"
				+ "  		<strong>Warning!</strong> Username and/or password is incorrect.\r\n"
				+ "	</div>   \r\n"
				+ "</body>");

	}
}