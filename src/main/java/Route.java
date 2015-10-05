import java.util.ArrayList;

public class Route {
	private Plaats Startpunt;
	private Plaats Eindpunt;
	private double Reistijd;
	private Verbindingen verbindingLijst = new Verbindingen();
    private ArrayList verbindingen;
    private ArrayList<Integer> verbindingidlijst;

	public Route(String stad1, String stad2, ArrayList<Integer> list) {
        verbindingen = verbindingLijst.getVerbindingen();
        verbindingidlijst = list;
	}

	public ArrayList<Verbinding> getVerbindingen() {
        ArrayList verbindingdata = new ArrayList();
        for(int i : verbindingidlijst) {
            Verbinding verbinding = (Verbinding) verbindingen.get(i);
            verbindingdata.add(verbinding);
        }
        return verbindingdata;
	}

	public double TotaleVertraging() {
        double tijd = 0;
        for(int i : verbindingidlijst) {
            Verbinding verbinding = (Verbinding) verbindingen.get(i);
            tijd += verbinding.getVertragingsTijd();
        }
        return tijd;
	}

    public int getTijd() {
        int tijd = 0;
        for(int i : verbindingidlijst) {
            Verbinding verbinding = (Verbinding) verbindingen.get(i);
            tijd += verbinding.getAfstand();
        }
        return tijd;
    }

    public boolean checkRoute() {
        boolean toegang = true;
        for(int i : verbindingidlijst) {
            Verbinding verbinding = (Verbinding) verbindingen.get(i);

            if(!verbinding.getToegang()) toegang = false;
        }
        return toegang;
    }
}
