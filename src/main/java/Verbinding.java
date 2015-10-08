public class Verbinding {
	private Plaats Startpunt;
	private Plaats Eindpunt;
	private int Afstand =0;
    private double Vertragingstijd = 0.00;
    private String Vertragingssoort;
    private boolean Toegang;

	public void creerVerbinding(Plaats start, Plaats eind, int dist) {
        Startpunt = start;
        Eindpunt = eind;
        Afstand = dist;
    }

    public boolean getToegang() {
        return Toegang;
    }

    public Plaats getStartpunt() {
        return Startpunt;
    }
    public Plaats getEindpunt() {
        return Eindpunt;
    }

    public int getAfstand() {
        return Afstand;
    }

    public void setVertragingsTijd(double time) {
        Vertragingstijd = time;
    }
    public double getVertragingsTijd() {
        return Vertragingstijd;
    }

    public void setVertragingsSoort(String soort) {
        Vertragingssoort = soort;
    }
    public String getVertragingsSoort() {
        return Vertragingssoort;
    }

    public boolean openVerbinding() {
        if(Toegang) return false;
        else {
            Toegang = true;
            return true;
        }
    }
    public boolean sluitVerbinding() {
        if(!Toegang) return false;
        else {
            Toegang = false;
            return true;
        }
    }
}
