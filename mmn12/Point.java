/**
 * Class Point
 * Public class Point
 * This class represents 2 dimensional point. Coordinates cannot be negative.
 */

public class Point {
  // Instance vars
  private int _x;
  private int _y;

  // Final vars
  private final int MIN_POINT_X = 0;
  private final int MIN_POINT_Y = 0;

  // Constructor

  /**
   * 
   * Constructs a point. 
   * Construct a new point with the specified x y coordinates. If either coordinate is negative the coordinate will be 0.
   * 
   * Params:
   * @param x - The x coordinate
   * @param y - The y coordinate
   */
  public Point(int x, int y) {
    _x = Math.max(x, MIN_POINT_X);
    _y = Math.max(y, MIN_POINT_Y);
  }

  /**
   * Copy constructor for Point
   * Construct a point with the same coordinates as another point.
   * 
   * Params:
   * @param other - The point object from which to construct the new point
   */
  public Point(Point other) {
    _x = other._x;
    _y = other._y;
  }

  // Returns the x coordinate of the point.
  public int getX() {
    return _x;
  }

  // Returns the y coordinate of the point.
  public int getY() {
    return _y;
  }

  /**
   * Changes the x coordinate of the point.
   * If a negative number is received, the x coordinate will not be changed.
   * 
   * Params:
   * @param num - The new x coordinate
   */
  public void setX(int num) {
    if ( num >= MIN_POINT_X ) {
      _x = num;
    }
  }

  /**
   * Changes the y coordinate of the point.
   * If a negative number is received, the y coordinate will not be changed.
   * 
   * Params:
   * @param num - The new y coordinate
   */
  public void setY(int num) {
    if ( num >= MIN_POINT_Y ) {
      _y = num;
    }
  }

  // Check if the received point is equal to this point.
  public boolean equals(Point other) {
    return ( (_x == other.getX()) && (_y == other.getY()) );
  }

  // Check if this point is above a received point.
  public boolean isAbove(Point other) {
    return (_y > other.getY());
  }

  // Check if this point is below a received point.
  public boolean isUnder(Point other) {
    return !(isAbove(other));
  }

  // Check if this point is left of a received point.
  public boolean isLeft(Point other) {
    return (_x < other.getX());
  }

  // Check if this point is right of a received point.
  public boolean isRight(Point other) {
    return !(isLeft(other));
  }

  // Check the distance between this point and a received point.
  public double distance(Point p) {
    return Math.sqrt( Math.pow(_x - p._x,  2) + Math.pow(_y - p._y, 2) );
  }

  /**
   * Move the x coordinate deltaX and the y coordinate deltaY.
   * If the new coordinates are not in the first quadrant the point should not be moved.
   * 
   * Params:
   * @param deltaX - The amount to move x
   * @param deltaY - The amount to move y
   */
  public void move(int deltaX, int deltaY) {
    if ( (_x + deltaX) > MIN_POINT_X && (_y + deltaY) > MIN_POINT_Y) {
      setX(_x + deltaX);
      setY(_y + deltaY);
    }
  }

  // Return a new point in between this point and the received point.
  public Point middle(Point p) {
    int midX = (_x + p._x) / 2;
    int midY = (_y + p._y) / 2;
    return new Point(midX, midY);
  }

  // Return a string representation of this point.
  public String toString() {
    return String.format("(%1$s,%2$s)", _x, _y);
  }
}
