package Algorithm.sasfy_algirithm_part.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWProblemSolve1231 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		StringBuilder sb = new StringBuilder();
		for(int test = 1; test <= 10; test++) {
			int n = Integer.parseInt(br.readLine());
			String[] arr = new String[n+1];
			for(int i = 0 ; i < n ; i++) {
				st = new StringTokenizer(br.readLine());
				int idx = Integer.parseInt(st.nextToken());
				String str = st.nextToken();
				while(st.hasMoreTokens()) {
					st.nextToken();
				}
				arr[idx] = str;
			}
			sb.append("#").append(test).append(" ");
			sb.append(inorder(1, new StringBuilder(), n, arr).toString());
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	private static StringBuilder inorder(int idx , StringBuilder sb, int n, String[] arr) {
		if(idx <= n) {
			sb = inorder(idx * 2 , sb , n , arr);
			sb.append(arr[idx]);
			sb = inorder(idx * 2 + 1, sb , n , arr);
		}
		return sb;
	}
}
