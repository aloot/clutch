/*
-- Föreslår att vi döper om detta till addReview, om det är vad som händer.
*/
package db.gui;
import java.util.Scanner;

public class Review{

  public void addReview() {
  String name;
  String score;
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
  score = sc.nextLine();

  }
}
