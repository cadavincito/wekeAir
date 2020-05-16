package model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class WekeAirTest {

	private WekeAir weke;
	
	void setupScenario1() {
		weke = new WekeAir();
	}
	
	void setupScenario2() {
		
	}
	
	void setupScenario3() {
		
	}
	
	@Test
	void initializeVertexTest1() {
	 setupScenario1();
	 assertTrue(weke.getCities()!=null);
	}
	
	@Test
	void initializeEdgesTest1() {
		 setupScenario1();
		 assertTrue(weke.getMap()!=null);
	}
	
	
	@Test
	void cheapestPathTest1() {
		 setupScenario1();
	}
	
	@Test
	void cheapestPathTest2() {
	
	}
	
	@Test
	void fastestPathTest1() {
		 setupScenario1();
	}
	
	@Test
	void fastestPathTest2() {
	
	}
	

	@Test
	void getCitiesTest() {
	
	}
	
	
	@Test
	void getMapTest() {
	
	}

	

}
