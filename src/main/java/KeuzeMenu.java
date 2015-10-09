import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class KeuzeMenu {
    private static KeuzeMenu keuzeMenu;

	public static void main(String[] args) {
        KeuzeMenu keuzeMenu = new KeuzeMenu();
        keuzeMenu.KeuzeMenu1();
	}

    private void KeuzeMenu1() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Menu opties");
        System.out.println("-(1) Route Zoeken");
        System.out.println("-(2) Vertraging doorgeven");
        System.out.println("-(3) Weg niet toegankelijk");
        System.out.println("-(4) Afsluiten");

        System.out.println("Kies uit het menu:");
        int menu = scanner.nextInt();
        switch(menu) {
            case 1: {
                startMetZoekenNaarRoutes();
                break;
            }
            case 2: {
                geefVertragingOpStukDoor();
                break;
            }
            case 3: {
                geefWegNietToegankelijkDoor();
                break;
            }
            case 4: {
                System.exit(1);
                break;
            }
            default: {
                System.out.println("Verkeerde input.");
                break;
            }
        }
    }

    private void geefWegNietToegankelijkDoor() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Verbinding> verbindingen = null;

        System.out.println("Mogelijke steden om verbindgs toegang te veranderen: Arnhem, Nijmegen, Utrecht");
        System.out.print("Geef de eerste stad: ");
        String stad1 = scanner.next();
        System.out.print("Geef de tweede stad: ");
        String stad2 = scanner.next();

        String vmogelijkheden = "";
        ArrayList<Integer> al = new ArrayList<Integer>();
        keuzeMenu = new KeuzeMenu();
        HashMap<Integer, Route> routelist = vindRoute(stad1, stad2);
        for(int i : routelist.keySet()) {
            Route r = routelist.get(i);
            ArrayList<Verbinding> alv = r.getVerbindingen();
            verbindingen = alv;

            for(Verbinding v : alv) {
                if (vmogelijkheden.equals("")) {
                    vmogelijkheden = alv.indexOf(v) + "";
                    al.add(alv.indexOf(v));
                } else {
                    vmogelijkheden = vmogelijkheden + "," + alv.indexOf(v);
                    al.add(alv.indexOf(v));
                }
            }
        }

        System.out.println("Mogelijke verbinding ID's: "+vmogelijkheden);
        System.out.print("Geef het ID van de verbinding: ");
        int id = scanner.nextInt();

        if(al.contains(id)) {
            Verbinding v = verbindingen.get(id);
            if(v.getToegang()) {
                v.setToegang(false);
            } else {
                v.setToegang(true);
            }
            System.out.println("Vertraging doorgegeven op verbinding "+id+", Toegang: "+v.getToegang());
        } else System.out.println("Proberen dit kapot te maken werkt niet :)");

        KeuzeMenu1();
    }

    private void geefVertragingOpStukDoor() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Verbinding> verbindingen = null;

        System.out.println("Mogelijke steden om verbindingen vertraagd door te laten geven: Arnhem, Nijmegen, Utrecht");
        System.out.print("Geef de eerste stad: ");
        String stad1 = scanner.next();
        System.out.print("Geef de tweede stad: ");
        String stad2 = scanner.next();

        String vmogelijkheden = "";
        ArrayList<Integer> al = new ArrayList<Integer>();
        keuzeMenu = new KeuzeMenu();
        HashMap<Integer, Route> routelist = vindRoute(stad1, stad2);
        for(int i : routelist.keySet()) {
            Route r = routelist.get(i);
            ArrayList<Verbinding> alv = r.getVerbindingen();
            verbindingen = alv;

            for(Verbinding v : alv) {
                if (vmogelijkheden.equals("")) {
                    vmogelijkheden = alv.indexOf(v) + "";
                    al.add(alv.indexOf(v));
                } else {
                    vmogelijkheden = vmogelijkheden + "," + alv.indexOf(v);
                    al.add(alv.indexOf(v));
                }
            }
        }

        System.out.println("Mogelijke verbinding ID's: "+vmogelijkheden);
        System.out.print("Geef het ID van de verbinding: ");
        int id = scanner.nextInt();

        if(al.contains(id)) {
            Verbinding v = verbindingen.get(id);
            System.out.print("Geef vertragingstijd: ");
            int time = scanner.nextInt();
            double t = (double) time;
            v.setVertragingsTijd(t);
            System.out.println("Vertraging doorgegeven op verbinding "+id+", vertragingstijd: "+t);
        } else System.out.println("Proberen dit kapot te maken werkt niet :)");

        KeuzeMenu1();
    }

    private void startMetZoekenNaarRoutes() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mogelijke steden: Arnhem, Nijmegen, Utrecht");
        System.out.print("Geef de eerste stad: ");
        String stad1 = scanner.next();
        System.out.print("Geef de tweede stad: ");
        String stad2 = scanner.next();

        keuzeMenu = new KeuzeMenu();
        HashMap<Integer, Route> routelist = vindRoute(stad1, stad2);
        for(int i : routelist.keySet()) {
            Route r = routelist.get(i);

            for(Verbinding v : r.getVerbindingen()) {
                System.out.print(v.getStartpunt().getPlaatsNaam() + " - " + v.getEindpunt().getPlaatsNaam() + "; ");
            }
            System.out.println("");
            if(r.TotaleVertraging() > 0.00) {
                System.out.println("FILE GEVONDEN OP ROUTE. Extra reistijd: "+r.TotaleVertraging());
                System.out.println(r.getTijd() + r.TotaleVertraging());
            } else System.out.println(r.getTijd() + r.TotaleVertraging());
            System.out.println("-----------------------------------");
        }
        KeuzeMenu1();
    }

    private static HashMap<Integer,Route> vindRoute(String stad1, String stad2) {
        HashMap<Integer,Route> routeList = new HashMap<Integer, Route>();
        Routes routes = new Routes();
        HashMap<Route,ArrayList<Object>> data = routes.creerRoutes(stad1, stad2);
        Route quickestRoute = keuzeMenu.getQuickestRoute(data);
        routeList.put(1, quickestRoute);

        int i = 1;
        for(Route r : data.keySet()) {
            if (!r.equals(quickestRoute)) {
                i++;
                routeList.put(i, r);
            }
        }
        return routeList;
	}

	public Route getQuickestRoute(HashMap<Route,ArrayList<Object>> data) {
		double smallestRoute = -1;
        Route r = null;
        for(Route route : data.keySet()) {
            double time = 0;
            ArrayList al = data.get(route);
            if(al.size() >= 2) {
                double vertraging = new Double(al.get(1).toString());
                int tijd = (Integer) al.get(2);
                time = vertraging + (double) tijd;

                if (smallestRoute == -1) {
                    smallestRoute = time;
                    r = route;
                } else if (smallestRoute > time) {
                    smallestRoute = time;
                    r = route;
                }
            }
        }

        return r;
	}

}
