package Longest_Substring_Without_Repeating_Characters;

import java.util.Arrays;

public class Solution {
  
  public int lengthOfLongestSubstring(String s) {
    int[] prevPos = new int[256];
    Arrays.fill(prevPos, -1);
    int maxLength = 0;
    int subStringBegin = -1;
    for (int i = 0; i < s.length(); i++) {
      if (prevPos[s.charAt(i)] != -1 && subStringBegin < prevPos[s.charAt(i)]) {
        subStringBegin = prevPos[s.charAt(i)];
      }
      maxLength = Math.max(maxLength, i - subStringBegin);
      prevPos[s.charAt(i)] = i;
    }
    return maxLength;
  }
}
