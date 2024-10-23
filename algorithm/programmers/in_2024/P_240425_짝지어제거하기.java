package Algorithm.algorithm.programmers.in_2024;

import java.util.Stack;

public class P_240425_짝지어제거하기 {
  public int solution(String s) {
    int answer;
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      char temp = s.charAt(i);
      if (!stack.isEmpty() && stack.peek() == temp) {
        stack.pop();
      } else {
        stack.push(temp);
      }
    }
    if (stack.isEmpty()) {
      answer = 1;
    } else {
      answer = 0;
    }
    return answer;
  }
}
