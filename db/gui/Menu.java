package db.gui;
import db.utils.Utils;

import db.app.Movie;
import db.gui.AddMovie;
import db.app.MovieSQL;
import db.app.FaceMovieDB;

import db.app.Review;
import db.gui.AddReview;
import db.app.ReviewSQL;
import db.app.FaceReviewDB;

//import db.app.Actor;
//import db.gui.AddActor;
//import db.gui.ActorSQL;

import db.app.MovieActor;
import db.app.MovieActorSQL;
import db.app.FaceMovieActorDB;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Menu {

  private boolean exit;
  private Scanner sc = new Scanner(System.in);
  private ArrayList<String> addMovieList = new ArrayList<String>();
  private ArrayList<String> addReviewList = new ArrayList<String>();
  private ArrayList<MovieActor> actList = new ArrayList<MovieActor>();

  FaceMovieDB mdb = new MovieSQL();
  FaceReviewDB rdb = new ReviewSQL();
  // FaceMovieActorDB adb = new MovieActorSQL();

  //AddActor addAct = new AddActor();

  private String enterSelection = "\nEnter your selection: ";
  private String invalidInput = "\nInvalid input! Try again...";
//-----------------------------//
//-----------------------------//
  public void runMenu() {
    System.out.println("runMenu: ");
    printMenu();
      while(!exit) {
        int menuChoice = menuInput();
        performSelection(menuChoice);
      }
  }
//-----------------------------//
/*
runLoginMenu
  printHeader
  printLoginMenu
performLoginSelection
runMenu
  printmenu
performSelection
*/
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

//Login guest, admin, exit
  public int loginMenuInput() {
    int loginChoice = -1;
    while (loginChoice < 0 || loginChoice > 3) {
      try {
        System.out.print(enterSelection);
        loginChoice = Integer.parseInt(sc.nextLine());
      } catch (NumberFormatException e) {
        System.out.println(invalidInput);
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
    System.out.println("\n3. List Actors");
    System.out.println("\n4. Help/about Clutch-MDb");
    System.out.println("\n5. Back to login");
    System.out.println("\n6. -- Exit -- ");
  }
//--------------------------------------//
  public int menuInput() {
    int menuChoice = -1;
    while (menuChoice < 0 || menuChoice > 7) {
      try {
//        printMenu();
        menuChoice = Integer.parseInt(sc.nextLine());
      } catch (NumberFormatException e) {
        System.out.println(invalidInput);
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
        System.out.println(invalidInput);
      }
    }
    //System.out.println("choice: " + choice);
    return choice;
  }
// nr är id på filmen som ska visas
//  private void showMovie(List<Movie> mList, int counter)
  private void showMovie(List<Movie> mList) {
    AddReview addReview = new AddReview();
    ArrayList<String> newReview;
    List<Review> revList;

    AddActor addAct = new AddActor();
    ArrayList<String> newAct;
    List<MovieActor> actList;

    int movieNr = -1;
    boolean b = true;

    while (b) {
      try {
        System.out.print("\nEnter a movie number: ");
        movieNr = Integer.parseInt(sc.nextLine());

        for (Movie m : mList) {
          if (movieNr == m.id_movie()) {
            System.out.println(m);
            revList = rdb.getByMovieID(movieNr);
            System.out.println("\nScore:     Author:     Review:");
            for (Review r : revList) {
              System.out.println(r.score() + "          " + "/" + r.author() + "     " + r.review());
            }
  /*          int counter = 1;
            actList = adb.getByMovieID(movieNr);
            System.out.println("\nActors:");
            for (MovieActor ma : actList) {
              if (movieNr == ma.id_movie) {
                System.out.println(counter +  ". " + a.character() + " - " + a.name());
                counter ++;
              }
            }
            System.out.println();*/
            b = false;
          }
        }
      } catch (NumberFormatException e) {
        System.out.println("\nInvalid input! Try again...");
      }
    }
    // add review or actor. stay in this loop until 3 is entered
    b = true;
    while (b) {
      System.out.println("\n1. Add review");
      System.out.println("2. Add actor");
      System.out.println("3. Back");
      int menuChoice = mChoice(3);

      switch(menuChoice) {
        case 1: // add Review
          newReview = addReview.addReview(movieNr);
          Review r = new Review(newReview);
  //      System.out.println("\nr: " + r);
          rdb.addReview(r);
          break;
        case 2: // add actor
          newAct = addAct.addActor();

          // Actor a = new Actor(newAct); Actor får ett internt nr
          // adb.addActor(a, movieNr) koppla actor med movie
          //  showActor(movieNr);
          break;
        case 3:
          b = false;
//          printMenu();
          break;
        }
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

    // get an actor list
    // adb = adb.getAllActorsByName();
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
        System.out.println("");
      }
      System.out.println("------------End of List-----------------");
//      showMovie(movieListFullData, counter);
      showMovie(movieListFullData);
      printMenu();
      break;

      case 2: // add movie
        addMovieList = addMovie.addMovie();
        Movie m = new Movie(addMovieList);
        System.out.println("\n" + m);
        mdb.addMovie(m);
        break;

      case 3: // List actors
/*        maList = addReview();

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
        printMenu();
        break;

/*      case 3: // add revieew/ score
        addReviewList = addReview.addReview();
        Review r = new Review(addReviewList);
        System.out.println("\n" + r);
        db.addReview(r);
        break; */

      case 4: // help/ about
        helpMenu();
        printMenu();
        break;

      case 5: // back to login
        runLoginMenu();
        break;

      case 6: // quick exit
        System.exit(0);
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
