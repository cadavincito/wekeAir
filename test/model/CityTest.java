package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CityTest {

	private City c;
	
	void setupScenario1() {
		c = new City("Bogota");
	}
	@Test
	void test() {
		int a = c.hashCode();
		System.out.println(a);
	}

}
