package db.utils;

public class Utils {


    /*
    Removes blanks at end & beginning
    */
  public String removeBlanks(String s){
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
  public int charToDig(String s) {
    try {
      int i = Integer.parseInt(s);
    } catch (NumberFormatException e) {
      System.out.println("The string(" + s ") was not a number");
    }
      return s
  }

//  if (s.startsWith(" "))
/*for (char ch : exampleString.toCharArray()){
    System.out.println(ch);
  }*/


}
