package Algorithm.sasfy_algirithm_part.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 장훈이의높은선반1486OnlyBitMask {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int testCase = 1; testCase <= test; testCase++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int[] arr = new int[n];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int towerHeight = Integer.MAX_VALUE;
			
			for(int bit = 0 ; bit < 1 << n ; bit++) {
				int temp = 0;
				for(int i = 0 ; i < n ; i++) {
					if((bit & 1 << i) > 0) {
						temp += arr[i];
						if(temp >= towerHeight) {
							break;
						}
					}
				}
				if(temp >= b) {
					towerHeight = Math.min(towerHeight, temp);
				}
			}
			sb.append("#").append(testCase).append(" ").append(towerHeight - b).append("\n");
		}
		System.out.println(sb.toString());
	}
}
