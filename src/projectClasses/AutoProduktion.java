package projectClasses;

public class AutoProduktion {

	private int autos = 0;

	public int produceCar() {
		this.autos++;
		return autos;
	}

	public void productionLine(int amount) {
		if (amount < 0)
			return;
		for (int i = 0; i < amount; i++) {
			produceCar();
		}
	}

}
