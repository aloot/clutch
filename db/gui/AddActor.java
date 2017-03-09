package db.gui;

import java.util.Scanner;
import java.util.ArrayList;

public class AddActor {

  public ArrayList<String> addActorList = new ArrayList<String>();
  String actorName    ="";
  String birth        ="";
  String nationality  ="";
  String biography    ="";
  String character    ="";

  public ArrayList<String> addActor() {

    Scanner sc = new Scanner(System.in);

    System.out.print("\nActor name: ");
    actorName = sc.nextLine();
    do {
      if (actorName.trim().isEmpty()) {
        System.out.print("\nName can not be empty, please enter a name: ");
        actorName = sc.nextLine();
      }
    } while (actorName.trim().isEmpty());
    String newActorName = actorName.trim();
    addActorList.add(newActorName);

    System.out.print("\nCharacter in this movie: ");
    character =   sc.nextLine();
    System.out.print("\nDate of birth: ");
    birth =       sc.nextLine();
    System.out.print("\nNationality: ");
    nationality = sc.nextLine();
    System.out.print("\nBiography: ");
    biography =   sc.nextLine();

    return addActorList;
  }
}
