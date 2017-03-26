package db.app;

import java.util.ArrayList;
/**
 * En klass som representerar movie_actor, innehåller även information från Movie och Actor
 */
public class MovieActor {
  private int id_movie;
  private int id_actor;
  private String character;

  public MovieActor(String character){
    this.character = character;
  }

  public MovieActor(ArrayList<String> props) {
    this.id_movie = Integer.parseInt(props.get(0));
    this.id_actor = Integer.parseInt(props.get(1));
    this.character = props.get(2);
  }

  public int id_movie() {
    return this.id_movie;
  }
  public int id_actor() {
    return this.id_actor;
  }
  public String character() {
    return this.character;
  }

  @Override // ta bort id_movie från utskrift
  public String toString(){
    return  id_movie + " | " + id_actor + " | " + character ;
  }

}

/*
  private String title;
  private String genre;
  private String age;
  private String prod_company;
  private String prod_year;
  private String synopsis;
  private String director;
  private String name;
  private String birth;
  private String nationality;
  private String biography;
*/

  /**
   * @param id_actor integer, primary key, not null
   * @param name String actor name
   * @param birth YYYY-MM-DD
   * @param nationality
   * @param biography Actor cv
   */

/*
   public MovieActor(
   int id_movie,
   int id_actor,
   String character,
   String title,
   String genre,
   String age,
   String prod_company,
   String prod_year,
   String synopsis,
   String director,
   String name,
   String birth,
   String nationality,
   String biography){
     this.id_movie = id_movie;
     this.id_actor = id_actor;
     this.character = character;
     this.title = title;
     this.genre = genre;
     this.age = age;
     this.prod_company = prod_company;
     this.prod_year = prod_year;
     this.synopsis = synopsis;
     this.director = director;
     this.name = name;
     this.birth = birth;
     this.nationality = nationality;
     this.biography = biography;
   }

  public MovieActor (ArrayList<String> props){
    this.id_movie = 0;
    this.id_actor = 0;
    this.character = props.get(2);
    this.title = props.get(3);
    this.genre = props.get(4);
    this.age = props.get(5);
    this.prod_company = props.get(6);
    this.prod_year = props.get(7);
    this.synopsis = props.get(8);
    this.director = props.get(9);
    this.name = props.get(10);
    this.birth = props.get(11);
    this.nationality = props.get(12);
    this.biography = props.get(13);
   System.out.println("movie_actor: " + this);
 } */

  /**
   * Returns the id number (primary key) of this movie. The number is auto generated from the sql statement creating the rows
   * @return the id of this movie as an int (or 0 if it's not been set)
   */

/*  public String title(){
    return this.title;
  }
  public String genre(){
    return this.genre;
  }
  public String age(){
    return this.age;
  }
  public String prod_company(){
    return this.prod_company;
  }
  public String prod_year(){
    return this.prod_year;
  }
  public String synopsis(){
    return this.synopsis;
  }
  public String director(){
    return this.director;
  }

  public String name (){
    return this.name;
  }

  public String birth(){
     return this.birth;
   }

  public String nationality(){
     return this.nationality;
   }

  public String biography(){
      return this.biography;
    }

    public void setID(int id){
     this.id_actor = id;
   }

  @Override // ta bort id_movie från utskrift
  public String toString(){
  return  id_movie + " | " +id_actor + " | " +character + " | " +title + " | "+
  genre + " | " +age + " | " + prod_company + " | " +prod_year + " | " +
  synopsis + " | " +director  + " | " +name + " | " +birth + " | " +
  nationality + " | " +biography;
  }

}
*/
