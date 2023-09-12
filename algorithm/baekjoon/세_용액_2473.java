package Algorithm.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 세_용액_2473 {
	// 시간이 엄청 많다면 n x n x n으로 (조합으로) 풀 수 있겠지만
	// 당연하게 시간 초과가 날 것이기 때문에
	// n x n으로 시간을 줄여서 풀어보자.
	// 우선 투포인터 혹은 이분탐색을 이용해서 값을 찾을 것이기 때문에 정렬을 해준다.
	// 그 후 하나의 값을 n으로 잡고 (이 때 n은 시작점이든 가운데든 끝점이든 상관없다.)
	// 나머지 두 값을 투포인터 혹은 이분탐색으로 찾아주면 끝
	// 이렇게 되면 정렬 n x n 으로 시간초과가 나지 않는다.
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		long[] arr = new long[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		long[] result = new long[3];
		long min = arr[0] + arr[1] + arr[2];
		int start = 0;
		int end = n - 1;
		for(int i = 2 ; i < n ; i++) {
			int tempEnd = i;
			int tempMid = tempEnd - 1;
			int tempStart = 0;
			while (tempStart < tempMid) {
				long tempNum = arr[tempStart] + arr[tempMid] + arr[tempEnd];
				if (Math.abs(tempNum) <= Math.abs(min)) {
					min = tempNum;
					result[0] = arr[tempStart];
					result[1] = arr[tempMid];
					result[2] = arr[tempEnd];
				}
				if (tempNum < 0) {
					tempStart++;
				} else if (tempNum > 0) {
					tempMid--;
				} else {
					break;
				}
			}
			
		}
		
		StringBuilder sb = new StringBuilder();
		for (long temp : result) {
			sb.append(temp).append(" ");
		}
		System.out.println(sb.toString());
	}
}
