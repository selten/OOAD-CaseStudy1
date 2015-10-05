public class Hectometerpaal {
    private double Breedte;
    private double Lengte;

    public Hectometerpaal(double lengte, double breedte) {
        setBreedteGraad(breedte);
        setLengteGraad(lengte);
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
