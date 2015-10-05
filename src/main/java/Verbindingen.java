import java.util.ArrayList;
import java.util.HashMap;

public class Verbindingen {
    private HashMap distances = new HashMap();
    private ArrayList verbindingen = new ArrayList();

	public Verbindingen() {
        distanceArrayCreator();
        verbindingCreator();
    }

    private void distanceArrayCreator() {
        HashMap<String,Integer> UtrechtFrom = new HashMap();
        UtrechtFrom.put("Arnhem",50000);
        UtrechtFrom.put("Nijmegen",75000);
        UtrechtFrom.put("Elst",65000);
        HashMap<String,Integer> ArnhemFrom = new HashMap();
        ArnhemFrom.put("Utrecht",60000);
        ArnhemFrom.put("Nijmegen",20000);
        ArnhemFrom.put("Elst", 10000);
        HashMap<String,Integer> NijmegenFrom = new HashMap();
        NijmegenFrom.put("Utrecht",70000);
        NijmegenFrom.put("Arnhem",25000);
        NijmegenFrom.put("Elst", 13000);
        HashMap<String,Integer> ElstFrom = new HashMap();
        ElstFrom.put("Utrecht",70000);
        ElstFrom.put("Arnhem",12000);
        ElstFrom.put("Nijmegen", 12000);

        distances.put("Utrecht",UtrechtFrom);
        distances.put("Arnhem",ArnhemFrom);
        distances.put("Nijmegen",NijmegenFrom);
        distances.put("Elst",ElstFrom);
    }

    private void verbindingCreator() {
        int i = 0;
        ArrayList<Plaats> plaatsen = Locatie.Plaatsen;
        for(Plaats plaats : plaatsen) {
            HashMap data = (HashMap) distances.get(plaats);
            for(Object p2 : data.keySet()) {
                int dist = (Integer) data.get(p2);
                Plaats p2name = null;
                for(Plaats plaats2 : plaatsen)
                    if (plaats2.getPlaatsNaam().equals(p2.toString())) p2name = plaats2;
                Verbinding verbinding = new Verbinding();
                verbinding.creerVerbinding(plaats,p2name,dist);

                verbindingen.add(i,verbinding);
                i++;
            }
        }
    }
}
