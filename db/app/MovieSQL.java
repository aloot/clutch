package db.app;
import java.util.*;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

/**
 * An implementation of MunicipalityDB that uses the DBUtils to connect to an SQLite database.
 */
public class MovieSQL implements FaceMovieDB{
  DBUtils db = DBUtils.getInstance();

  public List<String> getAllMoviesByTitle(){
    ArrayList<String> movieNamesList = new ArrayList<String>();
    ResultSet rs = db.executeQuery("SELECT title FROM movie ORDER BY title");
    try{
      String s = null;
      while(rs.next()){
        s = new String(rs.getString("title"));
//        m.setID(rs.getInt("id_movie"));
        movieNamesList.add(s);
      }
      db.closeIt(rs);
      return movieNamesList;
    } catch (Exception e){
      System.err.println("Getting all movie names: " + e.getMessage());
      db.closeIt(rs);
    }
    return null;
  }


  public List<Movie> getAllMoviesFullData(){
    ArrayList<Movie> movieList = new ArrayList<Movie>();
    ResultSet rs = db.executeQuery("SELECT * FROM movie");
    try{
      Movie m = null;
      while(rs.next()){
        m = new Movie(rs.getInt("id_movie"),
                           rs.getString("title"),
                           rs.getString("genre"),
                           rs.getString("age"),
                           rs.getString("prod_company"),
                           rs.getString("prod_year"),
                           rs.getString("synopsis"),
                           rs.getString("director"));
        m.setID(rs.getInt("id_movie"));
        movieList.add(m);
      }
      db.closeIt(rs);
      return movieList;
    } catch (Exception e){
      System.err.println("Getting all movies: " + e.getMessage());
      db.closeIt(rs);
    }
    return null;
  }

  public void updateMovieTitle(Movie m){
    int id = m.id_movie();
    String mTitle = m.title();
    String SQL="UPDATE movie SET title= " +
      m.title() + "WHERE id_movie =" + id;
    System.out.println(db.executeUpdate(SQL)
                       + " rows updated");
  }
  public void deleteMovie(Movie m){
    int id = m.id_movie();
    String SQL="DELETE FROM movie"+
      " WHERE id_movie=" + id;
    System.out.println(db.executeUpdate(SQL) +
                       " rows deleted");
    // What if m.id() returns 0? Think about a solution!
  }
  /**
   * Inserts m into the database and sets the id of m to the
   * MunicipalityID it gets.
   */
  public void addMovie(Movie m){
    //int id=m.id();
    String title = m.title();
    String genre = m.genre();
    String age = m.age();
    String prod_company = m.prod_company();
    String prod_year = m.prod_year();
    String synopsis = m.synopsis();
    String director = m.director();
    String SQL = "INSERT INTO movie " +
      "(title, genre, age, prod_company, prod_year, synopsis, director)" +
      " VALUES('" + title + "', " +
      "'" + genre + "', " +
      "'" + age + "', " +
      "'" + prod_company + "', " +
      "'" + prod_year + "', " +
      "'" + synopsis + "', " +
      "'" + director + "')";
//      System.out.println("sql-et: " + SQL);
    System.out.println(db.executeUpdate(SQL)+
                       " rows inserted");

    /* m doesn't have an ID yet. Let's find it... */
    /*
      Alternative method to get the last rowid:
      implement select last_insert_rowid(); in the executeUpdate()
      method. That requires a total re-design of the method and
      the semantics. Better to add a executeInsert method that
      returns the last_insert_rowid() if successful or 0 otherwise.
    */

    ResultSet rs = db.executeQuery("SELECT id_movie"+
                                   " FROM movie"+
                                   " WHERE title ='"+title+"'");
    try{
      rs.next();
      m.setID(rs.getInt("id_movie"));
    } catch (Exception e){
      System.err.println("Getting ID: " + e.getMessage());
    } finally {
      db.closeIt(rs);
    }
  }

  public Movie getByTitle(String title){
    System.out.println("Get Namnet: " + title);
    String SQL="SELECT * FROM movie WHERE title ='" + title + "'";

    System.out.println("--DEBUG: SQL: " + SQL);
    ResultSet rs = db.executeQuery(SQL);
    Movie m = null;
    try {
      if (rs.next()){
        m = new Movie(rs.getInt("id_movie"),
                     rs.getString("title"),
                     rs.getString("genre"),
                     rs.getString("age"),
                     rs.getString("prod_company"),
                     rs.getString("prod_year"),
                     rs.getString("synopsis"),
                     rs.getString("director"));
        m.setID(rs.getInt("id_movie"));
      }
      System.out.println("EttNyttM: " + m.title());
      return m;
    } catch (Exception e){
      System.err.println("getByTitle: " + e.getMessage());
    } finally {
      db.closeIt(rs);
    }
    return null;
  }

  public Movie getByNrID(int intID){
    System.out.println("Get intID: " + intID);
    String SQL = "SELECT * FROM movie WHERE id_movie =" + intID ;

    System.out.println("--DEBUG: SQL: " + SQL);
    ResultSet rs = db.executeQuery(SQL);
    System.out.println(rs);
    Movie m = null;
    try {
      if (rs.next()){
        m = new Movie(rs.getInt("id_movie"),
                     rs.getString("title"),
                     rs.getString("genre"),
                     rs.getString("age"),
                     rs.getString("prod_company"),
                     rs.getString("prod_year"),
                     rs.getString("synopsis"),
                     rs.getString("director"));
        m.setID(rs.getInt("id_movie"));
      }


      System.out.println("EttNyttM: " + m.title());
      return m;
    } catch (Exception e){
      System.err.println("getByID: " + e.getMessage());
    } finally {
      db.closeIt(rs);
    }
    return null;
  }

  /*public int updateHTTPSbyName(String name, boolean https){
    String SQL="UPDATE municipalities SET HTTPS="+(https?"1":"0")+" WHERE name='"+name+"'";
    System.out.println("DEBUG: SQL: " + SQL);
    int rows = db.executeUpdate(SQL);
    return rows;
  }*/

  /*
  // What's this? See if you can find information about it!
  public int updateHTTPSbyName2(String name, boolean https){
  String sql = "UPDATE municipalities SET HTTPS=? WHERE name= ?";
  int result=0;
  try{
  PreparedStatement pStm = db.preparedStatement(sql);
  pStm.setInt(1, (https?1:0));
  pStm.setString(2,name);
  result=pStm.executeUpdate();
  return result;
  }catch(Exception e){
  System.err.println("Error creating prepared stm: "+e.getMessage());
  return -1;
  }
  }
  */
}
