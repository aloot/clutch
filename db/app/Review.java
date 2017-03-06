package db.app;

import java.util.ArrayList;
/**
 * A class that represents a review.
 */
public class Review {
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

  public Review (ArrayList<String> props){
   this.id_review = 0;
   this.id_movie = Integer.parseInt(props.get(0));
   this.score = Integer.parseInt(props.get(1));
   this.author = props.get(2);
   this.review = props.get(3);
//   System.out.println("da rev: " + this);
 }

  /**
   * Returns the id number (primary key) of this movie. The number is auto generated from the sql statement creating the rows
   * @return the id of this movie as an int (or 0 if it's not been set)
   */
  public int id_review() {
    return this.id_review;
  }

  /**
   * Returns the id of the movie reviewed
   * @return The id of the movie as an int
   */
  public int id_movie (){
    return this.id_movie;
  }

  /**
   * Returns the score noted for this review
   * @return The score of the movie as an int
   */
   public int score(){
     return this.score;
   }

  /**
   * Returns author of this review
   * @return The author as a String
   */
   public String author(){
     return this.author;
   }

   /**
    * Returns reviewtext of this review
    * @return The review as a String
    */
    public String review(){
      return this.review;
    }

   public void setID(int id){
     this.id_review = id;
   }


  @Override // ta bort id_movie från utskrift
  public String toString(){
    return id_review + " | " + id_movie + " | " + score + " | " +
      author + " | " + review;
  }

}
