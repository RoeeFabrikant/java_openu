/**
 * Class City
 * public class City
 * Represents a city. City is represented by its name, the date it was established, center, central station, number of residents(non negative) and number of neighborhoods(positive).
 */

public class City {

  // Instance vars
  private String _cityName;
  private Date _dateEstablished;
  private Point _cityCenter;
  private Point _centralStation;
  private long _numOfResidents;
  private int _noOfNeighborhoods;

  // final vars
  private final long DEFAULT_NUM_OF_RESIDENTS = 0;
  private final int DEFAULT_NUM_OF_NEIGHBORHOODS = 1;

  // Constructors

  /**
   * 
   * Constructor of a city
   * Constructs a new city with name, specified establishment date, x y coordinates of city center, x y coordinates of central station, number of residents (non negative, if negative will be set to 0), number of neighborhoods (positive, if less than 1 will be set to 1.)
   * 
   * Params:
   * @param cityName - The city's name
   * @param day - The day the city was established
   * @param month - The month the city was established
   * @param year -  The year the city was established
   * @param cityCenterX - The x coordinate of the city's center
   * @param cityCenterY - The y coordinate of the city's center
   * @param centralStationX - The x coordinate of the city's central station
   * @param centralStationY - The y coordinate of the city's central station
   * @param numOfResidents - number of residents
   * @param noOfNeighborhoods - number of neighborhoods
   */
  public City(String cityName, int day, int month, int year, int cityCenterX, int cityCenterY, int centralStationX, int centralStationY, int numOfResidents, int noOfNeighborhoods) {
    _cityName = cityName;
    _dateEstablished = new Date(day, month, year);
    _cityCenter = new Point(cityCenterX, cityCenterY);
    _centralStation = new Point(centralStationX, centralStationY);
    _numOfResidents = ( (numOfResidents < DEFAULT_NUM_OF_RESIDENTS) ? DEFAULT_NUM_OF_RESIDENTS : numOfResidents );
    _noOfNeighborhoods = ( (noOfNeighborhoods < DEFAULT_NUM_OF_NEIGHBORHOODS) ? DEFAULT_NUM_OF_NEIGHBORHOODS : noOfNeighborhoods );
  }
  /**
   * Copy constructor for cities
   * Construct a city with the same attributes as another city.
   * 
   * Params:
   * @param other - The City object from which to construct the new city.
   */
  public City(City other) {
    _cityName = other._cityName;
    _dateEstablished = other._dateEstablished;
    _cityCenter = other._cityCenter;
    _centralStation = other._centralStation;
    _numOfResidents = other._numOfResidents;
    _noOfNeighborhoods = other._noOfNeighborhoods;
  }

  // Methods

  // Returns the city's name.
  public String getCityName() {
    return _cityName;
  }

  // Returns a Date object that represents the city's established Date.
  public Date getDateEstablished() {
    return _dateEstablished;
  }

  // Returns a Point object representing the city's center.
  public Point getCityCenter() {
    return _cityCenter;
  }

  // Returns a Point object representing the city's central station.
  public Point getCentralStation() {
    return _centralStation;
  }

  // Returns the number of residents in this city.
  public long getNumOfResidents() {
    return _numOfResidents;
  }

  // Returns the number of neighborhoods in this city.
  public int getNumOfNeighborhoods() {
    return _noOfNeighborhoods;
  }

  /**
   * 
   * Changes the city's name.
   * 
   * Params:
   * @param cityName
   */
  public void setCityName(String cityName) {
    _cityName = cityName;
  }

  /**
   * Changes the city's established date.
   * 
   * Params:
   * @param dateEst
   */
  public void setDateEstablished (Date dateEst) {
    _dateEstablished = new Date(dateEst);
  }

  /**
   * Changes the city's center location.
   * 
   * Params:
   * @param cityCenter
   */
  public void setCityCenter(Point cityCenter) {
    _cityCenter = new Point(cityCenter);
  }

  /**
   * Changes the city's central station location.
   * 
   * Params:
   * @param centralStation
   */
  public void setCentralStation(Point centralStation) {
    _centralStation = new Point(centralStation);
  }

  /**
   * Changes the city's number of residents. If a negative number is received, number of residents should not be changed.
   * 
   * Params:
   * @param numOfResidents
   */
  public void setNumOfResidents(long numOfResidents) {
    _numOfResidents = ( (numOfResidents < DEFAULT_NUM_OF_RESIDENTS) ? DEFAULT_NUM_OF_RESIDENTS : numOfResidents );
  }

  /**
   * Changes the city's number of neighborhoods. If a non positive number is received, number of neighborhoods should not be changed.
   * 
   * Params:
   * @param numOfNeighborhoods
   */
  public void setNumOfNeighborhoods(int numOfNeighborhoods) {
    _noOfNeighborhoods = ( (numOfNeighborhoods < DEFAULT_NUM_OF_NEIGHBORHOODS) ? DEFAULT_NUM_OF_NEIGHBORHOODS : numOfNeighborhoods );
  }

  // Return a string representation of this city.
  public String toString() {
    return 
    "City name: " + _cityName + "\n" +
    "Date established: " + _dateEstablished + "\n" +
    "City center: " + _cityCenter + "\n" +
    "Central station: " + _centralStation + "\n" +
    "Number of residents: " + _numOfResidents + "\n" +
    "Number of neighborhoods: " + _noOfNeighborhoods + "\n";
  }

  /**
   * Check if two cities are the same (checking all six instace variables)
   * Returns true if the cities are the same
   * 
   * Params:
   * @param other
   */
  public boolean equals(City other) {
    return
    _cityName.equals(other._cityName) &&
    _dateEstablished.equals(other._dateEstablished) &&
    _cityCenter.equals(other._cityCenter) &&
    _centralStation.equals(other._centralStation) &&
    _numOfResidents == (other._numOfResidents) &&
    _noOfNeighborhoods == (other._noOfNeighborhoods);
  }

  /**
   * Add or subtract residents to this city. If number of residents becomes negative, set to zero and return false, otherwise set to new number and return true.
   * Returns True if new number of residents is calculated as non negative
   * 
   * Params:
   * @param residentsUpdate - The change in the number of residents
   * @return
   */
  public boolean addResidents(long residentsUpdate) {
    if (_numOfResidents + residentsUpdate < DEFAULT_NUM_OF_RESIDENTS) {
      _numOfResidents = DEFAULT_NUM_OF_RESIDENTS;
      return false;
    } else {
      _numOfResidents += residentsUpdate;
      return true;
    }
  }

  /**
   * Move the central station location. If the new coordinates are not in the first quadrant, the location will not be changed.
   * 
   * Params:
   * @param deltaX - The change in the station's x location
   * @param deltaY - The change in the station's y location
   */
  public void moveCentralStation(int deltaX, int deltaY) {
    _centralStation.move(deltaX, deltaY);
  }

  //Calculate the distance between the city center and the central station.
  public double distanceBetweenCenterAndStation() {
    return _cityCenter.distance(_centralStation);
  }

  /**
   * Returns a new city with a new name, established date which is a day after this city and a City center location dX and dY away from this city, with 0 residents and 1 neighborhood
   * If the new location of the city center or of the central station is not in the first quadrant, the locations will be the same as this city's locations.
   * 
   * Returns a new city
   * 
   * Params:
   * @param newCityName -  the new city's name
   * @param dX - the x difference from this city's location
   * @param dY - the y difference from this city's location
   * @return
   */
  public City newCity(String newCityName, int dX, int dY) {
    City newCity = new City(this);

    _cityCenter.move(dX, dY);
    _centralStation.move(dX, dY);

    newCity.setCityName(newCityName);
    newCity.setDateEstablished(_dateEstablished.tomorrow());
    newCity.setCityCenter(new Point(_cityCenter));
    newCity.setCentralStation(new Point(_centralStation));
    newCity.setNumOfResidents(DEFAULT_NUM_OF_RESIDENTS);
    newCity.setNumOfNeighborhoods(DEFAULT_NUM_OF_NEIGHBORHOODS);

    return newCity;
  }

  /**
   * Check if the city establish date is between two given dates (including these dates). the given dates are not necessarily in order
   * 
   * Returns true if the city establish date is between the two given dates
   * 
   * Params:
   * @param date1 - the first given date
   * @param date2 - the second given date
   * @return
   */
  public boolean cityEstablishedBetweenDates(Date date1, Date date2) {
    if (_dateEstablished.before(date1) && _dateEstablished.after(date2)) {
      return true;
    } else if (_dateEstablished.before(date2) && _dateEstablished.after(date1)) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * This method calculates the difference in days between the establishment date of this city and the city given as a parameter
   * 
   * Params:
   * @param other - the city given as a parameter to find the difference
   * @return
   */
  public int establishmentDateDiff(City other) {
    return _dateEstablished.difference(other._dateEstablished);
  }
}
