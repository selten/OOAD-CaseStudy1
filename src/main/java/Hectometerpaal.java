public class Hectometerpaal extends Locatie {
    private double Breedte;
    private double Lengte;

    public Hectometerpaal(int lengte, int breedte) {
        super(lengte, breedte);
    }

    public void setBreedteGraad(double breedte) {
        this.Breedte = breedte;
    }

    public void setLengteGraad(double lengte) {
        this.Lengte = lengte;
    }

    public double getBreedteGraad() {
        return Breedte;
    }

    public double getLengteGraad() {
        return Lengte;
    }
}
