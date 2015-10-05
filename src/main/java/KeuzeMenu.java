import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class KeuzeMenu {
    private static KeuzeMenu keuzeMenu;

	public static void main(String[] args) {
        keuzeMenu = new KeuzeMenu();
		if(args[1] != "") {
			List<Route> routelist = keuzeMenu.vindRoute(args[0],args[1]);

            for(Route r : routelist) {
                System.out.println(r.getVerbindingen());
                System.out.println(r.getTijd()+r.TotaleVertraging());
                System.out.println("-----------------------------------");
            }
		}
	}

	private static ArrayList<Route> vindRoute(String stad1, String stad2) {
		ArrayList<Route> routeList = new ArrayList<Route>();
        Routes routes = new Routes();
        HashMap<Route,ArrayList> data = routes.creerRoutes(stad1, stad2);
        Route quickestRoute = keuzeMenu.getQuickestRoute(data);
        routeList.add(1,quickestRoute);

        for(Route r : data.keySet())
            if (!r.equals(quickestRoute)) routeList.add(r);

        return routeList;
	}

	public Route getQuickestRoute(HashMap<Route,ArrayList> data) {
		double smallestRoute = -1;
        Route r = null;
        for(Route route : data.keySet()) {
            double time = 0;
            ArrayList al = data.get(route);
            double vertraging = (Double) al.get(2);
            int tijd = (Integer) al.get(3);
            time = vertraging + (double) tijd;

            if(smallestRoute == -1) {
                smallestRoute = time;
                r = route;
            } else if(smallestRoute > time) {
                smallestRoute = time;
                r = route;
            }
        }

        return r;
	}

}
