package sasfy_algirithm_part.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Gravity16504 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int testCase = 1; testCase <= test ; testCase++) {
			int len = Integer.parseInt(br.readLine());
			int[] arr = new int[len+1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 1 ; i <= len ; i++){
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int[] afterGravity = new int[101];
			
			for(int i = 1 ; i < afterGravity.length; i++) {
				for(int j = 1 ; j < arr.length; j++) {
					if(arr[j] >= i) {
						afterGravity[i]++;
					}
				}
			}
			
			int max = 0;
			for(int i = 1 ; i < afterGravity.length; i++) {
				int temp = 0;
				for(int j = 1 ; j < arr.length; j++) {
					if(arr[j] >= i) {
						temp = len+1-j-afterGravity[i];
						break;
					}
				}
				if (temp == len) {
					continue;
				}
				max = Math.max(temp, max);
			}
			
			sb.append("#").append(testCase).append(" ").append(max).append("\n");
		}
		System.out.println(sb.toString());
	}
}
