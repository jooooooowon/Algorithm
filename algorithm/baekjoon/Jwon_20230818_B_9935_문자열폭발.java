package Algorithm.algorithm.baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class Jwon_20230818_B_9935_문자열폭발 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		String bumbStr = sc.next();
		Stack<String> stack = new Stack<>();
		for(int i = str.length() - 1; i >= 0 ; i--) {
			stack.push(Character.toString(str.charAt(i)));
		}
		
	}
}
