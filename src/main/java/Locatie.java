import java.util.ArrayList;

public class Locatie {
	protected static ArrayList<Plaats> Plaatsen;
    protected static ArrayList<Hectometerpaal> HectometerPalen;

    public Locatie() {
        vulPlaatsenArray();
    }

    private void vulPlaatsenArray() {
        String[] steden = new String[4];
        steden[0] = "Utrecht";
        steden[1] = "Arnhem";
        steden[2] = "Nijmegen";
        steden[3] = "Elst";

        for(String stad : steden) {
            Plaats p = new Plaats(stad);
            Plaatsen.add(p);
        }
    }


}
