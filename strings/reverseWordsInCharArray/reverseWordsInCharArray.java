import java.io.*;
import java.util.*;

class Solution {

  static char[] reverseWords(char[] arr) {
    return reverseWordsUtil(String.valueOf(arr)).toCharArray();   
  }
  
  public static String reverseWordsUtil(String input) {
    String[] words = input.split(" ");
    // case where we have only spaces as the input String
    if(words.length == 0) {
      return input;
    }
    //else initialise an empty string and we can add the words 
    String res = "";
    for(int i = words.length-1; i >= 0; i--) {
      res += words[i]+" ";
    }
    res = res.trim();
    return res;
  }

  public static void main(String[] args) {
    String str = "someString divya asa"; 
    char[] charArray = str.toCharArray();
    char[] res = reverseWords(charArray);
    return;
  }

}
