package Tools;

import static java.lang.Math.*;

/**
 *
 * @author vital
 */
public class CoordinatesTool {

    int mapWidth;
    int mapHeight;
    double radius;
    double FE = 180;

    private double degreesToRadians(double degrees) {
        return (degrees * Math.PI) / 180;
    }

    public CoordinatesTool(int width, int height) {
        this.mapHeight = height;
        this.mapWidth = width;
        radius = mapWidth / (2 * Math.PI);
    }

    public double getX(double longitude) {
        double lonRad = degreesToRadians(longitude + FE);
        double x = lonRad * radius;
        return x;
    }

    public double getY(double latitude) {
        double latRad = degreesToRadians(latitude);
        double verticalOffsetFromEquator = radius * Math.log(Math.tan(Math.PI / 4 + latRad / 2));
        double y = mapHeight / 2 - verticalOffsetFromEquator;
        return y;
    }
}
