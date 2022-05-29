package testClasses;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import projectClasses.CarProduction;

@RunWith(MockitoJUnitRunner.class)
class ProduktionUnderTest extends CarProduction {

	CarProduction autoProduktion = Mockito.mock(CarProduction.class);

//	Test if produceCar works and returns a value
	@Test
	public void testProducecar() {
		Mockito.when(autoProduktion.produceCar()).thenReturn(1);
		assertEquals(1, autoProduktion.produceCar());
	}

//	Verify ProduceCar is called "amount"-times when productionLine is executed
	@Test
	public void testProducecarWasCalled() throws Exception {
		Mockito.doCallRealMethod().when(autoProduktion).productionLine(2);
		autoProduktion.productionLine(2);
		Mockito.verify(autoProduktion, Mockito.times(2)).produceCar(); // Also possible: Mockito.atLeast, atLeastOnce,
	}

//	Verify that productionLine is called once
	@Test
	public void testProductionLine() throws Exception {
		Mockito.doNothing().when(autoProduktion).productionLine(Mockito.isA(Integer.class));
		autoProduktion.productionLine(2);
		Mockito.verify(autoProduktion, Mockito.times(1)).productionLine(2);
	}

	@Test
	public void testProductionLineError() throws Exception {
		Mockito.doThrow(new Exception()).when(autoProduktion).productionLine(Mockito.isA(Integer.class));
	}

}
