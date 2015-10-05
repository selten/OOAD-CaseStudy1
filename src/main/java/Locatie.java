public class Locatie {
	private double LengteGraad;
	private double BreedteGraad;

	public Locatie(double lengte, double breedte) {
		this.LengteGraad = lengte;
		this.BreedteGraad = breedte;
	}

	public double getBreedteGraad() {
		return this.BreedteGraad;
	}

	public double getLengteGraad() {
		return this.LengteGraad;
	}

}
