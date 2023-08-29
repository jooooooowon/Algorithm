package Algorithm.sasfy_algirithm_part.d3;

import java.util.Scanner;

public class 이진수표현10726 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for(int testCase = 1 ; testCase <= test; testCase++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int temp = (int)Math.pow(2,n)-1;
			
			sb.append("#").append(testCase).append(" ");
			if((m & temp) == temp) {
				sb.append("ON");
			}else {
				sb.append("OFF");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
