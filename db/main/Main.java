package db.main;

import db.app.FaceMovieDB;
import db.app.MovieSQL;
import db.app.Movie;

import db.gui.Menu;
import db.gui.AddMovie;

import java.util.List;
//import java.util.Scanner;

public class Main {
  public static void main (String [] args) {

//    FaceMovieDB db = new MovieSQL();
    Menu menu = new Menu();
    menu.runLoginMenu();




  //  Movie m = new Movie(0, "SillyMovie", "kul", "10", "MGM", "2013", "", "Dory Director");
  //  db.addMovie(m);
  //  System.out.println("New movie id: " + m.id_movie());

  /*  List<Movie>  movieList = db.getAllMovies();
    for (Movie mv : movieList) {
      System.out.println(mv);
    }*/

  //  m = db.getByTitle("SillyMovie");

    /* DB:
    å: 229, Å: 197, ä: 228, Ä: 196, ö: 246, Ö: 214
    å = 165, ä = 195, ö = 164, Å = 8230, Ä = 8222, Ö = 214
    keyboard:

    */
//    db.deleteCity(m);
//    m = db.getByName(sillyCity);
//    System.out.println("the deleted m: " + (m == null));

/*    Municipality m2 = db.getByNrID(291);
    System.out.println("from db: char ");
    for (int i = 0; i < 6; i++) {
      char nameC = m2.name().charAt(i);
      System.out.println("char " + nameC + ": " + (int) nameC);
    }

    String fff = "å";
    System.out.println("from java: char ");
    System.out.println(fff + ", längd: " + fff.length());
    for (int i = 0; i < fff.length(); i ++) {
      char nameC = fff.charAt(i);
      System.out.println("char " + nameC + ": " + (int) nameC);
    }
    Scanner s = new Scanner(System.in);
    String inS = "";
    while (!"e".equals(inS)) {
      inS = s.nextLine();
      System.out.println("Das 289: " + (int) inS.charAt(0));
    }*/
//    m.db.getByName();

  }

}
