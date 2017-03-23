package db.app;

import java.util.ArrayList;
/**
 * A class that represents an actor.
 */
public class Actor {
  private int id_actor;
  private String name;
  private String birth;
  private String nationality;
  private String biography;

  /**
   * @param id_actor integer, primary key, not null
   * @param name String actor name
   * @param birth YYYY-MM-DD
   * @param nationality
   * @param biography Actor cv
   */

   public Actor(int id_actor,
                    String name,
                    String birth,
                    String nationality,
                    String biography){
    this.id_actor = id_actor;
    this.name = name;
    this.birth = birth;
    this.nationality = nationality;
    this.biography = biography;
  }

  public Actor (ArrayList<String> props){
   this.id_actor = 0;
   this.name = props.get(0);
   this.birth = props.get(1);
   this.nationality = props.get(2);
   this.biography = props.get(3);
   System.out.println("da act: " + this);
 }

  /**
   * Returns the id number (primary key) of this movie. The number is auto generated from the sql statement creating the rows
   * @return the id of this movie as an int (or 0 if it's not been set)
   */
  public int id_actor() {
    return this.id_actor;
  }

  /**
   * Returns the name of the actor
   * @return The name of the actor
   */
  public String name (){
    return this.name;
  }

  /**
   * Returns the date of birth
   * @return The birth of the actor as a string
   */
   public String birth(){
     return this.birth;
   }

  /**
   * Returns nationality of the actor
   * @return nationality as a String
   */
   public String nationality(){
     return this.nationality;
   }

   /**
    * Returns the biography of the actor
    * @return The biography as a String
    */
    public String biography(){
      return this.biography;
    }

    public void setID(int id){
     this.id_actor = id;
   }

  @Override // ta bort id_movie från utskrift
  public String toString(){
    return id_actor + " | " + name + " | " + birth + " | " +
      nationality + " | " + biography;
  }

}
