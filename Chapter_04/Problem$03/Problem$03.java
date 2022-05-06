package chapter_four;

/**
 * *4.3 (Geography: estimate areas) Use the GPS locations for Atlanta, Georgia; Orlando,
 * Florida; Savannah, Georgia; and Charlotte, North Carolina in the figure in Section
 * 4.1 to compute the estimated area enclosed by these four cities. (Hint: Use the
 * formula in Programming Exercise 4.2 to compute the distance between two cities.
 * Divide the polygon into two triangles and use the formula in Programming Exercise
 * 2.19 to compute the area of a triangle.)
 *
 * @author Sharaf Qeshta
 * */

public class Problem$03
{
    private static final double EARTH_RADIUS = 6371.01;
    public static void main(String[] args)
    {
        // Charlotte (35.2270869, –80.8431267)
        // Savannah (32.0835407, –81.0998342)
        // Orlando (28.5383355, –81.3792365)
        // Atlanta (33.7489954, –84.3879824)

        double chx = 35.2270869; double chy = -80.8431267;
        double sax = 32.0835407; double say = -81.0998342;
        double orx = 28.5383355; double ory = -81.3792365;
        double atx = 33.7489954; double aty = -84.3879824;

        // s1 = from Charlotte to Savannah
        // s2 = from Savannah to Orlando
        // s3 = from Orlando to Atlanta
        // s4 = from Atlanta to Charlotte

        double s1 = EARTH_RADIUS * Math.acos(Math.sin(Math.toRadians(chx)) * Math.sin(Math.toRadians(sax))
                + Math.cos(Math.toRadians(chx)) * Math.cos(Math.toRadians(sax))
                * Math.cos(Math.toRadians(chy - say)));

        double s2 = EARTH_RADIUS * Math.acos(Math.sin(Math.toRadians(sax)) * Math.sin(Math.toRadians(orx))
                + Math.cos(Math.toRadians(sax)) * Math.cos(Math.toRadians(orx))
                * Math.cos(Math.toRadians(say - ory)));

        double s3 = EARTH_RADIUS * Math.acos(Math.sin(Math.toRadians(orx)) * Math.sin(Math.toRadians(atx))
                + Math.cos(Math.toRadians(orx)) * Math.cos(Math.toRadians(atx))
                * Math.cos(Math.toRadians(ory - aty)));

        double s4 = EARTH_RADIUS * Math.acos(Math.sin(Math.toRadians(atx)) * Math.sin(Math.toRadians(chx))
                + Math.cos(Math.toRadians(atx)) * Math.cos(Math.toRadians(chx))
                * Math.cos(Math.toRadians(aty - chy)));


        // we need a side that will be the base of the two triangles
        // it from Atlanta to Savannah

        double base = EARTH_RADIUS * Math.acos(Math.sin(Math.toRadians(atx)) * Math.sin(Math.toRadians(sax))
                + Math.cos(Math.toRadians(atx)) * Math.cos(Math.toRadians(sax))
                * Math.cos(Math.toRadians(aty - say)));

        double s = (s1 + s4 + base) / 2;
        double t1Area = (Math.sqrt(s * (s - s1) * (s - s4) * (s - base)));

        s = (s2 + s3 + base) / 2;
        double t2Area = (Math.sqrt(s * (s - s2) * (s - s3) * (s - base)));
        System.out.println("The Area Is : " + (t1Area + t2Area)+ " km"); // 117863.34165943446 km
    }
}
