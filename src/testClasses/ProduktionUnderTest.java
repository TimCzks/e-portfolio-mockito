package testClasses;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import projectClasses.AutoZulieferung;
import projectClasses.CarProduction;

@RunWith(MockitoJUnitRunner.class)
class ProduktionUnderTest extends CarProduction {

	CarProduction autoProduktion = Mockito.mock(CarProduction.class);
	AutoZulieferung autoZulieferung = Mockito.mock(AutoZulieferung.class);

//	Test if produceCar works and returns a value
	@Test
	public void testProducecar() throws Exception {
		Mockito.when(autoProduktion.produceCar()).thenReturn(1);
		assertEquals(1, autoProduktion.produceCar());
	}

//	Test if productionLine works
	@Test
	public void testProductionLineWorks() throws Exception {
		Mockito.doAnswer(invocation -> {
			Object param0 = invocation.getArgumentAt(0, Integer.class);
			Object param1 = invocation.getArgumentAt(1, AutoZulieferung.class);

			assertEquals(1, param0); // Define the expected value for the method call later on
			assertEquals(autoZulieferung, param1);
			return null;
		}).when(autoProduktion).productionLine(Mockito.isA(Integer.class), Mockito.isA(AutoZulieferung.class));
		autoProduktion.productionLine(1, autoZulieferung);
	}

	@Test
	public void testVerifyProductionLine() throws Exception {
		Mockito.when(autoZulieferung.produceParts(16, 10, 8, 2))
				.thenReturn(new ArrayList<Integer>(Arrays.asList(16, 10, 8, 2)));
		Mockito.doCallRealMethod().when(autoProduktion).productionLine(Mockito.isA(Integer.class),
				Mockito.isA(AutoZulieferung.class));
		autoProduktion.productionLine(2, autoZulieferung);
		// Übergeben der exakt selben Parameter bei verify Aufruf
		Mockito.verify(autoProduktion, Mockito.times(1)).productionLine(2, autoZulieferung);
	}

//	Verify ProduceCar is called "amount"-times when productionLine is executed
	@Test
	public void testProducecarWasCalled() throws Exception {
		Mockito.when(autoZulieferung.produceParts(16, 10, 8, 2))
				.thenReturn(new ArrayList<Integer>(Arrays.asList(16, 10, 8, 2)));
		Mockito.doCallRealMethod().when(autoProduktion).productionLine(Mockito.isA(Integer.class),
				Mockito.isA(AutoZulieferung.class));
		autoProduktion.productionLine(2, autoZulieferung);
		Mockito.verify(autoProduktion, Mockito.times(2)).produceCar(); // Also possible: Mockito.atLeast, atLeastOnce,
	}

	@Test
	public void testProductionLineError() throws Exception {
		Mockito.doThrow(new Exception("Not enough of something.")).when(autoProduktion)
				.productionLine(Mockito.isA(Integer.class), Mockito.isA(AutoZulieferung.class));
		Exception thrown = null;
		try {
			autoProduktion.productionLine(1, autoZulieferung);
		} catch (Exception e) {
			thrown = e;
		}
		Assert.assertTrue(thrown.getMessage().contains("Not enough of something."));
	}

}
