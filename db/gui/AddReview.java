package db.gui;
import java.util.ArrayList;
import java.util.Scanner;

public class AddReview {

  public ArrayList<String> addReview(int nr) {
  //  int id_review;
    int id_movie = nr;
    int score = -1;
    String author = "";
    String review = "";

    Scanner sc = new Scanner(System.in);
    // revList skapas med 5 'platser', för att kunna skickas till Review class
    ArrayList<String> revList = new ArrayList<String>(4);
    revList.add(Integer.toString(id_movie));
    revList.add(Integer.toString(score));
    revList.add(author);
    revList.add(review);

    System.out.println("revList: " + revList);

    System.out.println("\n ------------");
    System.out.println("|Add a review|");
    System.out.println(" ------------");

    System.out.println("\nYour review: ");
    review = sc.nextLine();
    revList.set(3, review);
    System.out.println("revList: " + revList);

    System.out.println("\nYour name: ");
    author = sc.nextLine();
    revList.set(2, author);
    System.out.println("revList: " + revList);

    System.out.println("\nYour score /10: ");
    score = sc.nextInt();
    while (score < 0 || score > 10) {
      System.out.println("\nInvalid score, choose a number from 0 to 10!");
      System.out.println("\nYour score /10: ");
      score = sc.nextInt();
    }
//    String strScore = toString(score);
    String strScore = Integer.toString(score);
    revList.set(1, strScore);
    System.out.println("revList: " + revList);

    return revList;
  }
}
