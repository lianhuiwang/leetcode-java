package Repeated_DNA_Sequences;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/repeated-dna-sequences/
 * @author lianhui
 *
 */
public class Repeated_DNA_Sequences {

  public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
      List<String> results = new ArrayList<String>();
      Map<String,Boolean> maps = new HashMap<String,Boolean>();
      for (int i = 0; i + 10 <= s.length(); i++){
        String str = s.substring(i, i + 10);
        if (maps.containsKey(str)) {
          if (! maps.get(str)) {
            results.add(str);
            maps.put(str, true);
          }
        } else {
          maps.put(str, false);
        }
      }
      return results;
    }
  }
  
}
