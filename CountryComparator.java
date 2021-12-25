import java.util.Comparator;
/**
 * CountryComparator class implements interface comparator. It
 * compares Country objects based on any indicator in it.
 */
public class CountryComparator implements Comparator<Country> {
    private String indicator;
    /**
     * Constructor of the class. Sets indicator used to sort objects.
     * @param indicator, a string representing the indicator chosen to sort the list.
     */
    public CountryComparator(String indicator) {
        this.indicator = indicator;
    } //end constructor
    /**
     * Compares the two countries passed as parameter based on instance variable indicator
     * @param country1 an object of type Country, which will be compared to another object of the same type
     * @param country2 an object of type Country, which will be compared to another object of the same type
     * @return -1 if country1 comes before country2, 1 if country2 comes before country1; 0 if they could be in either order. 
     */
    public int compare(Country country1, Country country2){
        int toReturn;
        if(country1.getStat(indicator) > country2.getStat(indicator)){
            toReturn = 1;
        } else if(country1.getStat(indicator) < country2.getStat(indicator)){
            toReturn = -1;
        } else {
            toReturn = 0;
        } //end if/else chain
        return toReturn;
    } //end compare
    /**
     * Tests if the CountryComparator is working properly. Testing if the class
     * works for different indicators.
     */
    public static void main(String[] args) {
        Country country = new Country("coun,1,2,3,4,5,5,8");
        Country country2 = new Country("try,2,3,4,5,5,7,8");
        CountryComparator test = new CountryComparator("Population Total");
        System.out.println(test.compare(country, country2));
        System.out.println(test.compare(country2, country));
        CountryComparator test2 = new CountryComparator("Access To Electricity");
        System.out.println(test2.compare(country, country2));
        System.out.println(test2.compare(country2, country));
        CountryComparator test3 = new CountryComparator("CO2 Emissions");
        System.out.println(test3.compare(country, country2));
        System.out.println(test3.compare(country2, country));
        CountryComparator test4 = new CountryComparator("Urban Population Growth");
        System.out.println(test4.compare(country, country2));
        System.out.println(test4.compare(country2, country));
    } //end main
} //end country comparator class
