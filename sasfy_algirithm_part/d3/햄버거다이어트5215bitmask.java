package Algorithm.sasfy_algirithm_part.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 햄버거다이어트5215bitmask {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());

		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int testCase = 1; testCase <= test; testCase++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			int[] flavors = new int[n];
			int[] cal = new int[n];
			
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				flavors[i] = Integer.parseInt(st.nextToken());
				cal[i] = Integer.parseInt(st.nextToken());
			}
			int max = 0;
			
			for(int i = 0 ; i < (1 << n) ; i++) {
				int calSum = 0;
				int flvSum = 0;
				for(int j = 0 ; j < n ; j++) {
					if((i & 1 << j) > 0) {
						calSum += cal[j];
						flvSum += flavors[j];
					}
				}
				if(calSum <= l) {
					max = Math.max(flvSum, max);
				}
			}
			sb.append("#").append(testCase).append(" ").append(max).append("\n");
		}
		System.out.println(sb.toString());
	}

}
