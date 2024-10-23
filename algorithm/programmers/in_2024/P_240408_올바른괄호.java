package Algorithm.algorithm.programmers.in_2024;

import java.util.Stack;

public class P_240408_올바른괄호 {
  static boolean solution(String s) {
    Stack<Character> stack = new Stack<>();
    if(s.isEmpty()){
      return true;
    }
    stack.push(s.charAt(0));
    for(int i = 1; i < s.length(); i++){
      char ch = s.charAt(i);
      if(ch == '('){
        stack.push(ch);
      }else{
        if(!stack.isEmpty()){
          stack.pop();
        }else{
          return false;
        }
      }
    }
    if(stack.isEmpty()){
      return true;
    }
    return false;
  }

  public static void main(String[] args) {
    System.out.println(solution("(())()"));
    System.out.println(solution(")()("));
    System.out.println(solution(")"));
  }
}
