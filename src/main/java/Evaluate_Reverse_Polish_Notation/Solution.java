package Evaluate_Reverse_Polish_Notation;

import java.util.ArrayDeque;
import java.util.Stack;

public class Solution {
  
  public int eval(int v1, int v2, int type) {
    switch(type) {
    case 1:
      return v2 + v1;
    case 2:
      return v2 - v1;
    case 3:
      return v2 * v1;
    case 4:
      return v2 / v1;
    }
    return 0;
  }
  
  public int evalRPN(String[] tokens) {
    int result = 0;
    Stack<Integer> stack = new Stack<Integer>();
    int i = 0;
    while(i < tokens.length) {
      String word = tokens[i];
      switch(word) {
      case "+" :
        stack.push(this.eval(stack.pop(), stack.pop(), 1));
        break;
      case "-" :
        stack.push(this.eval(stack.pop(), stack.pop(), 2));
        break;
      case "*" :
        stack.push(this.eval(stack.pop(), stack.pop(), 3));
        break;
      case "/" :
        stack.push(this.eval(stack.pop(), stack.pop(), 4));
        break;
      default:
        stack.push(Integer.valueOf(word));
      }
      i += 1;
    }
    if (stack.size() > 0) {
      result = stack.pop();
    }
    return result;
    
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub

    String[] tokens = 
        new String[]{"2", "1", "+", "3", "*"};
    System.out.println(new Solution().evalRPN(tokens));
  }

}
