package projectClasses;

import java.util.ArrayList;
import java.util.List;

public class CarProduction {

	private int cars = 0;
	AutoZulieferung carPartsDelivery;
	List<Integer> carParts = new ArrayList<>();

	public int produceCar() throws Exception {
		if (carParts.get(0) < 8 || carParts.get(1) < 5 || carParts.get(2) < 4 || carParts.get(3) < 1)
			throw new Exception("Not enough car parts.");
		carParts.set(0, carParts.get(0) - 8); // sheetMetals
		carParts.set(0, carParts.get(1) - 5); // windows
		carParts.set(0, carParts.get(2) - 4); // tires
		carParts.set(0, carParts.get(3) - 1); // interior
		this.cars++;
		return cars;
	}

	public void productionLine(int amountOfCars, AutoZulieferung carPartsDelivery) throws Exception {
		if (amountOfCars < 0)
			throw new Exception("Only positive numbers allowed");

		deliverParts(amountOfCars, carPartsDelivery);
		for (int i = 0; i < amountOfCars; i++) {
			System.out.println(produceCar() + " cars have been produced so far.");
		}
	}

	public void deliverParts(int amountOfCars, AutoZulieferung carPartsDelivery) throws Exception {
		carParts = carPartsDelivery.produceParts(amountOfCars * 8, amountOfCars * 5, amountOfCars * 4, amountOfCars);
	}

	public boolean sellCars(int amount) {
		this.cars -= amount;
		return cars >= 0;
	}

}
