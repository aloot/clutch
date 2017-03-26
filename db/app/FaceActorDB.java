package db.app;
//import db.app.Actor;
import java.util.List;
import java.util.ArrayList;

public interface FaceActorDB {
  // Returns a list with [MovieActor, Actor] objects
  public ArrayList<Object> getActorByIdMovie(int id_movie);

// Returns an actor with listings of his/her roles and movies
  public ArrayList<Object> getActorFromId(int actNr);

  // Returns a list with all reigstered actors)
  public List<String> getAllActorsByName();

  // getAllActorsFullData
  public ArrayList<Actor> getAllActorsFullData();

  // deleteActor
  public void deleteActor(Actor a);

  // addActor
  public void addActor(Actor a);

  // addMovieActor
  public void addMovieActor(MovieActor ma);

  // getByIdActor
  public Actor getByIdActor(int i);


  // Returns a list with all actors taking part in the movie 'id_movie'
  //public List<Actor> getByMovieID(int id_movie);



// getByName
  public Actor getByName(String s);

// getByIdMovie
//  public String getByIdMovie();
/*
// getMovieActorByIdActor
   public List<Actor> getMovieActorByIdActor(String id_actor);
// getMovieActorByIdMovie
  public List<Actor> getMovieActorByIdMovie(String id_movie);
*/
}
