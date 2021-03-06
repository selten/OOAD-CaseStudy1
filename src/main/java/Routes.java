import java.util.*;

public class Routes {

	private HashMap<Route,ArrayList<Object>> routes = new HashMap();
	private static final HashSet<Route> DB_ROUTES = new HashSet<Route>(){
		{
			add(new Route("Utrecht","Arnhem", new ArrayList<Integer>(Arrays.asList(1,2,3))));
			add(new Route("Utrecht","Arnhem", new ArrayList<Integer>(Arrays.asList(5,2,3))));
			add(new Route("Utrecht","Arnhem", new ArrayList<Integer>(Arrays.asList(5,2,6,8))));
			add(new Route("Arnhem","Nijmegen", new ArrayList<Integer>(Arrays.asList(9,10,11))));

			add(new Route("Utrecht","Nijmegen", new ArrayList<Integer>(Arrays.asList(1,2,3,9,10,11))));
		}};
//add(new Route("Arnhem","Nijmegen", new ArrayList<Integer>(Arrays.asList(14,10,11))));

	public HashMap<Route,ArrayList<Object>> creerRoutes(String stad1, String stad2) {
		boolean running = true;
		for (Route routeOption : DB_ROUTES) {
			if (routeOption.getBeginstad().getPlaatsNaam().equals(stad1) && routeOption.getEindstad().getPlaatsNaam().equals(stad2)) {
				if (routeOption.checkRoute()) {
					ArrayList DescriptiveData = new ArrayList();
					DescriptiveData.add(routeOption.getVerbindingen());
					DescriptiveData.add(routeOption.TotaleVertraging());
					DescriptiveData.add(routeOption.getTijd());
					routes.put(routeOption, DescriptiveData);
				}
			}
		}
		return routes;
	}

    public HashMap<Route,ArrayList<Object>> getRoutes() {
        return routes;
    }
}
