import java.util.ArrayList;
import java.util.List;

public class KeuzeMenu {
	public static void main(String[] args) {
		KeuzeMenu keuzeMenu = new KeuzeMenu();
		if(args[1] != "") {
			List Routes = keuzeMenu.vindRoute(args[0],args[1]);

		}
	}

	private static ArrayList<Routes> vindRoute(String stad1, String stad2) {
		return null;
	}

	public ArrayList<Routes> getRoutes() {
		return null;
	}

	public Routes getQuickestRoute() {
		return null;
	}

}
