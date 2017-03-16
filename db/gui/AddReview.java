package db.gui;
import java.util.ArrayList;
import java.util.Scanner;

public class AddReview {

  // Returns an ArrayList with all fields a Review holds,
  // back to Menu
  //
  public ArrayList<String> addReview(int nr) {
  //  int id_review;
    int id_movie  = nr;
    int score     = -1;
    String author = "";
    String review = "";

    Scanner sc = new Scanner(System.in);
    // revList skapas med 5 'platser', för att kunna skickas till Review class
    ArrayList<String> revList = new ArrayList<String>(4);
    revList.add(Integer.toString(id_movie));
    revList.add(Integer.toString(score));
    revList.add(author);
    revList.add(review);

    //System.out.println("revList: " + revList);

    System.out.print("\nYour name: ");
    author = sc.nextLine();
    while (author.equals("")) {
      System.out.print("\nYou must enter a name (it doesn´t have to be your real name): ");
      author = sc.nextLine();
    }
    revList.set(3, author);
    //System.out.println("revList: " + revList);

    System.out.print("\nYour review: ");
    review = sc.nextLine();
    revList.set(2, review);
    //System.out.println("revList: " + revList);

    System.out.print("\nYour score [0-10]: ");
    
    do {
      while (!sc.hasNextInt()) {
        sc.next();
        System.out.print("\nInvalid input! ");
        System.out.print("Please enter a number from 0-10: ");
      }
      score = sc.nextInt();

      if (!(score >= 0 && score <= 10)) {
        System.out.print("\nInvalid input! ");
        System.out.print("Please enter a number from 0-10: ");
      }
    } while (!(score >= 0 && score <= 10 ));

//    String strScore = toString(score);
    String strScore = Integer.toString(score);
    revList.set(1, strScore);
//    System.out.println("revList: " + revList);
    System.out.println("\nName:     " + revList.get(3));
    System.out.println("Review:   " + revList.get(2));
    System.out.println("Score:    " + revList.get(1));
    return revList;
  }
}
