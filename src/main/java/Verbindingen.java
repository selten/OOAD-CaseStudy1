import java.util.ArrayList;

public class Verbindingen {
	private int VerbindingID;
	private Locatie Startpunt;
	private Locatie Eindpunt;

	public Verbindingen() {
        ArrayList<Plaats> plaatsen = Locatie.Plaatsen;
    }

	public boolean getToegang() {
		return false;
	}

	public double getVertraging() {
		return 0;
	}

}
