package Algorithm.sasfy_algirithm_part.d2;

import java.util.Scanner;

public class BeginnersPalindromeCheck1989 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for(int testCase = 1 ; testCase <= test ; testCase++) {
			String str = sc.next();
			char[] arr = str.toCharArray();
			boolean tf = true;
			for(int i = 0 ; i < arr.length/2 ; i++) {
				if(arr[i] != arr[arr.length - 1 - i]) {
					tf = false;
					break;
				}
			}

			int result = 0;
			if(tf) {
				result = 1;
			}
			sb.append("#").append(testCase).append(" ").append(result).append("\n");
		}
		System.out.println(sb.toString());
	}
}
