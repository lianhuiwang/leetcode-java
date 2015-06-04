package Palindrome_Number;

public class Solution {
  public boolean isPalindrome(int x) {
    if (x == 0) {
      return true;
    }
    if (x < 0 || x % 10 == 0) {
      return false;
    }
    int len = 0;
    int y = x;
    while(y > 0) {
      len ++;
      y = y / 10;
    }
    System.out.println(len);
    int end = len / 2;
    if (end % 2 == 0) {
      end = end + 1;
    }
    int left = x;
    int right = 0;
    int index = 0;
    do {
      if (right == left / 10 || right == left ) {
        return true;
      }
      right = right * 10 + left % 10;
      left = left / 10;
      index ++;
    } while(left > right);
    return left == right;
  }
  
  public static void main(String [] args) {
    int x = 121;
    System.out.println(new Solution().isPalindrome(x));
  }
}