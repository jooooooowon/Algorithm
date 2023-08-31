package Algorithm.sasfy_algirithm_part.d3;

import java.util.Scanner;

public class SWProblemSolve1217거듭제곱 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		for(int t = 0 ; t < 10 ; t++) {
			int test = sc.nextInt();
			int num = sc.nextInt();
			int power = sc.nextInt();
			int result = pow(num,power);
			sb.append("#").append(test).append(" ").append(result).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	private static int pow(int num , int power) {
		if(power == 0) {
			return 1;
		}
		return num * pow(num, power-1);
	}
}
