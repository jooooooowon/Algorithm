package Algorithm.sasfy_algirithm_part.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 러시아국기같은깃발4613 {
	static char[][] arr;
	static int n;
	static int m;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		StringTokenizer st ;
		StringBuilder sb = new StringBuilder();
		for(int testCase = 1; testCase <= test; testCase++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			arr = new char[n][m];
			for(int i = 0 ; i < n ; i++) {
				String str = br.readLine();
				for(int j = 0 ; j < m ; j++) {
					arr[i][j] = str.charAt(j);
				}
			}
			int min = n * m;
			for(int start = 1 ; start < n - 1 ; start++) {
				for(int end = start ; end < n - 1; end++) {
					min = Math.min(min, find(start,end));
				}
			}
			sb.append("#").append(testCase).append(" ").append(min).append("\n");
		}
		System.out.println(sb.toString());
		
	}
	
	private static int find(int start, int end) {
		int tempSum = 0;
		for(int i = 0 ; i < start ; i++) {
			for(int j = 0 ; j < m ; j++) {
				if(arr[i][j] != 'W') {
					tempSum++;
				}
			}
		}
		for(int i = start ; i <= end ; i++) {
			for(int j = 0 ; j < m ; j++) {
				if(arr[i][j] != 'B') {
					tempSum++;
				}
			}
		}
		for(int i = end + 1; i < n; i++) {
			for(int j = 0 ; j < m ; j++) {
				if(arr[i][j] != 'R') {
					tempSum++;
				}
			}
		}
		return tempSum;
	}
}
