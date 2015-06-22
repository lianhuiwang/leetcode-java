package Maximum_Product_Subarray;

import Fraction_to_Recurring_Decimal.Fraction_to_Recurring_Decimal.Solution;

/**
 * https://leetcode.com/problems/maximum-product-subarray/
 * @author lianhui
 *
 */
public class Maximum_Product_Subarray {

  public class Solution {
    public int maxProduct(int[] nums) {
      assert(nums.length > 0);
      int max = nums[0];
      int maxLocal = nums[0];
      int minLocal = nums[0];
      for (int i = 1; i < nums.length; i++) {
        int newMaxLocal = Math.max(Math.max(maxLocal * nums[i], nums[i]), 
            minLocal * nums[i]);
        int newMinLocal = Math.min(Math.min(minLocal * nums[i],  nums[i]),
            maxLocal * nums[i]);
        maxLocal = newMaxLocal;
        minLocal = newMinLocal;
        if (maxLocal > max) {
          max = maxLocal;
        }
      }
      return max;
    }
  }

}
