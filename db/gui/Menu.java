package db.gui;

import db.app.Movie;
import db.gui.AddMovie;
import db.app.MovieSQL;
import db.app.FaceMovieDB;

import db.app.Review;
import db.gui.AddReview;
import db.app.ReviewSQL;
import db.app.FaceReviewDB;

import db.app.Actor;
import db.gui.AddActor;
import db.app.ActorSQL;
import db.app.FaceActorDB;

import db.app.MovieActor;
//import db.app.FaceMovieActorDB;

import db.utils.Utils;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.text.DecimalFormat;

public class Menu {

  private boolean exit;
  private Scanner sc = new Scanner(System.in);
  private ArrayList<String> addMovieList = new ArrayList<String>();
  private ArrayList<String> addReviewList = new ArrayList<String>();

  FaceMovieDB mdb = new MovieSQL();
  FaceReviewDB rdb = new ReviewSQL();
  FaceActorDB adb = new ActorSQL();

  private String enterSelection = "\nEnter your selection: ";
  private String invalidInput = "\nInvalid input! Try again...";
//-----------------------------//
//-----------------------------//
  public void runMenu() {
  //  System.out.println("runMenu: ");
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
        if (loginChoice > 3) {
          System.out.println(invalidInput);
        }
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
    System.out.println("\n2. Add movie");
    System.out.println("\n3. List Actors");
    System.out.println("\n4. Help/about Clutch-MDb");
    System.out.println("\n5. Back to login");
    System.out.println("\n6. -- Exit -- ");
  }
//--------------------------------------//
  public int menuInput() {
    int menuChoice = -1;
    while (menuChoice < 0 || menuChoice > 6) {
      try {
        System.out.print(enterSelection);
        menuChoice = Integer.parseInt(sc.nextLine());
        if (menuChoice < 1 || menuChoice > 6) {
          System.out.println(invalidInput);
        }
      } catch (NumberFormatException e) {
        System.out.println(invalidInput);
      }
    } return menuChoice;
  }

  private int mChoice() {
    int choice = -1;
    while (choice < 0 || choice > 3) {
      try {
        System.out.print(enterSelection);
        choice = Integer.parseInt(sc.nextLine());
        if (choice < 1 || choice > 3) {
          System.out.println(invalidInput);
        }
      } catch (NumberFormatException nfe) {
        System.out.println(invalidInput);
      }
    } return choice;
  }

  private int kbdChoice(int max) {
    int choice = -1;
    while (choice < 0 || choice > max ) {
      try {
        System.out.print(enterSelection);
        choice = Integer.parseInt(sc.nextLine());
      } catch (NumberFormatException nfe) {
        System.out.println(invalidInput);
      }
    }
    return choice;
  }

  private void extendMovieData(List<Movie> mList, int movieNr) {
    AddReview addReview = new AddReview();
    ArrayList<String> newReview;
    AddActor addAct = new AddActor();
    ArrayList<String> newAct;
    ArrayList<String> newMA = new ArrayList<String>();

    boolean b = true;
    while (b) {
      System.out.println("\n1. Add review");
      System.out.println("2. Delete review");
      System.out.println("3. Add actor");
      System.out.println("4. Back");
      int menuChoice = kbdChoice(4);
      switch(menuChoice) {
        case 1: // add Review
          newReview = addReview.addReview(movieNr);
          Review r = new Review(newReview);
          rdb.addReview(r);
          showMovie(mList, movieNr);
          break;
        case 2:
          int revToDelete = -1;
          System.out.println("Enter id of the reveiw you wish to delete, or zero to exit: ");
          revToDelete = Integer.parseInt(sc.nextLine());
          if (revToDelete > 0) {
            if (revToDelete == 0) {
              break;
            } else {
              rdb.deleteReview(revToDelete);
              System.out.println("Review " + revToDelete + " deleted");
            }
          }
          break;

        case 3: // add actor
          newAct = addAct.addActor();
          newMA.add(Integer.toString(movieNr));
          newMA.add("0");
          newMA.add(newAct.get(newAct.size() - 1));
          newAct.remove(newAct.size() - 1);
          Actor a = new Actor(newAct);
          adb.addActor(a);
          newMA.set(1, Integer.toString(a.id_actor()));
//          System.out.println(newMA);
          MovieActor ma = new MovieActor(newMA);
          adb.addMovieActor(ma);
          showMovie(mList, movieNr);

        case 4:
          b = false;
          break;
        }
      }
    }

  private void showMovie(List<Movie> mList, int movieNr) {
    DecimalFormat df1 = new DecimalFormat("#,###,##0.0");
    List<Review> revList;
    ArrayList<Object> oList;
    ArrayList<MovieActor> maList = new ArrayList<MovieActor>();
    ArrayList<Actor> actList = new ArrayList<Actor>();
    for (Movie m : mList) { // hitta rätt film, visa den + dess reviews
      if (movieNr == m.id_movie()) {
        System.out.println(m);
        revList = rdb.getByMovieID(movieNr);
        Integer listSize = revList.size();
        if (listSize > 0) {
          double mScore = 0.00;
          System.out.println("\nID:     Score:   Author:           Review:");
          for (Review r : revList) {
            System.out.println(r.id_review() < 10 ? " " + r.id_review() + " - - - " + r.score() + " - - - " + r.author() + " - - -  - - " + r.review(): r.id_review() + " - - - "  + r.score() + " - - - " +  r.author() + " - - -  - - " + r.review());
            mScore += r.score();
          }
          System.out.println("Average rating: " + df1.format(mScore/listSize));
        } else {
          System.out.println("\nBe the first to rate this movie..! :P");
        }
        // Skriv ut skådisarna
        oList = adb.getActorByIdMovie(movieNr);
        if (oList.size() > 1) {
          for (int i = 0; i < oList.size(); i = i+2) {
            maList.add((MovieActor) oList.get(i));
            actList.add((Actor) oList.get(i+1));
          }
          System.out.println("\nCast:");
          int counter = 1;
          for (int i = 0; i < maList.size(); i ++) {
            System.out.println(counter + ". " + maList.get(i).character() + "  - - - - -  " + actList.get(i).name());
            counter ++;
          }
        } else {
          System.out.println("\nNo actors listed, so far");
        }

      }
    } // end 'for (Movie m : mList)'
  }

  private void getMovieNr(List<Movie> mList, int movieNr) {

    if (movieNr < 1) {
      boolean b = true;
      while (b) { // bara gör detta tills det är dags att backa i menyn...
        try {
          System.out.print("\nEnter a movie number: ");
          movieNr = Integer.parseInt(sc.nextLine());
          for (Movie m : mList) {
          // hitta rätt film, visa den + dess reviews
            if (movieNr == m.id_movie()) {
              showMovie(mList, movieNr);
              extendMovieData(mList, movieNr);
              b = false;
            }
          }
        } catch (NumberFormatException e) {
          System.out.println("\nInvalid input! Try again...");
        }
      }
    }bj
  }

  private void showActor(List<Actor> aList, int actNr) {
    ArrayList<Object> oList;
    ArrayList<Actor> actList = new ArrayList<Actor>();
    ArrayList<MovieActor> maList = new ArrayList<MovieActor>();
    ArrayList<Movie> mList = new ArrayList<Movie>();
    for (Actor a : aList) {
      if (actNr == a.id_actor()) {
        oList = adb.getActorFromId(actNr);
        if (oList.size() > 2) { // get it sorted
          for (int i = 0; i < oList.size(); i = i + 3) {
            actList.add((Actor) oList.get(i));
            maList.add((MovieActor) oList.get(i + 1));
            mList.add((Movie) oList.get(i + 2));
          }
        } // done sorting
        int listSize = maList.size();
        System.out.println(actList.get(0).name() + " is an actor, born " + actList.get(0).birth() + " in " + actList.get(0).nationality());
        System.out.println("S/he has an acting part in: ");
        for (int i = 0; i < maList.size(); i++) {
          System.out.println("\t'" + mList.get(i).title() + "' by " +mList.get(i).director() + ", as " + maList.get(i).character() + (maList.size() - 1 > i ?  "," : ""));
        }
      }
    }
  }

  private void showActorList(List<Actor> aList) {
    boolean b = true;
    int actNr;
    while (b) {
      try {
        System.out.println("\nEnter an actor number: ");
        actNr = Integer.parseInt(sc.nextLine());
        for (Actor a : aList) {
          if (actNr == a.id_actor()){
            showActor(aList, actNr);
            b = false;
          }
        }
      } catch (NumberFormatException e) {
        System.out.println(invalidInput);
      }
    }
  }
//----------------------------------------------//
  public void performSelection(int menuChoice) {
    AddMovie addMovie = new AddMovie();
    List<Movie> mList = mdb.getAllMoviesFullData();

    List<String> movieListByName = new ArrayList<String>();
    List<String> movieListByMovieID = new ArrayList<String>();

    ArrayList<Actor> actorListFullData;
    // get an actor list
    // adb = adb.getAllActorsByName();
    switch(menuChoice) {
      case 1: // list movies
      movieListByName = mdb.getAllMoviesByTitle();
      System.out.println("\nAll movies in database:");
      System.out.println("ID  Movie\n----------------------------------------");
      for (Movie m : mList) {
        System.out.print(m.id_movie() < 10 ? " " + m.id_movie() + "   " + m.title(): m.id_movie() + "   " + m.title());
        System.out.println("");
      }
      System.out.println("------------End of List-----------------");
//      showMovie(mList, counter);
      getMovieNr(mList, -1);
      printMenu();
      break;

      case 2: // add movie
        addMovieList = addMovie.addMovie();
        Movie m = new Movie(addMovieList);
        System.out.println("\n" + m);
        mdb.addMovie(m);
        runMenu();
        break;

      case 3: // List all actors
        actorListFullData = adb.getAllActorsFullData();
        System.out.println("\nAll actors so far:");
        System.out.println("ID  Actor\n----------------------------------------");
        for (Actor a : actorListFullData) {
          System.out.println(a.id_actor() < 10 ? " " + a.id_actor() + "   " + a.name() : a.id_actor() + "   " + a.name());
        }
        System.out.println("------------End of List-----------------");
        showActorList(actorListFullData);
        printMenu();
        break;

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
        System.out.println(invalidInput);
    }
  }
//--------------------------------//
  public void helpMenu() {
    System.out.println("\n  /----------------------------------------------/");
    System.out.println(" /This is Clutch-MDb, a textbased movie database/");
    System.out.println("/----------------------------------------------/");
    System.out.println("\nEst feugiat habitasse arcu commodo augue interdum Facilisis pharetra tortor habitasse feugiat praesent suscipit rutrum \nSodales sociosqu facilisis tempus metus Magna congue per quis vehicula Porttitor etiam tristique massa et dapibus amet \nlorem molestie Sociosqu Curae dolor amet nulla id diam donec ut auctor, imperdiet vehicula Maecenas tellus purus nam \nporta ligula fusce donec varius, tristique.");
  }
//--------------------------------//
}
