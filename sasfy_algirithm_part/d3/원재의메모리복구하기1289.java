package Algorithm.sasfy_algirithm_part.d3;

import java.util.Scanner;

public class 원재의메모리복구하기1289 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for(int testCase = 1; testCase <= test ; testCase++) {
			String str = sc.next();
			int count = 0;
			char temp = '0';
			for(int i = 0 ; i < str.length(); i++) {
				if(temp != str.charAt(i)) {
					temp = str.charAt(i);
					count++;
				}
			}
			sb.append("#").append(testCase).append(" ").append(count).append("\n");
		}
		System.out.println(sb.toString());
	}
}
