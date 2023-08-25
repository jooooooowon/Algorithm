package Algorithm.sasfy_algirithm_part.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 정곤이의단조증가하는수6190 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int testCase = 1; testCase <= test ; testCase++) {
			int n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int[] arr = new int[n];
			for(int i = 0 ; i < n ; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			long max = -1;
			for(int i = 0 ; i < n ; i++) {
				for(int j = i + 1; j < n ; j++) {
					long temp = arr[i] * arr[j];
					String str = Long.toString(temp);
					boolean tf = true;
					for(int idx = 0; idx < str.length() - 1; idx++) {
						if(str.charAt(idx) > str.charAt(idx + 1)) {
							tf = false;
							break;
						}
					}
					if(tf) {
						max = Math.max(max, temp);
					}
				}
			}
			sb.append("#").append(testCase).append(" ").append(max).append("\n");
		}
		System.out.println(sb.toString());
	}
}
