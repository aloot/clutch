package db.gui;

import java.util.Scanner;

public class AddCharacter {

//----------------------------------------------------------------------------//
  public void askForCharacter() {
    Scanner s = new Scanner(System.in);
    String decision;
    System.out.println("\nWould you like to add an character? y/n");
    decision = s.nextLine();

    switch(decision){
      case "n":
        break;
      case "y":
        addCharacter();
        break;
      default:
      System.out.println("An unknown error has occured.");
    }
  }
//----------------------------------------------------------------------------//
  public void addCharacter() {

    Scanner sc = new Scanner(System.in);
    String characterName;
    String birth;
    String nationality;
    String biography;
    String playedBy;

    System.out.println("\nCharacter name: ");
    characterName = sc.nextLine();
    System.out.println("\nPlayed by: ");
    playedBy = sc.nextLine();
    System.out.println("\nDate of birth: ");
    birth = sc.nextLine();
    System.out.println("\nNationality: ");
    nationality = sc.nextLine();
    System.out.println("\nBiography:");
    biography = sc.nextLine();

    askForCharacter();

  }
//----------------------------------------------------------------------------//
}
