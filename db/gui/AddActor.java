package db.gui;

import java.util.Scanner;

public class AddActor {

//----------------------------------------------------------------------------//
  public void askForActor() {
    Scanner s = new Scanner(System.in);
    String decision;
    System.out.println("\nWould you like to add an actor? y/n");
    decision = s.nextLine();

    switch(decision){
      case "n":
        break;
      case "y":
        addActor();
        break;
      default:
      System.out.println("An unknown error has occured.");
    }
  }
//----------------------------------------------------------------------------//
  public void addActor() {

    Scanner sc = new Scanner(System.in);
    String actorName;
    String birth;
    String nationality;
    String biography;
    String playedBy;

    System.out.println("\nActor name: ");
    actorName = sc.nextLine();
    System.out.println("\nPlayed by: ");
    playedBy = sc.nextLine();
    System.out.println("\nDate of birth: ");
    birth = sc.nextLine();
    System.out.println("\nNationality: ");
    nationality = sc.nextLine();
    System.out.println("\nBiography:");
    biography = sc.nextLine();

    askForActor();

  }
//----------------------------------------------------------------------------//
}
