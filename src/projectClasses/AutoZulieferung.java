package projectClasses;

import java.util.ArrayList;
import java.util.List;

public class AutoZulieferung {

	private double steel = 0;
	private int glass = 0;
	private int plastic = 0;
	private double rubber = 0;

	public List<Integer> produceParts(int sheetMetals, int windows, int tires, int interior) throws Exception {
		List<Integer> carParts = new ArrayList<>();
		carParts.add(produceSheetMetals(sheetMetals));
		carParts.add(produceWindows(windows));
		carParts.add(produceTires(tires));
		carParts.add(produceInterior(interior));
		return carParts;

	}

	private int produceSheetMetals(int amount) throws Exception {
		if (steel < (amount * 2))
			throw new Exception("Not enough resources.");
		steel -= amount * 2;
		return amount;
	}

	private int produceWindows(int amount) throws Exception {
		if (glass < amount)
			throw new Exception("Not enough resources.");
		glass -= amount;
		return amount;
	}

	private int produceTires(int amount) throws Exception {
		if (rubber < (amount * 5) || steel < amount)
			throw new Exception("Not enough resources.");
		rubber -= amount * 5;
		steel -= amount;
		return amount;
	}

	private int produceInterior(int amount) throws Exception {
		if (plastic < (amount * 5) || rubber < amount || glass < amount)
			throw new Exception("Not enough resources.");
		rubber -= amount;
		plastic -= amount * 20;
		glass -= amount;
		return amount;
	}

	public void getResources() {
		// Add another Class 'RessourcenVerteiler'
		steel += 50;
		glass += 20;
		plastic += 100;
		rubber += 100;
	}
}
