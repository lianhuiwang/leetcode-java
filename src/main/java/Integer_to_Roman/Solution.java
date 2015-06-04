package Integer_to_Roman;

public class Solution {

  private final char[] symbols = new char[] { 'M', 'D', 'C', 'L', 'X',
      'V', 'I' };
  int value[]= {1000, 500, 100, 50, 10, 5, 1};
  
  public String repeat(char c, int times) {
    StringBuilder sb =new StringBuilder();
    for( int i = 0; i < times; i++) {
      sb.append(c);
    }
    return sb.toString();
  }
  
  public String intToRoman(int num) {
    if (num < 0 || num > 3999) {
      return "";
    }
    int scale =  1000;
    String str = "";
    for( int i = 0; i < value.length; i+=2) {
      int digit = num / scale;
      num = num % scale;
      scale = scale / 10;
      if (digit == 9) {
        str += symbols[i];
        str += symbols[i-2];
      } else if (digit >= 5) {
        int repeat = digit - 5;
        str += symbols[i-1];
        str += repeat(symbols[i], repeat);
      } else if (digit == 4) {
        str += symbols[i];
        str += symbols[i-1];
      } else {
        str += repeat(symbols[i], digit);
      }
      System.out.println(str);
    }
    return str;
  }
  
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    int num = 3999;
    System.out.println(new Solution().intToRoman(num));
  }

}
