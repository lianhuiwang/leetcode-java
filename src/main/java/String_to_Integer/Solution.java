package String_to_Integer;

public class Solution {

  public int myAtoi(String str) {
    int result = 0;
    int index = 0;
    boolean negative = false;
    while(index < str.length() && str.charAt(index) == ' ') {
      index ++;
    }
    if (index == str.length()) {
      return 0;
    }
    if (str.charAt(index) == '-') {
        negative = true;
        index ++;
    } else if (str.charAt(index) == '+') {
        negative = false;
        index ++;
    }
    while(index < str.length()) {
      char c = str.charAt(index);
      int value = c - '0';
      if (value < 0 || value > 9) {
        break;
      }
      if (result > (Integer.MAX_VALUE - value) / 10) {
        if (negative) {
          return Integer.MIN_VALUE;
        } else {
          return Integer.MAX_VALUE;
        }
      }
      result = result * 10 + value;
      index ++;
    }
    return negative ? -result : result;
  }
}
