package Algorithm.sasfy_algirithm_part.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CutFly12712 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int testCase = 1; testCase <= test ; testCase++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			int[][] arr = new int[n+m+m][n+m+m];
			for(int i = m ; i < n + m; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = m ; j < n + m; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int max = 0;
			
			for(int i = m ; i < n + m; i++) {
				for(int j = m ; j < n + m; j++) {
					int temp = 0;
					for(int y = i - m + 1; y < i + m ; y++) {
						temp += arr[y][j];
					}
					for(int x = j - m + 1; x < j + m ; x++) {
						temp += arr[i][x];
					}
					temp -= arr[i][j];
					max = Math.max(max, temp);
					
					temp = 0;
					for(int x = j - m + 1, y = i - m + 1; x < j + m ; x++, y++) {
						temp += arr[y][x];
					}
					for(int x = j - m + 1, y = i + m - 1; x < j + m ; x++, y--) {
						temp += arr[y][x];
					}
					temp -= arr[i][j];
					max = Math.max(max,temp);
				
				}
			}
			
			sb.append("#").append(testCase).append(" ").append(max).append("\n");
			
		}
		System.out.println(sb.toString());
		
	}
}
