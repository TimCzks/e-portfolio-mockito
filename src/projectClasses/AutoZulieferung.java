package projectClasses;

public class AutoZulieferung {

	private double steel = 0;
	private int glass = 0;
	private int plastic = 0;
	private double rubber = 0;

	public boolean produceParts(int sheetMetals, int windows, int tires, int interior) {
		return produceSheetMetals(sheetMetals) && produceWindows(windows) && produceTires(tires)
				&& produceInterior(interior);

	}

	private boolean produceSheetMetals(int amount) {
		// TODO: Check, if enough resources are there
		if (steel < (amount * 2))
			return false;

		steel -= amount * 2;
		return true;
	}

	private boolean produceWindows(int amount) {
		if (glass < amount)
			return false;
		glass -= amount;
		return true;
	}

	private boolean produceTires(int amount) {
		if (rubber < (amount * 5) || steel < amount)
			return false;
		rubber -= amount * 5;
		steel -= amount;
		return true;
	}

	private boolean produceInterior(int amount) {
		if (plastic < (amount * 5) || rubber < amount || glass < amount)
			return false;
		rubber -= amount;
		plastic -= amount * 20;
		glass -= amount;
		return true;
	}

	private void getResources() {
		// Add another Class 'RessourcenVerteiler'
		steel += 50;
		glass += 20;
		plastic += 100;
		rubber += 100;
	}
}
