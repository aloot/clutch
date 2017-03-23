package db.gui;

import java.util.Scanner;
import java.util.ArrayList;

public class AddActor {

  public ArrayList<String> addActorList = new ArrayList<String>();
  private String actorName    ="";
  private String birth        ="";
  private String nationality  ="";
  private String biography    ="";
  private String character    ="";

  public ArrayList<String> addActor() {

    Scanner sc = new Scanner(System.in);

    System.out.print("\nActor name: ");
    actorName = sc.nextLine();
    do {
      while (actorName.matches(".*\\d.*")){
        System.out.println("\n'Actor Name' cannot contain digits!");
        System.out.print("\nPlease enter a valid 'Actor name': ");
        actorName = sc.nextLine();
      }
      if (actorName.trim().isEmpty()) {
        System.out.print("\nName can not be empty, please enter a name: ");
        actorName = sc.nextLine();
      }
    } while (actorName.trim().isEmpty());
    String newActorName = actorName.trim();
    addActorList.add(newActorName);

    System.out.print("\nCharacter in this movie: ");
    character =   sc.nextLine();
    while (character.trim().isEmpty()) {
      System.out.print("\n'Character' cannot be empty, please enter a character name: ");
      character =   sc.nextLine();
    }
    addActorList.add(character);

    System.out.print("\nDate of birth [YYYY-MM-DD]: ");
    birth =       sc.nextLine();
    while (!birth.matches("([0-9]{4})-([0-9]{2})-([0-9]{2})")) {
      System.out.print("\nInvalid date format! Please follow the templete above: ");
      birth =       sc.nextLine();
    }

    addActorList.add(birth);

    System.out.print("\nNationality: ");
    nationality = sc.nextLine();
    addActorList.add(nationality);

    System.out.print("\nBiography: ");
    biography =   sc.nextLine();
    addActorList.add(biography);

    return addActorList;
  }
}
