import java.util.ArrayList;
import java.util.HashMap;

public class Route {
	private Plaats Startpunt;
	private Plaats Eindpunt;
	private double Reistijd;
    private HashMap<Integer,Verbinding> verbindingen;
    private ArrayList<Integer> verbindingidlijst;

	public Route(String stad1, String stad2, ArrayList<Integer> list) {
        Verbindingen verbindingLijst = new Verbindingen();
        verbindingen = verbindingLijst.getVerbindingen();
        //new ArrayList<Integer>(Arrays.asList(1,2,3))
        verbindingidlijst = list;
	}

	public ArrayList<Verbinding> getVerbindingen() {
        ArrayList<Verbinding> verbindingdata = new ArrayList<Verbinding>();
        System.out.println("verbindinglijst grootte: "+verbindingidlijst.size());
        for(int i : verbindingidlijst) {
            Verbinding verbinding = verbindingen.get(i);
            if(verbinding != null) {
                verbindingdata.add(verbinding);
            } else System.out.println("verbinding "+i+" is null.");
        }
        return verbindingdata;
	}

	public double TotaleVertraging() {
        double tijd = 0;
        for(int i : verbindingidlijst) {
            Verbinding verbinding = verbindingen.get(i);
            if(verbinding != null) {
                tijd += verbinding.getVertragingsTijd();
            }
        }
        return tijd;
	}

    public int getTijd() {
        int tijd = 0;
        for(int i : verbindingidlijst) {
            Verbinding verbinding = verbindingen.get(i);
            if(verbinding != null) {
                tijd += verbinding.getAfstand();
            }
        }
        return tijd;
    }

    public boolean checkRoute() {
        boolean toegang = true;
        for(int i : verbindingidlijst) {
            Verbinding verbinding = verbindingen.get(i);

            if(verbinding != null) {
                if(!verbinding.getToegang()) toegang = false;
            }
        }
        return toegang;
    }
}
