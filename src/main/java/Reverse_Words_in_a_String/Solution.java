package Reverse_Words_in_a_String;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/reverse-words-in-a-string/
 * @author lianhui
 *
 */

public class Solution {
  
  public String reverseWords(String s) {
    StringBuilder sb = new StringBuilder();
    List<String> lists = new ArrayList<String>();
    String temp = "";
    boolean hasBlank = true;
    for (int i = 0; i <= s.length() -1 ; i++) {
      char c = s.charAt(i);
      if (c == ' ') {
        if (!hasBlank) {
          lists.add(temp);
        }
        temp = "";
        hasBlank = true;
      } else if (i == s.length() -1 ){
        temp += c;
        lists.add(temp);
      } else {
        temp += c;
        hasBlank = false;
      }
    }
    for(int i = lists.size() - 1; i >= 0; i--) {
      sb.append(lists.get(i));
      if (i != 0 ) {
        sb.append(" ");
      }
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    String s = "the sky is blue";
    System.out.println(new Solution().reverseWords(s));
  }

}
