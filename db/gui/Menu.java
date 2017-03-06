package db.gui;

import db.app.Movie;
import db.app.MovieSQL;
import db.app.FaceMovieDB;

import db.app.Review;
import db.app.ReviewSQL;
import db.app.FaceReviewDB;

import db.gui.AddMovie;
import db.gui.AddActor;
import db.gui.AddReview;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Menu {

  private boolean exit;
  private Scanner sc = new Scanner(System.in);
  private ArrayList<String> addMovieList = new ArrayList<String>();
  private ArrayList<String> addReviewList = new ArrayList<String>();

  FaceMovieDB mdb = new MovieSQL();
  private AddActor addActor = new AddActor();

  FaceReviewDB rdb = new ReviewSQL();

  private String enterSelection = "\nEnter your selection: ";
  private String invalidInput = "\nInvalid input! Try again...";
//-----------------------------//
  public void runMenu() {
    printMenu();
      while(!exit) {
    //    printMenu();
        int menuChoice = menuInput();
        performSelection(menuChoice);
      }
  }
//-----------------------------//
  public void runLoginMenu() {
    printHeader();
    while(!exit) {
      printLoginMenu();
      int loginChoice = loginMenuInput();
      performLoginSelection(loginChoice);
    }
  }
//---------------------------//
  public void printHeader() {
    System.out.println("\n|-----------------------------------------|");
    System.out.println("|-------------                ------------|");
    System.out.println("|------         |Clutch-MDb|        ------|");
    System.out.println("|-------------                ------------|");
    System.out.println("|-----------------------------------------|");
  }
//------------------------//
  public void performLoginSelection(int loginChoice) {
    switch(loginChoice) {
      case 1: // guest
        System.out.println("\nUnder developement...");
        break;
      case 2:
        runMenu();
        break;
      case 3:
        exit = true;
        break;
        default:
      System.out.println("\nAn unknown error has occured.");
    }
  }
//---------------------//
/*
* Login guest, admin, exit
*/
  public int loginMenuInput() {
    int loginChoice = -1;
    while (loginChoice < 0 || loginChoice > 3) {
      try {
        System.out.print("\nEnter your selection: ");
        loginChoice = Integer.parseInt(sc.nextLine());
      } catch (NumberFormatException e) {
        System.out.println("\nInvalid input! Try again...");
        }
    } return loginChoice;
  }
//-------------------------------------//
  public void printLoginMenu() {
    System.out.println("\n 1. Guest        2. Admin          3. Exit");
  }
//-------------------------------------//
  public void printMenu() {
    System.out.println("\n1. List movies");
    System.out.println("\n2. Add movies");
    System.out.println("\n3. Help/about Clutch-MDb");
    System.out.println("\n4. Back to login");
    System.out.println("\n5. -- exit -- ");
  }
//--------------------------------------//
  public int menuInput() {
    int menuChoice = -1;
    while (menuChoice < 0 || menuChoice > 6) {
      try {
        printMenu();
        System.out.print("\nEnter your selection: ");
        menuChoice = Integer.parseInt(sc.nextLine());
      } catch (NumberFormatException e) {
        System.out.println("\nInvalid input! Try again...");
        }
    } return menuChoice;
  }
//----------------------------------------------//
/*
* max är antalet alternativ som listats*/
  private int mChoice(int max) {
    int choice = -1;
    while (choice < 0 || choice > max + 1 ) {
      try {
        System.out.print(enterSelection);
        choice = Integer.parseInt(sc.nextLine());
      } catch (NumberFormatException nfe) {
        System.out.println("\n" + invalidInput);
      }
    }
    //System.out.println("choice: " + choice);
    return choice;
  }
// nr är id på filmen som ska visas
  private void showMovie(List<Movie> mList) {
    AddReview addReview = new AddReview();
    ArrayList<String> newReview;
    List<Review> revList;
    int nr = -1;
    boolean b = true;
    while (b) {
      try {
        System.out.print("\nEnter a movie number: ");
        nr = Integer.parseInt(sc.nextLine());

        for (Movie m : mList) {
          if (nr == m.id_movie()) {
            revList = rdb.getByMovieID(nr);
            System.out.println(m);
            System.out.println("\nScore:  Review:  Author:");
            for (Review r : revList) {
              System.out.println(r.score() + "   " + r.review() + "   " + r.author());
            }

            b = false;
          }
        }
      } catch (NumberFormatException e) {
        System.out.println("\nInvalid input! Try again...");
      }
    }

    System.out.println("\n1. Add review");
    System.out.println("2. Back");
    int menuChoice = mChoice(2);
    switch(menuChoice) {
    case 1:
      newReview = addReview.addReview(nr);
  //    System.out.println("newReview: " + newReview + " + nr: " + nr);
      Review r = new Review(newReview);
  //    System.out.println("\nr: " + r);
       rdb.addReview(r);
      break;
    case 2:
      break;
    }
  }
//----------------------------------------------//
  public void performSelection(int menuChoice) {
    AddMovie addMovie = new AddMovie();
    List<Movie> movieListFullData = mdb.getAllMoviesFullData();
    List<String> movieListByName = new ArrayList<String>();
    List<String> movieListByMovieID = new ArrayList<String>();

    AddReview addRev = new AddReview();
    List<Review> reviewListFullData = rdb.getAllReviewsFullData();

    switch(menuChoice) {
      case 1: // list movies
      movieListByName = mdb.getAllMoviesByTitle();
      System.out.println("\nAll movies listed so far:");
      System.out.println("ID  Movie\n-----------------");
      int counter = 1;
      for (Movie m : movieListFullData) {
        System.out.print(m.id_movie() + "   " + m.title());
  //      System.out.println("\nID  Movie");
        counter = counter + 1;
        System.out.println(", counter: " + counter);
      }
      System.out.println("------------End of List-----------------");

/*      System.out.println(enterSelection);
      String movieSelection = sc.nextLine();
      showMovie(movieSelection, movieListFullData);*/
      showMovie(movieListFullData);
      break;

      case 2: // add movie
        addMovieList = addMovie.addMovie();
        Movie m = new Movie(addMovieList);
        System.out.println("\n" + m);
        mdb.addMovie(m);
        AddActor ac = new AddActor();
        ac.askForActor();
//        List<Movie>  movieList = mdb.getAllMovies();

/*        addReviewList = addReview.addReview();
        Review r = new Review(addReviewList)
        System.out.println("\n" + r);
        mdb.addReview(r); */


//        addChar.askForCharacter();
  //      boolean newCharQuestion = addChar.newChar();
        /*
        Boolean newCharQuestion = false;
        while(addChar.newChar) {
        characterData = addCharacter.askForCharacter();
        Character c = new Character(characterData);
        db.addChar(c);
      }
        */
        break;

/*      case 3: // add revieew/ score
        addReviewList = addReview.addReview();
        Review r = new Review(addReviewList);
        System.out.println("\n" + r);
        db.addReview(r);
        break; */

      case 3: // help/ about
        helpMenu();
        break;

      case 4: // back to login
        runLoginMenu();
        break;

      case 5: // quick exit
        System.exit(1);
        break;
      default:
        System.out.println("An unknown error has occured.");
    }
  }
//--------------------------------//
  public void helpMenu() {
    System.out.println("\nThis is Clutch-MDb, a textbased movie database...");
    System.out.println("\nEst feugiat habitasse arcu commodo augue interdum Facilisis pharetra tortor habitasse feugiat praesent suscipit rutrum \nSodales sociosqu facilisis tempus metus Magna congue per quis vehicula Porttitor etiam tristique massa et dapibus amet \nlorem molestie Sociosqu Curae dolor amet nulla id diam donec ut auctor, imperdiet vehicula Maecenas tellus purus nam \nporta ligula fusce donec varius, tristique.");
  }
//--------------------------------//
}
