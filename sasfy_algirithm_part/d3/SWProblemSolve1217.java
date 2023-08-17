package Algorithm.sasfy_algirithm_part.d3;

import java.util.Scanner;

public class SWProblemSolve1217 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		for(int t = 0 ; t < 10 ; t++) {
			int test = sc.nextInt();
			int n = sc.nextInt();
			int m = sc.nextInt();
			int result = power(n,m,1);
			sb.append("#").append(test).append(" ").append(result).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static int power(int n, int m, int count) {
		if(m == count) {
			return n;
		}
		return n * power(n,m,count+1);
	}
}
