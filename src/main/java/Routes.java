import java.util.*;

public class Routes {

	private ArrayList<Route> routes;
	private static final HashSet<Route> DB_ROUTES = new HashSet<Route>(){
		{
			add(new Route("Utrecht","Arnhem", new ArrayList<Integer>(Arrays.asList(1,2,3))));
			add(new Route("Utrecht","Arnhem", new ArrayList<Integer>(Arrays.asList(5,2,3))));
			add(new Route("Utrecht","Arnhem", new ArrayList<Integer>(Arrays.asList(5,2,6,8))));
			add(new Route("Arnhem","Nijmegen", new ArrayList<Integer>(Arrays.asList(9,10,11))));
			add(new Route("Arnhem","Nijmegen", new ArrayList<Integer>(Arrays.asList(14,10,11))));
			add(new Route("Utrecht","Nijmegen", new ArrayList<Integer>(Arrays.asList(1,2,3,9,10,11))));
		}};


	public ArrayList<Route> creerRoutes(String stad1, String stad2) {
		boolean running = true;

		for (Route routeOption : DB_ROUTES) {
			if (routeOption.checkRoute(stad1, stad2)) {
				routeOption.getVerbindingen();
				routeOption.TotaleVertraging();
				routes.add(routeOption);
			}
		}
		return routes;
	}

}
