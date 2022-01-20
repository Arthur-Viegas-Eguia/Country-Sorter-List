# Sorted-Country-List
Adaptation of code which was originally developed as homework for my Data Structures class.
## Overview
The program models a list of countries, sorted in ascending order based on a predetermined indicator. It displays the top/bottom X countries based on the value of the selected indicator. 
With this program you can:
- Specify your own dataset by providing the program with a text file containing a list of
countries and their indicators
- Specify the indicator you want to use to order the list
- See the top/bottom X countries based on their value in the specified indicator. 
## Usage

To use the program, you have to compile and run the code after downloading. To do this, simply
type in the terminal:
``` 
javac *.java
java CountrySorterList value

```
Where value represents the path of the external file which contains a list of countries and their
indicators. value should be a comma separated list, with a header containing the name of the
indicators followed by a list of 0 or many countries. The list must contain the following
indicators in the following order: Country Name, Population (total), CO2 emissions (metric tons
per capita), Access to electricity (% of population), Renewable energy consumption (% of total
final energy consumption), Terrestrial protected areas (% of total land area), Population growth
(annual %), Urban population growth (annual %). All Operations of the program depend on the
list of countries and its indicators. So it is important that the file provided has the format
specified and the path to it is correct.
