package Two_Sum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TwoSum2 {

  public class Solution {
    public int[] twoSum(int[] nums, int target) {
      List<Integer> lists = new ArrayList<Integer>();
      for (int i = 0;i < nums.length;i++) {
        lists.add(i);
      }
      Collections.sort(lists, new Comparator<Integer>(){

        @Override
        public int compare(Integer o1, Integer o2) {
          // TODO Auto-generated method stub
          return nums[o1] - nums[o2];
        }
        
      });
      
      int start = 0;
      int end = nums.length - 1;
      while (start < end) {
        int sum = nums[lists.get(start)] + nums[lists.get(end)];
        if (sum > target) {
          end --;
        } else if (sum < target) {
          start ++;
        } else {
          int[] results = new int[2];
          int index1 = lists.get(start) + 1;
          int index2 = lists.get(end) + 1;
          results[0] = Math.min(index1, index2);
          results[1] = Math.max(index1, index2);
          return results;
        }
      }
      return null;
    }
  }
  
}
