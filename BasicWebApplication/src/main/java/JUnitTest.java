import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JUnitTest {
	
	Restaurant r;
	FoodItem f1;
	FoodItem f2;
	Account a;
	
	
	@BeforeEach
	void setUp() throws Exception {
		r = new Restaurant("Test");
		
		f1 = new FoodItem("burger", 1.0);
		
		f2 = new FoodItem("noodle", 1.5);
		
		a = new Account("John", "123", "Admin");
		
	}

	@AfterEach
	void tearDown() throws Exception {
		r = null;
		f1 = null;
		f2 = null;
		a = null;
	}
	
	@Test
	public void testAccountGetUsername() {
		assertEquals("John", a.getUsername());
	}
	
	@Test
	public void testAccountGetPassword() {
		assertEquals("123", a.getPassword());
	}
	
	@Test
	public void testAccountGetAccountType() {
		assertEquals("Admin", a.getAccountType());
	}
	
	@Test
	public void testAccountTrySignIn() {
		assertTrue(a.trySignIn("John", "123"));
		assertFalse(a.trySignIn("John", "1234"));
	}
	
	@Test
	public void testFoodItemSetDietType() {
		f1.setDietType("Vegan");
		f1.setDietType("Peanut free");
		assertEquals(2, f1.dietTypes.size());
	}
	
	@Test
	public void testFoodItemHasDietType() {
		f1.setDietType("Vegan");
		f1.setDietType("Peanut free");
		assertTrue(f1.hasDietType("Vegan"));
		assertTrue(f1.hasDietType("Peanut free"));
		assertFalse(f1.hasDietType("Keto"));
		assertFalse(f1.hasDietType("Gluten free"));
	}
	
	@Test
	public void testFoodItemSetFoodType() {
		f1.setFoodType("Italian");
		f1.setFoodType("American");
		assertEquals(2, f1.getFoodTypes().size());
	}
	
	@Test
	public void testFoodItemHasFoodType() {
		f1.setFoodType("Italian");
		f1.setFoodType("American");
		assertTrue(f1.hasFoodType("Italian"));
		assertTrue(f1.hasFoodType("American"));
		assertFalse(f1.hasFoodType("Japanese"));
		assertFalse(f1.hasFoodType("Korean"));
	}
	
	@Test
	public void testGetNullFoodItem() {
		assertNull(r.getFoodItem("burger"));
	}
	
	@Test
	public void testGetFoodItem1() {
		r.addFoodItem(f1.getName(), f1.getPrice());
		r.addFoodItem(f2.getName(), f2.getPrice());
		assertEquals("burger", r.getFoodItem("burger").getName());
	}
	
	@Test
	public void testEditFoodItem2() {
		r.addFoodItem(f1.getName(), f1.getPrice());
		r.addFoodItem(f2.getName(), f2.getPrice());
		r.editFoodItem(f2.getName(), "soup", 2.0);
		assertEquals("soup", r.getMenu().get(1).getName());
	}
	
	@Test
	public void testDeleteFoodItem2() {
		r.addFoodItem(f1.getName(), f1.getPrice());
		r.addFoodItem(f2.getName(), f2.getPrice());
		r.deleteFoodItem(f2.getName());
		assertNull(r.getFoodItem(f2.getName()));
	}
	
	@Test
	public void testAddDietType() {
		r.addDietType("Peanut Free");
		r.addDietType("Vegan");
		assertEquals("Peanut Free", r.getDietTypes().get(0));
		assertEquals("Vegan", r.getDietTypes().get(1));
	}
	
	
	@Test
	public void testAddFoodType() {
		r.addFoodType("Korean");
		r.addFoodType("Japanese");
		assertEquals("Korean", r.getFoodTypes().get(0));
		assertEquals("Japanese", r.getFoodTypes().get(1));
	}
	
	


}
