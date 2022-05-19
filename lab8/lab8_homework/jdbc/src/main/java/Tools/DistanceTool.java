package Tools;

import Model.City;
import Model.Territory;

/**
 *
 * @author vital
 */
public class DistanceTool {

    public void calculte(Territory territoryA, Territory territoryB) {
        City cityA = (City) territoryA;
        City cityB = (City) territoryB;
        // conversion of degrees to radians.
        double lon1 = Math.toRadians(cityA.getLongitude());
        double lon2 = Math.toRadians(cityB.getLongitude());
        double lat1 = Math.toRadians(cityA.getLatitude());
        double lat2 = Math.toRadians(cityA.getLatitude());

        // Haversine formula
        double dlon = lon2 - lon1;
        double dlat = lat2 - lat1;

        double a = Math.pow(Math.sin(dlat / 2), 2)
                + Math.cos(lat1) * Math.cos(lat2)
                * Math.pow(Math.sin(dlon / 2), 2);

        double c = 2 * Math.asin(Math.sqrt(a));

        // Radius of earth in kilometers
        double r = 6371;

        System.out.println("Distance between " + cityA.getName() + " and " + cityB.getName() + " is: " + c * r + " kilometers.");
    }
}
