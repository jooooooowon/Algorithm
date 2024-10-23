package Algorithm.algorithm.baekjoon.in_2024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B_240915_괄호 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    for(int i = 0 ; i < n ; i++){
      Stack<Character> stack = new Stack<>();
      String str = br.readLine();
      boolean tf = true;
      for(int j = 0 ; j < str.length(); j++){
        char ch = str.charAt(j);
        if(ch == '('){
          stack.push(ch);
        }else{
          if(stack.isEmpty() || stack.pop() == ')'){
            tf = false;
            break;
          }
        }
      }
      if(!stack.isEmpty()){
        tf = false;
      }
      sb.append(tf ? "YES" : "NO");
      sb.append("\n");
    }
    sb.deleteCharAt(sb.length() - 1);
    System.out.println(sb.toString());
  }
}
