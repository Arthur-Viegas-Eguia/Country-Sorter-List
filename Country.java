import java.util.HashMap;
/**
 * Country class contains information about a country and its indicators.
 * It also has methods for an user to access them.
 */

public class Country {
    /**
     * variable stats is a HashMap which stores the name of the country and
     * all its indicators.
     */
    HashMap<String, String> stats = new HashMap<String, String>();
    /**
     * Creates the HashMap and adds to it the name of the country and
     * and all its indicators.
     * @param in a String representing the name of the country and all  its indicators. It should be a comma separated list.
     */
    public Country(String in){
        String[] splitline = in.split(",");
        stats.put("Name",splitline[0]);
        stats.put("Population Total", splitline[1]);
        stats.put("CO2 Emissions", splitline[2]);
        stats.put("Access To Electricity", splitline[3]);
        stats.put("Renewable Energy", splitline[4]);
        stats.put("Protected Areas", splitline[5]);
        stats.put("Population Growth", splitline[6]);
        stats.put("Urban Population Growth", splitline[7]);
    }
    /**
     * Returns to the user the selected indicator of the country
     * @param indicator a String representing the name of an indicator
     * @return a double, representing the value of the inicator chosen
     */
    public double getStat(String indicator) {
        return Double.parseDouble(stats.get(indicator));
    }
    /**
     * Gets the name of the country.
     * @return a String representing the name of the country
     */
    public String getName() {
        return stats.get("Name");
    }

}
