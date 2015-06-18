package Find_Minimum_in_Rotated_Sorted_Array;

/**
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 * @author lianhui
 *
 */
public class Find_Minimum_in_Rotated_Sorted_Array {

  public class Solution {
    public int findMin(int[] nums) {
      assert (nums.length > 0);
      int start = 0;
      int end = nums.length - 1;
      while (start < end) {
        if (nums[start] < nums[end]) {
           break;
        }
        int mid = (start + end) / 2;
        if (nums[mid] > nums[start]) {
          start = mid + 1;
        } else if (nums[mid] < nums[end]){
          end = mid;
        } else {
          start = mid + 1;
        }
      }
      return nums[start];
    }
  }
  
}
