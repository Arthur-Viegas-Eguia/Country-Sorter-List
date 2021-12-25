import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
/**
 * CountrySorter receives a list of countries, and orders them
 * in ascending order based on an indicator specified by the user. It has
 * methods to show the countries with the maximum or minimum values for the
 * indicator selected.
 */
public class CountrySorterList {
    private Node firstNode = null;
    private String indicator;
    private Node lastNode = null;
    public int numberOfEntries;
    /**
    * Class node models a linked data structure.
    */
    private class Node {
    private Country data; 
    private Node next;
    private Node previous; 
        /**
         * Creates a node which holds data of a generic type,
         * and sets the next node in series as null
         * @param dataPortion an object of a generic type
         */
    private Node(Country dataPortion) {
      this(dataPortion, null);
    } // end constructor
        /**
         * Creates a node which holds data of a generic type,
         * and sets the next node in series.
         * @param dataPortion an object of a generic type
         * @param nextNode a reference of type node, representing the next node in the series
         */
    private Node(Country dataPortion, Node nextNode) {
      data = dataPortion;
      next = nextNode;
    } // end constructor
  } // end Node
  /**
   * Constructs the class. Loads countries from external file and orders
   * them on ascending order based on the indicator passed as paramenter.
   * @param ind, a String, representing an indicator of the  country.
   * @param filename the path of the file containing a list of countries
   */
  public CountrySorterList(String ind, String filename) {
    indicator = ind;
    File inputFile = new File(filename);
    Scanner scanner = null;
    try {
      scanner = new Scanner(inputFile);
    } catch (FileNotFoundException e) {
      System.err.println(e);
      System.exit(1);
    } //end try/catch block
    scanner.nextLine();
    while (scanner.hasNextLine()) {
      Country newCountry = new Country(scanner.nextLine());
      add(newCountry);
    } //end while
    scanner.close();
  } //end constructor
  /** Finds the position a new node should be placed
   * in the list and returns the node that should be before it. 
  * @param entry an instance of Country
  * @return the node that should be placed before entry in the sorted list
  */
  private Node getPreviousNode(Country entry){
    Node current = firstNode;
    Node previousNode = null;
    CountryComparator comparator   =  new CountryComparator(indicator);
    while(current != null && (comparator.compare(entry, current.data)) > 0){
      previousNode = current;
      current = current.next; 
    } //end while
    return previousNode;
  } //end getPreviousNode
  /**
   * adds a node to its appropriate position on the sorted list.
   * @param country an instance of country, representing the node that will be added to the list
   */
  public void add(Country country){
    Node newNode = new Node(country);
    Node previousNode = getPreviousNode(country);
    if(firstNode == null){
      newNode.next = firstNode;
      newNode.previous = null;
      firstNode = newNode;
      lastNode = newNode;
    } else if(previousNode == null) {
      newNode.next = firstNode;
      firstNode.previous = newNode;
      firstNode = newNode;
    } else if(previousNode.next == null) {
      lastNode = newNode;
      previousNode.next = newNode;
      newNode.previous = previousNode;
    } else {
      newNode.next = previousNode.next;
      previousNode.next = newNode;
      newNode.previous = previousNode;
      newNode.next.previous = newNode;
    } //end if/else chain  
    numberOfEntries++;
  } //end add
  /**
   * Prints on the screen a list of numberOfCountries countries which
   * have the maximum value on the indicator selected.
   * @param numberOfCountries an integer, representing the number of countries of the list that will be printed
   */
  public void getMaxCountries(int numberOfCountries){
    int i = 0;
    Node currentNode = lastNode;
    if(numberOfCountries > numberOfEntries){
      System.out.println("It is not possible to get all the countries you want, sorry! The number you provided is larger than the number of countries");
    } else if(numberOfCountries < 0){
      System.out.println("This program can not get information of a negative number of countries, try a positive number instead");
    } else {
      while(i < numberOfCountries){
        System.out.println(currentNode.data.getName());
        currentNode = currentNode.previous;
        i++;
      } //end while
    } //end if/else chain
  } //end getMaxCountries
  /**
   * Prints on the screen a list of numberOfCountries countries which
   * have the minimum value on the indicator selected.
   * @param numberOfCountries an integer, representing the number of countries of the list that will be printed
   */
  public void getMinCountries(int numberOfCountries){
    int i = 0;
    Node currentNode = firstNode;
    if(numberOfCountries > numberOfEntries){
      System.out.println("It is not possible to get all the countries you want, sorry! The number you provided is larger than the number of countries");
    } else if(numberOfCountries < 0){
      System.out.println("This program can not get information of a negative number of countries, try a positive number instead");
    } else {
      while(i < numberOfCountries){
        System.out.println(currentNode.data.getName());
        currentNode = currentNode.next;
        i++;
      } //end while
    } //end if/else chain
  } //end getMinCountries
  /**
   * Receives the path from external file containing the list of countries.
   * Gives the user the opportunity to choose the indicator which is going to
   * be used to sort the list. Presents the user with the possible operations 
   * of the program and executes them.
   * @param args the path to an external file containing a list of countries
   */
  public static void main(String[] args) {
    if (args.length == 0) {
      Scanner userInput = new Scanner(System.in);
      System.out.println("Please make sure to type the path of the file with a list of countries!");
      System.exit(1);
    } //end if
    String filePath = args[0];
    CountrySorterList sortedCountries = null;
    Scanner userInput = new Scanner(System.in);
    boolean run = true;
    String menu;
    int menu2;
    int numberOfCountries;
    while(run){
      System.out.println("For population total (in millions of inhabitants) => type population");
      System.out.println("For CO2 emissions (in metric tons per capita) => type co2");
      System.out.println("for the % of population with access to electricity (in %) => type electricity");
      System.out.println("Renewable energy consumption (% of total final energy consumption) => type renewable");
      System.out.println("Terrestrial protected areas (% of total land area) => type protected");
      System.out.println("Population growth (annual %) type growth");
      System.out.println("Urban population growth (annual %) => type urban");
      System.out.print("Type the indicator you want to use to sort the list and do the further operations of the program: ");
      menu = userInput.nextLine();
      switch(menu){
        case "population":
        sortedCountries = new CountrySorterList("Population Total", filePath);
        run = false;
        break;
        case "co2":
        sortedCountries = new CountrySorterList("CO2 Emissions", filePath);
        run = false;
        break;
        case "electricity":
        sortedCountries = new CountrySorterList("Access To Electricity", filePath);
        run = false;
        break;
        case "renewable":
        sortedCountries = new CountrySorterList("Renewable Energy", filePath);
        run = false;
        break;
        case "protected":
        sortedCountries = new CountrySorterList("Protected Areas", filePath);
        run = false;
        break;
        case "growth":
        sortedCountries = new CountrySorterList("Population Growth", filePath);
        run = false;
        break;
        case "urban":
        sortedCountries = new CountrySorterList("Urban Population Growth", filePath);
        run = false;
        break;
        default:
        System.out.println("Invalid option, please type only population, co2, electricity, renewable, protected, growth or urban based on the indicator you want");
        break;
      } //end switch
    } //end while
    run = true;
    while(run){
      System.out.println("Type 1 to get the countries with the maximum value in the indicator you chose");
      System.out.println("Type 2 to get the countries with the minumum value in the indicator you chose");
      System.out.println("Type 3 to exit the program");
      menu2 = userInput.nextInt();
      switch(menu2){
        case 1:
        System.out.println("How many countries with the maximum indicator do you want to see?");
        numberOfCountries = userInput.nextInt();
        sortedCountries.getMaxCountries(numberOfCountries);
        break;
        case 2:
        System.out.println("How many countries with the minimum indicator do you want to see?");
        numberOfCountries = userInput.nextInt();
        sortedCountries.getMinCountries(numberOfCountries);
        break;
        case 3:
        run = false;
        break;
        default:
        System.out.println("Invalid option, please type only 1, 2, or based on the option you want");
        break;
      } //end switch
    } //end while
    userInput.close();
  } //end main
} //end CountrySorterList
