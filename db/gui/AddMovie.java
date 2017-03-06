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

      System.out.print("\nTitle of movie: ");
      name = in.nextLine();
      do {
        if (name.trim().isEmpty()){
          System.out.print("\nTitle can not be empty, please enter a valid title: ");
          name = in.nextLine();
        }
      } while (name.trim().isEmpty());
      String newName = name.trim();
      addMovieList.add(newName);


      System.out.print("\nGenre of movie: ");
      genre = in.nextLine();
      addMovieList.add(genre);

      System.out.print("\nRecommended age for movie: ");
      age = in.nextLine();
      addMovieList.add(age);

      System.out.print("\nProduction company: ");
      company = in.nextLine();
      addMovieList.add(company);

      System.out.print("\nYear movie was produced: ");
      year = in.nextLine();
      addMovieList.add(year);

      System.out.print("\nSynopsis: ");
      synopsis = in.nextLine();
      addMovieList.add(synopsis);

      System.out.print("\nDirector of the movie: ");
      director = in.nextLine();
      addMovieList.add(director);

      /*while (true) {
        c.askForActor();
      }*/

      /*System.out.println("\nTitle: " + name + "\nGenre: " + genre +  "\nRecommended age: " + age + "\nProduction company: " + company + "\nRelease year: " + year + "\nDirector: " + director + "\nSynopsis: " + synopsis);*/
      return addMovieList;
    }
  }
