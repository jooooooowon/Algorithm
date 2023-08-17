package Algorithm.algorithm.baekjoon;

import java.util.Scanner;

public class Jwon_20230818_B_9935_문자열폭발_메모리초과 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		String bumbStr = sc.next();
		char[] strArr = str.toCharArray();
		char[] bumbArr = bumbStr.toCharArray();
		// 문자열 str에 폭발 문자열 bumbStr이 들어있다면 계속 반복문을 돌린다.
		while(str.contains(bumbStr)) {
			// 폭발 문자열이 존재하는 index를 찾기 위한 tf
			boolean tf = true;
			// 폭발 문자열이 존재하는 처음 index
			int tempIdx = 0;
			
			// 현재의 인덱스와 폭발 문자열의 길이의 크기가 문자열의 길이의 크기보다 작을 때까지 확인한다.
			// 현재의 인덱스와 폭발 문자열의 길이의 크기가 문자열의 길이보다 더 크다면 찾을 필요가 없기 때문.
			for(int i = 0 ; i + bumbArr.length <= strArr.length; i++) {
				tf = true;
				// 폭발 문자열의 char를 하나하나 확인하다가
				for(int j = 0 ; j < bumbArr.length ; j++) {
					// 다른 것이 나오면 false
					if(strArr[i+j] != bumbArr[j]) {
						tf = false;
						break;
					}
				}
				// 혹시 폭발 문자열과 같은 곳이 나온다면 시작 index를 저장해둔다.
				if(tf) {
					tempIdx = i;
					break;
				}
			}
			if(tf) {
				// 문자열 폭발시키고 다시 붙히는 작업.
				StringBuilder sb = new StringBuilder();
				sb.append(str.substring(0, tempIdx));
				sb.append(str.substring(tempIdx+bumbArr.length));
				str = sb.toString();
				strArr = str.toCharArray();
			}
		}
		if(str.length() == 0) {
			str = "FRULA";
		}
		System.out.println(str);
	}
}
