package db.app;
import java.util.*;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

/**
 * An implementation of ClutchMDB that uses the DBUtils to connect to an SQLite database.
 */
public class ActorSQL implements FaceMovieActorDB{
  DBUtils db = DBUtils.getInstance();

  public List<String> getAllActorsByName(){
    ArrayList<String> actorNamesList = new ArrayList<String>();
    ResultSet rs = db.executeQuery("SELECT name FROM actor ORDER BY name");
    try{
      String a = null;
      while(rs.next()){
        a = new String(rs.getString("name"));
        actorNamesList.add(a);
      }
      db.closeIt(rs);
      return actorNamesList;
    } catch (Exception e){
      System.err.println("Getting all actor names: " + e.getMessage());
      db.closeIt(rs);
    }
    return null;
  }

  public List<Actor> getAllActorsFullData(){
    ArrayList<Actor> ActorList = new ArrayList<Actor>();
    ResultSet rs = db.executeQuery("SELECT * FROM actor order by lower(name)  asc");
    try{
      Actor a = null;
      while(rs.next()){
        a = new Actor( rs.getInt("id_actor"),
                           rs.getString("name"),
                           rs.getString("birth"),
                           rs.getString("nationality"),
                           rs.getString("biography"));
        a.setID(rs.getInt("id_actor"));
        ActorList.add(a);
      }
      db.closeIt(rs);
      return ActorList;
    } catch (Exception e){
      System.err.println("Getting all actors: " + e.getMessage());
      db.closeIt(rs);
    }
    return null;
  }


  public void updateActorName(Actor a){
    int id = a.id_actor();
    String aName = a.name();
    String SQL="UPDATE actor SET name= " +
      a.name() + "WHERE id_actor =" + id;
    System.out.println(db.executeUpdate(SQL)
                       + " rows updated");
  }

  public void deleteActor(Actor a){
    int id_actor = a.id_actor();
    String SQL="DELETE FROM actor"+
      " WHERE id_actor=" + id_actor;
    System.out.println(db.executeUpdate(SQL) +
                       " rows deleted");
  }

  public void addActor(Actor a){
    //int id_actor=a.id_actor();
    String name = a.name();
    String birth = a.birth();
    String nationality = a.nationality();
    String biography = a.biography();
    String SQL = "INSERT INTO actor " +
      "(name, birth, nationality, biography)" +
      " VALUES('" + name + "', " +
      "'" + birth + "', " +
      "'" + nationality + "', " +
      "'" + biography + "')";
//      System.out.println("sql-et: " + SQL);
    System.out.println(db.executeUpdate(SQL)+
                       " rows inserted");

    ResultSet rs = db.executeQuery("SELECT id_actor"+
                                   " FROM actor"+
                                   " WHERE name ='"+name+"'");
    try{
      rs.next();
      a.setID(rs.getInt("id_actor"));
    } catch (Exception e){
      System.err.println("Getting ID: " + e.getMessage());
    } finally {
      db.closeIt(rs);
    }
  }

//AK, avmarkerar för att lösa ett kompileringsfel åt gången
   public Actor getByName(String name){
    //System.out.println("Get Namnet: " + title);
    String SQL="SELECT * FROM actor WHERE name ='" + name + "'";

    //System.out.println("--DEBUG: SQL: " + SQL);
    ResultSet rs = db.executeQuery(SQL);
    Actor a = null;
    try {
      if (rs.next()){
        a = new Actor(rs.getInt("id_actor"),
                     rs.getString("name"),
                     rs.getString("birth"),
                     rs.getString("nationality"),
                     rs.getString("biography"));
        a.setID(rs.getInt("id_actor"));
      }
      //System.out.println("EttNyttM: " + m.title());
      return a;
    } catch (Exception e){
      System.err.println("getByNameActorSQL: " + e.getMessage());
    } finally {
      db.closeIt(rs);
    }
    return null;
  }


  public Actor getByIdActor(int id_actor){
    System.out.println("Get id_actor: " + id_actor);
    String SQL = "SELECT * FROM actor WHERE id_actor =" + id_actor ;

    System.out.println("--DEBUG: SQL: " + SQL);
    ResultSet rs = db.executeQuery(SQL);
    System.out.println(rs);
    Actor a = null;
    try {
      if (rs.next()){
        a = new Actor(rs.getInt("id_actor"),
                     rs.getString("name"),
                     rs.getString("birth"),
                     rs.getString("nationality"),
                     rs.getString("biography"));
      }

      //System.out.println("En ny a: " + a.name());
      return a;
    } catch (Exception e){
      System.err.println("getByIdActor: " + e.getMessage());
    } finally {
      db.closeIt(rs);
    }
    return null;
  }
//******* Här lägger vi frågor som rör både kombinerat actor och movie
// lägga till getByIdMovie och getByIdActor i FaceMovieActor/FaceActor
// hämta alla actors & character för en viss film
///public List<String> getAllActorsByName(){
////  ArrayList<String> actorNamesList = new ArrayList<String>();//
public List<MovieActor> getMovieActorByIdMovie(String id_movie){
  ArrayList<MovieActor> maByMovieList = new ArrayList<MovieActor>();
  String SQL="SELECT a.character, b.*, c.* FROM movie_actor a, actor b, movie c WHERE a.id_movie ='" + id_movie + "' and a.id_actor = b.id_actor and a.id_movie = c.id_movie";
  ResultSet rs = db.executeQuery(SQL);
  MovieActor ma = null;
  try {
  //  if (rs.next()){
      while(rs.next()){
        ma = new MovieActor(rs.getInt("id_movie"),
                    rs.getInt("id_actor"),
                    rs.getString("character"),
                    rs.getString("title"),
                    rs.getString("genre"),
                    rs.getString("age"),
                    rs.getString("prod_company"),
                    rs.getString("prod_year"),
                    rs.getString("synopsis"),
                    rs.getString("director"),
                    rs.getString("name"),
                    rs.getString("birth"),
                    rs.getString("nationality"),
                    rs.getString("biography"));
                    ma.setID(rs.getInt("id_actor" ));
               maByMovieList.add(ma);
    }

    return maByMovieList;
  } catch (Exception e){
    System.err.println("getMAByIdMovie: " + e.getMessage());
  } finally {
    db.closeIt(rs);
  }
  return null;
}
//
public List<MovieActor> getMovieActorByIdActor(String id_actor){
  ArrayList<MovieActor> maByActorList = new ArrayList<MovieActor>();
  String SQL="SELECT a.character, b.*, c.* FROM movie_actor a, actor b, movie c WHERE a.id_movie ='" + id_actor + "' and a.id_actor = b.id_actor and a.id_movie = c.id_movie";
  ResultSet rs = db.executeQuery(SQL);
  try {
  //  if (rs.next()){
    MovieActor ma = null;
      while(rs.next()){
        ma = new MovieActor(rs.getInt("id_movie"),
                    rs.getInt("id_actor"),
                    rs.getString("character"),
                    rs.getString("title"),
                    rs.getString("genre"),
                    rs.getString("age"),
                    rs.getString("prod_company"),
                    rs.getString("prod_year"),
                    rs.getString("synopsis"),
                    rs.getString("director"),
                    rs.getString("name"),
                    rs.getString("birth"),
                    rs.getString("nationality"),
                    rs.getString("biography"));
                    ma.setID(rs.getInt("id_actor" ));
               maByActorList.add(ma);
  }

    return maByActorList;
  } catch (Exception e){
    System.err.println("getmaByIdActor: " + e.getMessage());
  } finally {
    db.closeIt(rs);
  }
  return null;
}


/* public List<Actor> getAllActorsByTitle() {
   List<Actor> l = [];
   Actor a = new Actor();
   l.add(a);
   return l;


 }*/
}
