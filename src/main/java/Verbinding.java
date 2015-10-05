public class Verbinding {
	private Plaats Startpunt;
	private Plaats Eindpunt;
	private int Afstand;
    private double Vertragingstijd;
    private String Vertragingssoort;
    private boolean Toegang;

	public boolean getToegang() {
		return false;
	}

	public double getVertraging() {
		return 0;
	}

	public void creerVerbinding(Plaats start, Plaats eind, int dist) {
        Startpunt = start;
        Eindpunt = eind;
        Afstand = dist;
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
        if(Toegang == true) return false;
        else {
            Toegang = true;
            return true;
        }
    }

    public boolean sluitVerbinding() {
        if(Toegang == false) return false;
        else {
            Toegang = false;
            return true;
        }
    }

    public boolean getToegankelijk() {
        return Toegang;
    }
}
