package Largest_Number;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LargestNumber {

  public class Solution {
    public String largestNumber(int[] nums) {
      List<String> numStrs = new ArrayList<String>();
      for (int i = 0; i < nums.length; i++) {
        numStrs.add(String.valueOf(nums[i]));
      }
      Collections.sort(numStrs, new Comparator<String>(){
        public int compare(String str1, String str2) {
          int maxLength = Math.max(str1.length(), str2.length());
          int start = 0;
          while (start < maxLength) {
            char c1 = str1.charAt(start % str1.length());
            char c2 = str2.charAt(start % str2.length());
            int comp = c1 - c2;
            if (comp != 0) {
              return comp;
            }
            start ++;
          }
          return 0;
        }
      });
      String result = "";
      int start = numStrs.size() - 1;
      boolean isZero = true;
      while (start >= 0) {
        String temp = numStrs.get(start);
        if (!temp.equals("0")) {
            isZero = false;
        }
            result += temp;  
        start --;
      }
      if (isZero) {
        result = "0";
      }
      return result;
    }
  }
  
  public static void main(String[] args) {
    
  }
}
