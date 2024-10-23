package Algorithm.algorithm.baekjoon.in_2024;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class B_240915_균형잡힌_세상 {
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    while(true){
      String str = br.readLine();
      boolean tf = true;
      if(str.equals(".")){
        break;
      }
      Stack<Character> stack = new Stack<>();
      for(char ch : str.toCharArray()){
        if(ch  == '(' || ch == '['){
          stack.push(ch);
        }else if (ch == ')' || ch == ']'){
          if(stack.isEmpty()){
            tf = false;
            break;
          }
          char top = stack.pop();
          if(!((top == '(' && ch == ')') || (top == '[' && ch == ']'))){
            tf = false;
            break;
          }
        }
      }
      if(!stack.isEmpty()){
        tf = false;
      }
      sb.append(tf == true ? "yes" : "no");
      sb.append("\n");
    }
    sb.deleteCharAt(sb.length() - 1);
    System.out.println(sb.toString());
  }
}
