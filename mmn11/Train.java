import java.util.Scanner;

public class Train {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    // Ask the user to enter the speed and time of train 1
    System.out.println("Please enter 4 integers ");
    System.out.println("Please enter the speed of train 1:");
    double v1 = scan.nextDouble();
    System.out.println("Please enter the time of train 1:");
    double t1 = scan.nextDouble() / 60;

    // Ask the user to enter the speed and time of train 1
    System.out.println("Please enter the speed of train 2:");
    double v2 = scan.nextDouble();
    System.out.println("Please enter the time of train 2:");
    double t2 = scan.nextDouble() / 60;

    // Calculate the distance of each train
    double t1_dist = v1 * t1;
    double t2_dist = v2 * t2;

    // Calculate the distance
    double distance = Math.abs(t1_dist - t2_dist);
    // print the distance between the trains
    System.out.println("The distance between the trains is " + distance + " km");
  } // end of method main
} // end of class Train
