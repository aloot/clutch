package db.app;

import db.app.Actor;
import java.util.List;

public interface FaceMovieActorDB {

  // Returns a list with all reigstered actors
  public List<Actor> getAllActorsByName();

  // Returns a list with all movies where actor takes part
  public List<String> getAllMovies(Actor a);

  // Returns a list with all actors taking part in the movie 'id_movie'
  public List<Actor> getByMovieID(int id_movie);

  // Returns the character name
  public String character();


//  public void addActor();

  //public void deleteActor(Actor a);


}
