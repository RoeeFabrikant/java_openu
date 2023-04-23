/**
 * Class Date
 * 
 * This class represents a Date object
 */

public class Date {

  // Instance vars
  private int _day;
  private int _month;
  private int _year;

  // final vars
  private final int DEFAULT_DAY = 1;
  private final int DEFAULT_MONTH = 1;
  private final int DEFAULT_YEAR = 2000;
  private final int DEFAULT_MONTH_DAYS = 31;
  private final int DEFAULT_SHORT_MONTH_DAYS = 30;
  private final int DEFAULT_MONTH_DAYS_FEB = 28;
  private final int DEFAULT_FIRST_DAY = 1;
  private final int DEFAULT_FIRST_MONTH = 1;
  private final int DEFAULT_LAST_MONTH = 12;
  private final int DEFAULT_FIRST_YEAR = 1000;
  private final int DEFAULT_LAST_YEAR = 9999;
  private final int FEB = 2;
  private final int APRIL = 4;
  private final int JUNE = 6;
  private final int SEPT = 9;
  private final int NOV = 11;

  // Constructors

  /**
   * Constructor of date
   * If the given date is valid - creates a new Date object, otherwise creates the date 1/1/2000
   * 
   * Params:
   * @param day - the day in the month (1-31)
   * @param month - the month in the year (1-12)
   * @param year - the year (4 digits)
   */
  public Date(int day, int month, int year) {
    if (isDateValid(day, month, year)) {
      _day = day;
      _month = month;
      _year = year;
    } else {
      _day = DEFAULT_DAY;
      _month = DEFAULT_MONTH;
      _year = DEFAULT_YEAR;
    }
  }

  /**
   * Copy constructor for Date
   * 
   * Params:
   * @param other - the date to be copied
   */
  public Date(Date other){
    _day = other._day;
    _month = other._month;
    _year = other._year;
  }

  // Methods

  // Gets the day
  public int getDay() {
    return _day;
  }

  // Gets the month
  public int getMonth() {
    return _month;
  }

  // Gets the year
  public int getYear() {
    return _year;
  }

  // Set the day (only if date remains valid)
  public void setDay(int dayToSet) {
    if (isDateValid(dayToSet, _month, _year)) {
      _day = dayToSet;
    }
  }

  // Set the month (only if date remains valid)
  public void setMonth(int monthToSet) {
    if (isDateValid(_day, monthToSet, _year)) {
      _month = monthToSet;
    }
  }

  // Set the day (only if date remains valid)
  public void setYear(int yearToSet) {
    if (isDateValid(_day, _month, yearToSet)) {
      _year = yearToSet;
    }
  }

  // Check if two dates are the same
  public boolean equals(Date other) {
    return (other._day == _day && other._month == _month && other._year == _year);
  }

  // Check if this date is before other date
  public boolean before(Date other) {
    if (_year < other._year) {
      return true;
    } else if (_year == other._year) {
      if (_month < other._month) {
        return true;
      } else if (_month == other._month && _day < other._day) {
        return true;
      }
    }
    return false;
  }

  // Check if this date is after other date
  public boolean after(Date other) {
    return (other.before(this));
  }

  // computes the day number since the beginning of the Christian counting of years 
  private int calculateDate( int day, int month, int year) {
    if (month < 3) { 
      year--;
      month = month + 12;
    }
    return 365 * year + year/4 - year/100 + year/400 + ((month+1) * 306)/10 + (day - 62);
  }

  // Calculates the difference in days between this date and other date
  public int difference (Date other) {
    return Math.abs( calculateDate( _day, _month, _year) - calculateDate( other._day, other._month, other._year) );
  }

  // Returns a String that represents this date
  public String toString() {
    String sDay = ( (_day < 10) ? "0" + _day : "" + _day );
    String sMonth = ( (_month < 10) ? "0" + _month : "" + _month );
    String sYear = "" + _year;
    
    return String.format("%1$s/%2$s/%3$s", sDay, sMonth, sYear);
  }

  // Calculate the date of tomorrow
  public Date tomorrow() {
    if ( isDateValid(this._day + 1, this._month, this._year) ) {
      return new Date(this._day + 1, this._month, this._year);
    } else if ( isDateValid(01, this._month + 1, this._year) ) {
      return new Date(DEFAULT_FIRST_DAY, this._month + 1, this._year);
    } else {
      return new Date(DEFAULT_FIRST_DAY, DEFAULT_FIRST_MONTH, this._year + 1 );
    }
  }

  // Check if the given date is valid
  public boolean isDateValid(int day, int month, int year) {
    boolean valid = true;

    // Is the day valid?
    int maxDays = DEFAULT_MONTH_DAYS;
    if (month == APRIL || month == JUNE || month == SEPT || month == NOV) {
      maxDays = DEFAULT_SHORT_MONTH_DAYS;
    } else if (month == FEB) {
      maxDays = DEFAULT_MONTH_DAYS_FEB;
    }

    if (day < DEFAULT_FIRST_DAY || day > maxDays) {
      valid = false;
    }

    // Is the month valid?
    if (month < DEFAULT_FIRST_MONTH || month > DEFAULT_LAST_MONTH) {
      valid = false;
    }

    // is the year valid?
    if (year < DEFAULT_FIRST_YEAR || year > DEFAULT_LAST_YEAR) {
      valid = false;
    }

    return valid;
  }
}
