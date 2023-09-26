package Algorithm.algorithm.baekjoon;

import java.util.Scanner;

public class 성냥개비3687 {
	static String[] minArr = new String[101];

	// 어쩔 수 없는 것들은 하드코딩을 해주고,
	// 새로 들어온 것들은 0,1,2,4,7,8 순으로 차례대로 뒤에 붙여서 모두 비교해준다.
	// 예를 들면 현재 성냥개비의 숫자가 n이고 0을 뒤에 넣는다면
	// 0은 성냥 개비 6개가 사용되므로 성냥개비를 n - 6 사용한 숫자에 0을 붙여서 확인해준다.
	// 가장 값이 작은 것이 곧 정답이다.
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		minArr[2] = "1";
		minArr[3] = "7";
		minArr[4] = "4";
		minArr[5] = "2";
		minArr[6] = "6";
		minArr[7] = "8";

		String[] maxArr = new String[101];
		maxArr[2] = "1";
		maxArr[3] = "7";
		for (int i = 4; i < 101; i++) {
			StringBuilder sb = new StringBuilder(maxArr[i - 2]);
			sb.append("1");
			maxArr[i] = sb.toString();
		}
		for (int i = 8; i < 101; i++) {
			makeMin(i);
		}

		int test = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for (int testCase = 0; testCase < test; testCase++) {
			int n = sc.nextInt();
			sb.append(minArr[n]).append(" ").append(maxArr[n]).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static String makeMin(int i) {
		if (i == 1) {
			return null;
		}
		if (minArr[i] != null) {
			return minArr[i];
		}

		StringBuilder sb = new StringBuilder();
		String str = makeMin(i - 6);
		if (str != null) {
			sb.append(str).append("0");
			minArr[i] = sb.toString();
		}
		sb = new StringBuilder();
		str = makeMin(i - 2);
		if (str != null) {
			sb.append(str).append("1");
			minArr[i] = Long.toString(Math.min(Long.parseLong(minArr[i]), Long.parseLong(sb.toString())));
		}
		sb = new StringBuilder();
		str = makeMin(i - 5);
		if (str != null) {
			sb.append(str).append("2");
			minArr[i] = Long.toString(Math.min(Long.parseLong(minArr[i]), Long.parseLong(sb.toString())));
		}
		sb = new StringBuilder();
		str = makeMin(i - 4);
		if (str != null) {
			sb.append(str).append("4");
			minArr[i] = Long.toString(Math.min(Long.parseLong(minArr[i]), Long.parseLong(sb.toString())));
		}
		sb = new StringBuilder();
		str = makeMin(i - 3);
		if (str != null) {
			sb.append(str).append("7");
			minArr[i] = Long.toString(Math.min(Long.parseLong(minArr[i]), Long.parseLong(sb.toString())));
		}
		sb = new StringBuilder();
		str = makeMin(i - 7);
		if (str != null) {
			sb.append(str).append("8");
			minArr[i] = Long.toString(Math.min(Long.parseLong(minArr[i]), Long.parseLong(sb.toString())));
		}
		return minArr[i];
	}
}
