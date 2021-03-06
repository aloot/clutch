package db.app;
import java.util.List;
/**
 * An interface representing a municipality database of some kind.
 * This interface defines the operations on Municipalities in the database as well as
 * methods for retrieving a {@link java.util.List}&lt;{@link db.app.Municipality}&gt; of all Municipality objects from the database and
 * a method for retrieving one db.app.Municipality by its name.
 */
public interface FaceReviewDB{

    /**
     * Returns a java.util.List of all municipalities as db.app.Municipality objects.
     * @return a java.util.List of all municipalities as db.app.Municipality objects.
     *
     */
 public List<Review> getAllReviewsByMovieId();
  /**
   * Returns a java.util.List of all municipalities as db.app.Municipality objects.
   * @return a java.util.List of all municipalities as db.app.Municipality objects.
   *
   */
  public List<Review> getAllReviewsFullData();
  /**
   * Updates a municipality using its ID as condition for the DB query and updates all fields according to their current status.
   * @param m The Municipality to be updated
   */
  //public void updateReviewTitle(Review m);
  /**
   * Deletes a Municipality according using its ID as condition for the query to the database.
   * @param m The Municipality to be updated
   */
  public void deleteReview(int id_review);

  /**
   * Adds a Municipality to the database and sets its ID to the newly created records ID
   * @param m The Municipality to be updated
   */
  public void addReview(Review r);

  /**
   * Returns a reference to a new Municipality, which is fetched by name from the database.
   * @param title A String with the name of the municipality to fetch.
   */
  //public Review getByMovieID(int id_movie);
  public List<Review> getByMovieID(int id_movie);
  /**
   * Updates a municipality's https status in the database, using its name for condition in the query
   */


  public Review getByReviewID(int id_review);

  /**
   * funderar på detta
   * Updates a municipality's https status in the database, using its name for condition in the query
   */
  //public int updateHTTPSbyName(String name, boolean https);
  //public int updateHTTPSbyName2(String name, boolean https);
}
