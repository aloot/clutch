package db.app;
import java.util.ArrayList;
/**
 * A class that represents a municipality.
 */
public class Movie{
  private int id_movie;
  private String title;
  private String genre;
  private String age;
  private String prod_company;
  private String prod_year;
  private String synopsis;
  private String director;

  /**
   * @param id_movie integer, primary key, not null
   * @param title The title of the movie
   * @param genre The genre of the movie
   * @param age Lowest recommended age of
   * @param prod_company The production company behind the movie
   * @param prod_year In what year the move was released
   * @param synopsis Movie plot
   * @param director Director of the movie
   */

   public Movie(int id_movie,
                    String title,
                    String genre,
                    String age,
                    String prod_company,
                    String prod_year,
                    String synopsis,
                    String director){
    this.id_movie = id_movie;
    this.title = title;
    this.genre = genre;
    this.age = age;
    this.prod_company = prod_company;
    this.prod_year = prod_year;
    this.synopsis = synopsis;
    this.director = director;
  }
  public Movie(ArrayList<String> props){
  // this.id_movie = props.get(0);
   this.id_movie = 0;
   this.title = props.get(0);
   this.genre = props.get(1);
   this.age = props.get(2);
   this.prod_company = props.get(3);
   this.prod_year = props.get(4);
   this.synopsis = props.get(5);
   this.director = props.get(6);
 }

  /**
   * Returns the id number (primary key) of this movie. The number is auto generated from the sql statement creating the rows
   * @return the id of this movie as an int (or 0 if it's not been set)
   */
  public int id_movie() {
    return this.id_movie;
  }

  /**
   * Returns the title of this movie
   * @return The title of the movie as a String
   */
  public String title(){
    return this.title;
  }

  /**
   * Returns the genre of this movie
   * @return The genre of the movie as a String
   */
   public String genre(){
     return this.genre;
   }

  /**
   * Returns the recommended age limit for this movie
   * @return The age as an int
   */
   public String age(){
     return this.age;
   }

  /**
   * Returns the name of the production company behind the movie
   * @return production company as a String
   */
   public String prod_company(){
     return this.prod_company;
   }

  /**
   * Returns the year the movie was made
   * @return Production year as int
   */
   public String prod_year(){
     return this.prod_year;
   }

  /**
   * Returns the movie plot
   * @return String
   */
   public String synopsis(){
     return this.synopsis;
   }

  /**
   * Returns the name of the movie director
   * @return Director name as String
   */
   public String director(){
     return this.director;
   }

  @Override // ta bort id_movie från utskrift
  public String toString(){
    return id_movie + " | " + title + " | " + genre + " | " +
      age + " | " + prod_company + " | " + prod_year + " | " +
      synopsis + " | " + director ;
  }

  /**
   * A mutator method to change the HTTPS capability of this Municipality
   * @param https a boolean value representing the new indication of whether this Municipality supports HTTPS
   */
/*  public void setHTTPS(boolean https){
    this.supportsHTTPS = https;
  }*/
  /**
   * A mutator to set or change the ID of this Municipality. The id defaults to 0 while not set.
   * @param id The new id as an int
   */
  public void setID(int id){
    this.id_movie = id;
  }
}
