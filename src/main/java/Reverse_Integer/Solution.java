package Reverse_Integer;

public class Solution {
  public int reverse(int x) {
    boolean negative = false;
    if (x < 0) {
      negative = true;
      x = -x;
    }
    int y = 0;
    while(x != 0) {
      int mod = x % 10;
      if (y > (Integer.MAX_VALUE - mod) / 10) {
        return 0;
      }
      y = y * 10 + mod;
      x = x / 10;
    }
    return negative ? -y : y;
  }
}
