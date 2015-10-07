import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class KeuzeMenu {
    private static KeuzeMenu keuzeMenu;

	public static void main(String[] args) {
        keuzeMenu = new KeuzeMenu();
        HashMap<Integer, Route> routelist = keuzeMenu.vindRoute("Nijmegen","Utrecht");
        for(int i : routelist.keySet()) {
            Route r = routelist.get(i);
            System.out.println(r.getVerbindingen());
            System.out.println(r.getTijd() + r.TotaleVertraging());
            System.out.println("-----------------------------------");
        }
	}

	private static HashMap<Integer,Route> vindRoute(String stad1, String stad2) {
		HashMap<Integer,Route> routeList = new HashMap();
        Routes routes = new Routes();
        HashMap<Route,ArrayList<Object>> data = routes.creerRoutes(stad1, stad2);
        Route quickestRoute = keuzeMenu.getQuickestRoute(data);
        routeList.put(1, quickestRoute);
        int i = 1;
        for(Route r : data.keySet())
            if (!r.equals(quickestRoute)) {
                i++;
                routeList.put(i,r);
            }

        return routeList;
	}

	public Route getQuickestRoute(HashMap<Route,ArrayList<Object>> data) {
		double smallestRoute = -1;
        Route r = null;
        for(Route route : data.keySet()) {
            double time = 0;
            ArrayList al = data.get(route);
            if(al.size() >= 3) {
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
