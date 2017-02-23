package db.gui;

import db.app.Movie;
import db.app.MovieSQL;
import db.app.FaceMovieDB;

import db.gui.AddCharacter;
import db.gui.AddReview;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Menu {

  private boolean exit;
  private Scanner sc = new Scanner(System.in);
  private ArrayList<String> addMovieList = new ArrayList<String>();
  FaceMovieDB db = new MovieSQL();
  private AddCharacter addChar = new AddCharacter();

//-----------------------------//
  public void runMenu() {
      while(!exit) {
        printMenu();
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
      case 1:
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
  public int loginMenuInput() {
//    Scanner sc2 = new Scanner(System.in);
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
    System.out.println("\n3. Add reviews/score");
    System.out.println("\n4. Help/about Clutch-MDb");
    System.out.println("\n5. Back to login");
    System.out.println("\n6. -- exit -- ");
  }
//--------------------------------------//
  public int menuInput() {
  //  Scanner sc = new Scanner(System.in);
    int menuChoice = -1;
    while (menuChoice < 0 || menuChoice > 6) {
      try {
        System.out.print("\nEnter your selection: ");
        menuChoice = Integer.parseInt(sc.nextLine());
      } catch (NumberFormatException e) {
        System.out.println("\nInvalid input! Try again...");
        }
    } return menuChoice;
  }
//----------------------------------------------//
  public void performSelection(int menuChoice) {
    AddMovie addmovie = new AddMovie();
    AddReview review = new AddReview();

    List<Movie> movieListFullData = db.getAllMoviesFullData();
    List<String> movieListByName = new ArrayList<String>();
    switch(menuChoice) {

      case 1: // list movies
      movieListByName = db.getAllMoviesByTitle();
    //  System.out.println("All movies listed so far: \n" + movieListByName);
      System.out.println("\nAll movies listed so far:");

      System.out.println("ID  Movie\n-----------------");
      int counter = 1;
      for (Movie m : movieListFullData) {
        System.out.println(m.id_movie() + "   " + m.title());
        System.out.println("\nID  Movie");
        counter = counter + 1;
      }
      System.out.println("------------End of List-----------------");
      break;

      case 2: // add movie
        addMovieList = addmovie.addMovie();
//        System.out.println(addMovieList +" : " + addMovieList.size());
        Movie m = new Movie(addMovieList);
        System.out.println("\n" + m);
        db.addMovie(m);
//        List<Movie>  movieList = db.getAllMovies();

        addChar.askForCharacter();
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

      case 3: // add revieew/ score
    //    review.addReview();
        break;

      case 4: // help/ about
        helpMenu();
        break;

      case 5: // back to login
        runLoginMenu();
        break;

      case 6: // quick exit
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
