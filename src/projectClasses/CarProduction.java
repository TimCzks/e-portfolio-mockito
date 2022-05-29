package projectClasses;

public class CarProduction {

	private int cars = 0;
	private int sheetMetals = 0;
	private int tires = 0;
	private int windows = 0;
	private int interior = 0;

	public int produceCar() {

		this.sheetMetals -= 8;
		this.tires -= 4;
		this.windows -= 5;
		this.interior -= 1;
		// TODO: Check, if enough carParts are there
		this.cars++;

		return cars;
	}

	public void productionLine(int amount) throws Exception {
		AutoZulieferung carPartsDelivery = new AutoZulieferung();

		if (amount < 0)
			throw new Exception("Only positive numbers allowed");
		for (int i = 0; i < amount; i++) {
			if (carPartsDelivery.produceParts(8, 5, 4, 1)) {
				sheetMetals += 8;
				windows += 5;
				tires += 4;
				interior += 1;
			}
			System.out.println(produceCar() + " cars have been produced so far.");
		}
	}

}
