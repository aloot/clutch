package db.app;

//import java.util.ArrayList;
/**
 * A class that represents a review.
 */
public class Review{
  private int id_review;
  private int id_movie;
  private int score;
  private String author;
  private String review;

  /**
   * @param id_review integer, primary key, not null
   * @param id_movie integer, foreign key (id_movie) references movie(id_movie)
   * @param score Rating between 0 and 10
   * @param author Who wrote this?
   * @param review The actual review
   */

   public Review(int id_review,
                    int id_movie,
                    int score,
                    String author,
                    String review){
    this.id_review = id_review;
    this.id_movie = id_movie;
    this.score = score;
    this.author = author;
    this.review = review;
  }

  public Review(ArrayList<String> props){
   this.id_review = 0;
   this.id_movie = props.get(0);
   this.score = props.get(1);
   this.author = props.get(2);
   this.review = props.get(3);
 }

  /**
   * Returns the id number (primary key) of this movie. The number is auto generated from the sql statement creating the rows
   * @return the id of this movie as an int (or 0 if it's not been set)
   */
  public int id_review() {
    return this.id_review;
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
