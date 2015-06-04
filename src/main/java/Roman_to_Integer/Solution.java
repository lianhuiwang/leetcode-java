package Roman_to_Integer;

import java.util.Arrays;
import java.util.Collections;

public class Solution {

  private final char[] symbols = new char[] { 'M', 'D', 'C', 'L', 'X',
      'V', 'I' };
  int value[]= {1000, 500, 100, 50, 10, 5, 1};
  
//  public int romanToInt(String s) {
//    int result = 0;
////    Arrays.sort(a);
////    Collections.sort(list);
//  }
  
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    String str = "MMMCMXCIX";
    System.out.println(new Solution().romanToInt(str));
  }

}
