package testClasses;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import projectClasses.AutoZulieferung;
import projectClasses.CarProduction;

class TestWithoutMockito {
	CarProduction carProduction = new CarProduction();
	AutoZulieferung carDelivery = new AutoZulieferung();

	@BeforeEach
	private void getParts() throws Exception {
		carDelivery.getResources();
		carProduction.deliverParts(1, carDelivery);
	}

	@Test
	public void testProducecar() throws Exception {
		assertEquals(1, carProduction.produceCar());
	}

	@Test
	public void testProducecarError() throws Exception {
		carProduction.produceCar();
		try {
			carProduction.produceCar();
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Not enough car parts.");
		}
	}

	// Test, if produceCar() was called is impossible without mockito
}
