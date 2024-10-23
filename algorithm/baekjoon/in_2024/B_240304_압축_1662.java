package Algorithm.algorithm.baekjoon.in_2024;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class B_240304_압축_1662 {
    public static void main(String[] args) throws Exception {
        String str = new BufferedReader(new InputStreamReader(System.in)).readLine();
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char now = str.charAt(i);
            if (now != ')') {
                stack.push(String.valueOf(now));
            } else {
                int count = 0;
                while (!stack.peek().equals("(")) {
                    String top = stack.pop();
                    if (top.equals("+")) {
                        int len = Integer.parseInt(stack.pop());
                        count += len;
                    } else {
                        count++;
                    }
                }
                stack.pop();
                int temp = Integer.parseInt(stack.pop());
                count = count * temp;
                stack.push(String.valueOf(count));
                stack.push("+");
            }
        }
        int result = 0;
        while (!stack.isEmpty()) {
            if (stack.peek().equals("+")) {
                stack.pop();
                result += Integer.parseInt(stack.pop());
            } else {
                stack.pop();
                result++;
            }
        }
        System.out.println(result);
    }
}
