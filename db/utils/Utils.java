package db.utils;

public class Utils {
  /*public static void main(String [] args) {
    String s = args[0];
    charToDigit(s);
  */

    /*
    Removes blanks at end & beginning
    */
  public static String removeBlanks(String s){
    if (s.length() > 2) {
      s = s.trim();
      return s;
    } else {
      System.out.println("String is too short");
      return s;
    }
  }

/*
Gör om textsträng till siffror
*/
  public static void charToDigit(String s) {
    try {
      int i = Integer.parseInt(s);
    } catch (NumberFormatException e) {
      System.out.println("The string" + s + " was not a number");
    }
    System.out.println(s);
  }

//  if (s.startsWith(" "))
/*for (char ch : exampleString.toCharArray()){
    System.out.println(ch);
  }*/


}
