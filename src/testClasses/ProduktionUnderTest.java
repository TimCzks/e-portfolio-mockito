package testClasses;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import projectClasses.AutoProduktion;

@RunWith(MockitoJUnitRunner.class)
class ProduktionUnderTest extends AutoProduktion {

	AutoProduktion autoProduktion = Mockito.mock(AutoProduktion.class);

	@Test
	public void testProducecar() {
		Mockito.when(autoProduktion.produceCar()).thenReturn(2);
		assertEquals(2, autoProduktion.produceCar());
	}

	@Test
	public void testProductionLine() {
		Mockito.doNothing().when(autoProduktion).productionLine(Mockito.isA(Integer.class));
		autoProduktion.productionLine(2);
		Mockito.verify(autoProduktion, Mockito.times(1)).productionLine(2);
	}

	@Test
	public void testProductionLineError() {
		Mockito.doNothing().when(autoProduktion).productionLine(Mockito.isA(Integer.class));
		autoProduktion.productionLine(-2);
		Mockito.verify(autoProduktion, Mockito.times(1)).productionLine(-2);
	}

}
