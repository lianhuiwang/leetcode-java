package Longest_Palindromic_Substring;

public class LongestPalindromicSubstring {
  public class Solution {
    
    public String test1(String s) {
      int maxLength = 0;
      String result = "";
      for (int i = 0; i < s.length(); i++) {
        for (int j = i; j < s.length(); j++) {
          String str = s.substring(i, j);
          int begin = i;
          int end = j;
          boolean flag = true;
          while (begin < end) {
            if (s.charAt(begin) != s.charAt(end)) {
              flag = false;
              break;
            }
            begin ++;
            end --;
          }
          if (flag && j - i > maxLength) {
            result = str;
          }
        }
      }
      return result;
    }
    
    public String test2(String s) {
      boolean[][] flag = new boolean[s.length()][s.length()];
      int maxLength = 0;
      String maxString = "";
      if(s.length() <=1)  
        return s;
      for (int i = 0; i < s.length(); i++) {
        for (int j = 0; j < s.length(); j++) {
          flag[i][j] = false;
        }
      }
      for (int i = 0; i < s.length(); i++) {
        flag[i][i] = true;
      }
      for (int i = 0; i < s.length() - 1; i++) {
        if(s.charAt(i) == s.charAt(i+1)) {
          flag[i][i+1] = true;
          maxLength = 2;
          maxString = s.substring(i, i + 2);
        }
      }
      for (int i = 3; i < s.length(); i++) {
        for (int j = 0; j < s.length() - i; j++) {
          int end = i + j - 1;
          if (s.charAt(j) == s.charAt(end) && flag[j+1][end - 1]) {
            flag[j][end] = true;
            if (i > maxLength) {
              maxLength = i ;
              maxString = s.substring(j, end + 1);
            }
          } else {
            flag[j][end] = false;
          }
        }
      }
      return maxString;
    }
    
    public String longestPalindrome(String s) {
      return test2(s);
    }
  }
}
