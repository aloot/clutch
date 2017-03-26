package db.app;
import java.util.*;
import java.sql.ResultSet;
import java.sql.PreparedStatement;


public class ReviewSQL implements FaceReviewDB{
  DBUtils db = DBUtils.getInstance();

  public List<Review> getAllReviewsByMovieId(){
    ArrayList<Review> reviewList = new ArrayList<Review>();
    //ResultSet rs = db.executeQuery("SELECT * FROM movie ORDER BY id_movie");
    ResultSet rs = db.executeQuery("select * from review order by id_movie");
    //("select a.title as title, b.author as author, b.review as review, b.score as score from movie a, review b where a.id_movie = b.id_movie order by id_movie");
    try{
      Review r = null;
      while(rs.next()){
        r = new Review(rs.getInt("id_review"),
                        rs.getInt("id_movie"),
                        rs.getInt("score"),
                        rs.getString("author"),
                        rs.getString("review"));
        reviewList.add(r);
      }
      db.closeIt(rs);
      return reviewList;
    } catch (Exception e){
      System.err.println("Getting all reviews by movie: " + e.getMessage());
      db.closeIt(rs);
    }
    return null;
  }
/*  AK borde räcka med getAllReviewsByMovieId*/
    public List<Review> getAllReviewsFullData(){
    ArrayList<Review> reviewList = new ArrayList<Review>();
    ResultSet rs = db.executeQuery("SELECT * FROM review order by lower(author)  asc");
    try{
      Review r = null;
      while(rs.next()){
        r = new Review(rs.getInt("id_review"),
                           rs.getInt("id_movie"),
                           rs.getInt("score"),
                           rs.getString("author"),
                           rs.getString("review")
                           );
        r.setID(rs.getInt("id_review"));
        reviewList.add(r);
      }
      db.closeIt(rs);
      return reviewList;
    } catch (Exception e){
      System.err.println("Getting all reviews: " + e.getMessage());
      db.closeIt(rs);
    }
    return null;
  }

  public void deleteReview(Review r){
    int id_review = r.id_review();
    String SQL="DELETE FROM review"+
      " WHERE id_review=" + id_review;
    System.out.println(db.executeUpdate(SQL) +
                       " rows deleted");
  }
  /**
   * Inserts m into the database and sets the id of m to the
   * MunicipalityID it gets.
   */
  public void addReview(Review r){
    //int id=r.id();
    int id_movie = r.id_movie();
    int score = r.score();
    String author = r.author();
    String review = r.review();
    String SQL = "INSERT INTO review " +
      "(id_movie, score, author, review)" +
      " VALUES('" + id_movie + "', " +
      "'" + score + "', " +
      "'" + author + "', " +
      "'" + review + "')";

//      System.out.println("sql-et: " + SQL);
    System.out.println(db.executeUpdate(SQL)+
                       " rows inserted");

    /* r doesn't have an ID yet. Let's find it... */

// osäker på vad denna gör uppdaterat från title till review/id_review/AK
    ResultSet rs = db.executeQuery("SELECT id_review"+
                                   " FROM review"+
                                   " WHERE review ='" + review + "'");
    try{
      rs.next();
      r.setID(rs.getInt("id_review"));
    } catch (Exception e){
      System.err.println("Getting ID: " + e.getMessage());
    } finally {
      db.closeIt(rs);
    }
  }

  public List<Review> getByMovieID(int id_movie){
    ArrayList<Review> reviewList = new ArrayList<Review>();
    //System.out.println("Get by id_movie: " + id_movie);
    String SQL = "SELECT * FROM review WHERE id_movie ='" + id_movie + "'";
    //System.out.println("--DEBUG: SQL: " + SQL);
    ResultSet rs = db.executeQuery(SQL);
    Review r = null;
    try {
      while (rs.next()){
        r = new Review(rs.getInt("id_review"),
                     rs.getInt("id_movie"),
                     rs.getInt("score"),
                     rs.getString("author"),
                     rs.getString("review"));
        r.setID(rs.getInt("id_review"));
        reviewList.add(r);

      }
      //System.out.println("En ny review: " + r.id_review() + " " + r.review());
      //System.out.println("ReviewList: " + reviewList);
      return reviewList;
    } catch (Exception e){
      System.err.println("getByMovieID: " + e.getMessage());
    } finally {
      db.closeIt(rs);
    }
    return null;
  }

  public Review getByReviewID(int id_review){
    //System.out.println("Get id_review: " + id_review);
    String SQL = "SELECT * FROM review WHERE id_review =" + id_review;
    //System.out.println("--DEBUG: SQL: " + SQL);
    ResultSet rs = db.executeQuery(SQL);
    System.out.println(rs);
    Review r = null;
    try {
      if (rs.next()){
        r = new Review(rs.getInt("id_review"),
                     rs.getInt("id_movie"),
                     rs.getInt("score"),
                     rs.getString("author"),
                     rs.getString("review"));
        r.setID(rs.getInt("id_review"));
      }
      return r;
    } catch (Exception e){
      System.err.println("getByID: " + e.getMessage());
    } finally {
      db.closeIt(rs);
    }
    return null;
  }

//----------------------------------------------------------------------------//

//----------------------------------------------------------------------------//

}
