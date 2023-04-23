import java.util.Scanner;

public class Traingle {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    // Ask the user to enter 3 numbers
    System.out.println("Please enter 3 integers ");
    System.out.println("Please enter the length of side 1:");
    int side1 = scan.nextInt();
    System.out.println("Please enter the length of side 2:");
    int side2 = scan.nextInt();
    System.out.println("Please enter the length of side 3:");
    int side3 = scan.nextInt();

    // Set variable for the triangle type
    String triangleType = "";

    // Check if the user inputs represent a triangle
    if (side1 + side2 > side3 && side1 + side3 > side2 && side2 + side3 > side1) {
      // check if the triangle is equilateral
      if (side1 == side2 && side2 == side3) {
        triangleType = "equilateral";
      }
      // check if the triangle is isosceles
      else if (side1 == side2 || side1 == side3 || side2 == side3) {
        triangleType = "isosceles";
      }
      // check if the triangle is right-angle
      else if (side1 * side1 + side2 * side2 == side3 * side3 || side1 * side1 + side3 * side3 == side2 * side2 || side2 * side2 + side3 * side3 == side1 * side1) {
        triangleType = "right-angle";
      }
      // else, it is a common triangle
      else {
        triangleType = "common";
      }
      System.out.println("The numbers: " + side1 + ", " + side2 + " and " + side3 + " represent a " + triangleType + " triangle");
    }
    // if the user inputs do not represent a triangle
    else {
      System.out.println("The numbers: " + side1 + ", " + side2 + " and " + side3 + " cannot represent a triangle");
    }
  } // end of method main
} // end of class Traingle
