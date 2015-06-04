package Two_Sum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TwoSum {

  public class Solution {
    public int[] twoSum(int[] nums, int target) {
      List<Integer> lists = new ArrayList<Integer>();
      HashMap<Integer,Integer> index = new HashMap<Integer,Integer>();
      for (int i = 0; i < nums.length; i++) {
        Integer num = target - nums[i];
        if (index.containsKey(num)) {
          int index2 = index.get(num);
          int index1 = i+1;
          if (index1 > index2) {
            int tmp = index2;
            index2 = index1;
            index1 = tmp;
          }
          lists.add(index1);
          lists.add(index2);
          break;
        }
        index.put(nums[i], i+1);
      }
      int[] results = new int[lists.size()];
      for (int i = 0; i < lists.size(); i++) {
        results[i] = lists.get(i);
      }
      return results;
    }
  }

}
