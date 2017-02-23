package db.gui;
import java.util.Scanner;

public class AddReview{

  public void addReview() {
    String name;
    int score;
    String review;
    Scanner sc = new Scanner(System.in);

    System.out.println("\n ------------");
    System.out.println("|Add a review|");
    System.out.println(" ------------");
    System.out.println("\nYour name: ");
    name = sc.nextLine();
    System.out.println("\nYour review: ");
    review = sc.nextLine();
    System.out.println("\nYour score /10: ");
    score = sc.nextInt();
    while (score < 0 || score > 10) {
      System.out.println("\nInvalid score, choose a number from 0 to 10!");
      System.out.println("\nYour score /10: ");
      score = sc.nextInt();
    }
  }
}
