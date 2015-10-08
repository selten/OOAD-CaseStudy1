import java.util.ArrayList;
import java.util.HashMap;

public class Verbindingen {
    private HashMap<String, HashMap<String,Integer>> distances = new HashMap<String, HashMap<String,Integer>>();
    private HashMap<Integer,Verbinding> verbindingen = new HashMap<Integer,Verbinding>();

	public Verbindingen() {
        distanceArrayCreator();
        verbindingCreator();
    }

    private void distanceArrayCreator() {
        HashMap<String,Integer> UtrechtFrom = new HashMap<String,Integer>();
        UtrechtFrom.put("Arnhem",50000);
        UtrechtFrom.put("Nijmegen",75000);
        HashMap<String,Integer> ArnhemFrom = new HashMap<String, Integer>();
        ArnhemFrom.put("Utrecht",60000);
        ArnhemFrom.put("Nijmegen",20000);
        ArnhemFrom.put("Elst", 10000);
        HashMap<String,Integer> NijmegenFrom = new HashMap<String, Integer>();
        NijmegenFrom.put("Utrecht",70000);
        NijmegenFrom.put("Arnhem",25000);
        NijmegenFrom.put("Elst", 13000);
        HashMap<String,Integer> ElstFrom = new HashMap<String, Integer>();
        ElstFrom.put("Arnhem",12000);
        ElstFrom.put("Nijmegen", 12000);

        distances.put("Utrecht",UtrechtFrom);
        distances.put("Arnhem",ArnhemFrom);
        distances.put("Nijmegen",NijmegenFrom);
        distances.put("Elst",ElstFrom);
    }

    private void verbindingCreator() {
        int i = 0;
        Locatie l = new Locatie();
        ArrayList<Plaats> plaatsen = l.getPlaatsen();
        for(Plaats plaats : plaatsen) {
            HashMap<String,Integer> data = distances.get(plaats.getPlaatsNaam());
            for(String p2 : data.keySet()) {
                if(!plaats.getPlaatsNaam().equals(p2)) {
                    int dist = data.get(p2);
                    Plaats p2name = null;
                    for (Plaats plaats2 : plaatsen)
                        if (plaats2.getPlaatsNaam().equals(p2)) p2name = plaats2;
                    Verbinding verbinding = new Verbinding();
                    verbinding.creerVerbinding(plaats, p2name, dist);
                    verbindingen.put(i, verbinding);
                    i++;
                }
            }
        }
    }

    public HashMap<Integer, Verbinding> getVerbindingen() {
        return verbindingen;
    }
}
