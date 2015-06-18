package Find_Peak_Element;

/**
 * https://leetcode.com/problems/find-peak-element/
 * @author lianhui
 *
 */
public class FindPeakElement {
  
  public class Solution {
    public int findPeakElement(int[] nums) {
      int start = 0;
      while (start < nums.length - 1) {
        if (nums[start] > nums[start + 1]) {
          break;
        }
        start ++;
      }
      return start;
    }
  }
  
}
