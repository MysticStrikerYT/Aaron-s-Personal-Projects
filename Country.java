		
		/**
		 * The Class Country.
		 *
		 * @author Aditya Aaron Koul
		 * @version December 5th 2023
		 * This Country Class has a constructor that creates all the country objects for the HashTable 
		 * that's used in the HashTable Class 
		 * This Country Class also has a myriad of getters and setters that get
		 * and set the values for each attribute of every single country object from the countries5.csv file  
		 * that's used throughout the project 
		 * ranging from a Country's Name, Capitol, Population, GDP, Area, HappinessIndex 
		 * that's in the (comma-separated-values) CSV file that's scanned and read into the Project 5 program 
		 * The Country Class also has a method to print out the contents of the country objects called printCountryReport
		 * and a print-format method that formats the output for each of the country objects fields
		 */
			public class Country{
				
				/** The Country name. */
				String CountryName = "";
				
				/** The Capitol city. */
				String CapitolCity = "";
				
				/** The Population. */
				double Population = 0;
				
				/** The GDP. */
				double GDP = 0;
				
				/** The Area. */
				double Area;
				
				/** The Happiness index. */
				double HappinessIndex = 0;
				
				/**
				 * Instantiates a new country.
				 *
				 * @param Name the name
				 * @param Capitol the capitol
				 * @param Population the population
				 * @param GDP the gdp
				 * @param Area the area
				 * @param HappinessIndex the happiness index
				 */
				//Constructor of type Country that creates the country objects for the Binary Search Tree 
				public Country(String Name, String Capitol, double Population, double GDP, double Area, double HappinessIndex) {
				this.CountryName = Name;
				this.CapitolCity = Capitol;
				this.Population = Population;
				this.GDP = GDP;
				this.Area = Area;
				this.HappinessIndex = HappinessIndex;
				}
				
				/**
				 * 		//this constructor takes in a name and happinessindex value as its parameters and creates a user-defined country object for option 4 for the 
				 * Project4 menu .
				 *
				 * @param countryname the countryname
				 * @param HappinessIndex the happiness index
				 */
				public Country(String countryname, double HappinessIndex) {
					this.CountryName = countryname;
					this.HappinessIndex = HappinessIndex;
				}
		
				/**
				 * Gets the name.
				 *
				 * @return the name
				 */
				public  String getName() {
					return CountryName;
				}
				
				/**
				 * Sets the name.
				 *
				 * @param Name the new name
				 */
				public void setName(String Name) {
					this.CountryName = Name;
				}
				
				/**
				 * Gets the capitol.
				 *
				 * @return the capitol
				 */
				public String getCapitol() {
					return CapitolCity;
				}
				
				/**
				 * Sets the capitol.
				 *
				 * @param Capitol the new capitol
				 */
				public void setCapitol(String Capitol) {
					this.CapitolCity = Capitol;
				}
				
				/**
				 * Gets the population.
				 *
				 * @return the population
				 */
				public double getPopulation() {
					return Population;
				}
				
				/**
				 * Sets the population.
				 *
				 * @param Population the new population
				 */
				public void setPopulation(double Population) {
					this.Population = Population;
				}
				
				/**
				 * Gets the gdp.
				 *
				 * @return the gdp
				 */
				public double getGDP() {
					return GDP;
				}
				
				/**
				 * Sets the gdp.
				 *
				 * @param GDP the new gdp
				 */
				public void setGDP(double GDP) {
					this.GDP = GDP;
				}
				
				/**
				 * Gets the happiness index.
				 *
				 * @return the happiness index
				 */
				public double getHappinessIndex() {
					return HappinessIndex;
				}
				
				/**
				 * Sets the happiness index.
				 *
				 * @param HappinessIndex the new happiness index
				 */
				public void setHappinessIndex(double HappinessIndex) {
					this.HappinessIndex = HappinessIndex;
				}
				
				/**
				 * Gets the area.
				 *
				 * @return the area
				 */
				public double getArea() {
					return Area;
				}
				
				/**
				 * Sets the area.
				 *
				 * @param Area the new area
				 */
				public void setArea(double Area) {
					this.Area = Area;
				}
				
				/**
				 * Gets the GDP per cap.
				 *
				 * @return the GDP per cap
				 */
				public double getGDPperCap() {
					double GDPPerCap = GDP / Population;
					return GDPPerCap;
				}
				
				/**
				 * Gets the apc.
				 *
				 * @return the apc
				 */
				public double getAPC() {
					double APC = Area/Population;
					return APC;
				}
				
				/**
				 * Gets the population.
				 *
				 * @return the population
				 */
				public double getpopulation() {
					double Population = 0;
				double Population1 = Population / Area;
					return Population1;
				}
				
			/**
			 * Prints the country report.
			 */
			public void printCountryReport() {
				String Name = this.getName();	
				String Capitol = this.getCapitol();
				double Population = getPopulation();
				//double GDP = getGDP();
				double GDPPerCap = this.getGDPperCap();
				//double Area = getArea();
				double APC = this.getAPC();
				double HappinessIndex = this.getHappinessIndex();
				System.out.printf("%-30s %-16s %-10.3f %-9.6f %-9.3f\n",Name,Capitol,GDPPerCap,APC,HappinessIndex);
				}
		
			
		
			
		
			}	
				