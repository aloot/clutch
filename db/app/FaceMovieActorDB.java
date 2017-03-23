package db.app;
//import db.app.Actor;
import java.util.List;

public interface FaceMovieActorDB{

  // Returns a list with all reigstered actors
  //?? varför Actor a borde inte behövas(kompileringen kräver)
  public List<String> getAllActorsByName();

  // getAllActorsFullData
  public List<Actor> getAllActorsFullData();

  // updateActorName

  // deleteActor
    public void deleteActor(Actor a);

  // addActor
      public void addActor(Actor a);

  // getByIdActor
      public Actor getByIdActor(int i);

    // Returns a list with all movies where actor takes part
  //public List<String> getAllMovies(Actor a);

  // Returns a list with all actors taking part in the movie 'id_movie'
  //public List<Actor> getByMovieID(int id_movie);

  // Returns the character name
  //  public String character();
  // Returns the character name

//***anna testar lite

/*// getAllActorsByTitle
  public List<Actor> getAllActorsByTitle(); */



// getByName
  public Actor getByName(String s);

// getByIdMovie
//  public String getByIdMovie();

// getMovieActorByIdActor
   public List<MovieActor> getMovieActorByIdActor(String id_actor);
// getMovieActorByIdMovie
  public List<MovieActor> getMovieActorByIdMovie(String id_movie);

}
