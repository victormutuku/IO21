/*
 * A password is considered strong if the below conditions are all met:
    It has at least 6 characters and at most 20 characters.
    It contains at least one lowercase letter, at least one uppercase letter, and at least one digit.
    It does not contain three repeating characters in a row (i.e., "...aaa..." is weak, but "...aa...a..." is strong,
    assuming other conditions are met).

 * Given a string password, return the minimum number of steps required to make password strong. 
   if password is already strong, return 0.

 * In one step, you can:
    Insert one character to password,
    Delete one character from password, or
    Replace one character of password with another character.
 
 * Example 1:
    Input: password = "a"
    Output: 5

 * Example 2:
    Input: password = "aA1"
    Output: 3

 * Example 3:
    Input: password = "1337C0d3"
    Output: 0
*/

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class HardQuestion {
    public int strongPasswordChecker(String password){
      int count = 0;
      int lower = 0;
      int upper = 0;
      if(password.length() < 6){
         count = 6 - password.length();
      } else {
         Pattern lowerCase = Pattern.compile("[a-z]");
         Pattern upperCase = Pattern.compile("[A-Z]");
         Pattern numeric = Pattern.compile("[0-9]");
         Pattern repeat = Pattern.compile("[a-zA-Z0-9]{3}");

         Matcher matcher1 = lowerCase.matcher(password);
         Matcher matcher2 = upperCase.matcher(password);
         Matcher matcher3 = numeric.matcher(password);
         Matcher matcher4 = repeat.matcher(password);

         boolean matcher1Found = matcher1.find();
         boolean matcher2Found = matcher2.find();
         boolean matcher3Found = matcher3.find();
         boolean matcher4Found = matcher4.find();

         if(!matcher1Found){
            lower = lower + 1;
         }
         if(!matcher2Found){
            upper = upper + 1;
         }
         if(!matcher3Found){
            count = count + 1;
         }
         if(matcher4Found){
            count = count + 1;
            if(lower == 1 && matcher4Found){
               lower = lower - 1;
            }
            if(upper == 1 && matcher4Found){
               upper = upper - 1;
            }
         }
      }
      return count + lower + upper;
    }
}
