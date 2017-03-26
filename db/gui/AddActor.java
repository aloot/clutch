package db.gui;

import java.util.Scanner;
import java.util.ArrayList;

public class AddActor {

  public ArrayList<String> addActorList = new ArrayList<String>(5);
  private String actorName    = "";
  private String birth        = "";
  private String nationality  = "";
  private String biography    = "";
  private String character    = "";

  public ArrayList<String> addActor() {
    addActorList.add(actorName);
    addActorList.add(birth);
    addActorList.add(nationality);
    addActorList.add(biography);
    addActorList.add(character);
    Scanner sc = new Scanner(System.in);
    System.out.print("\nActor name: ");
    actorName = sc.nextLine();
    do {
      while (actorName.matches(".*\\d.*")){
        System.out.println("\n'Name' cannot contain digits, please enter a valid name!");
        actorName = sc.nextLine();
      }
      if (actorName.trim().isEmpty()) {
        System.out.print("\n'Name' can not be empty, please enter a name: ");
        actorName = sc.nextLine();
      }
    } while (actorName.trim().isEmpty());
    String newActorName = actorName.trim();
    addActorList.set(0, newActorName);

    System.out.print("\nCharacter in this movie: ");
    character =   sc.nextLine();
    while (character.trim().isEmpty()) {
      System.out.print("\n'Character' cannot be empty, please enter a character name: ");
      character =   sc.nextLine();
    }
    addActorList.set(4, character);

    System.out.print("\nDate of birth [YYYY-MM-DD]: ");
    birth =       sc.nextLine();
    while (!birth.matches("([0-9]{4})-([0-9]{2})-([0-9]{2})")) {
      System.out.print("\nInvalid date format! Please follow this templete, [YYYY-MM-DD]: ");
      birth =       sc.nextLine();
    }

    addActorList.set(1, birth);

    System.out.print("\nFrom/ Born in: ");
    nationality = sc.nextLine();
    addActorList.set(2, nationality);

    System.out.print("\nBiography: ");
    biography =   sc.nextLine();
    addActorList.set(3, biography);
    return addActorList;
  }
}
