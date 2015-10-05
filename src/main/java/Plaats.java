public class Plaats extends Locatie {
	private String plaatsnaam;

	public Plaats(double lengte, double breedte, String plaatsnaam) {
		super(lengte, breedte);
		this.plaatsnaam = plaatsnaam;
	}

	public String getPlaatsNaam() {
		return plaatsnaam;
	}

	public void setPlaatsNaam(String plaatsnaam) {
		this.plaatsnaam = plaatsnaam;
	}
}
