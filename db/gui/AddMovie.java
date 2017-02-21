package db.gui;

//import db.gui.Character;

import java.util.Scanner;
import java.util.ArrayList;

public class AddMovie {

  public ArrayList<String> addMovieList = new ArrayList<String>();
  private String name = "";
  private String genre = "";
  private String age = "";
  private String company = "";
  private String year = "";
  private String synopsis = "";
  private String director = "";

  //private Character c = new Character();

  public ArrayList<String> addMovie() {

    Scanner in = new Scanner(System.in);
      System.out.println("\nName of movie:");
      name = in.nextLine();
      addMovieList.add(name);

      System.out.println("\nGenre of movie:");
      genre = in.nextLine();
      addMovieList.add(genre);

      System.out.println("\nRecommended age for movie:");
      age = in.nextLine();
      addMovieList.add(age);

      System.out.println("\nProduction company:");
      company = in.nextLine();
      addMovieList.add(company);

      System.out.println("\nYear movie was produced:");
      year = in.nextLine();
      addMovieList.add(year);

      System.out.println("\nSynopsis:");
      synopsis = in.nextLine();
      addMovieList.add(synopsis);

      System.out.println("\nDirector of the movie:");
      director = in.nextLine();
      addMovieList.add(director);

      /*while (true) {
        c.askForActor();
      }*/

      /*System.out.println("\nTitle: " + name + "\nGenre: " + genre +  "\nRecommended age: " + age + "\nProduction company: " + company + "\nRelease year: " + year + "\nDirector: " + director + "\nSynopsis: " + synopsis);*/
      return addMovieList;
    }
  }
