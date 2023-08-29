package Algorithm.sasfy_algirithm_part.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 단순2진암호코드1240 {
	static int[] cryp = new int[(int)Math.pow(2, 7)];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Arrays.fill(cryp, -1);
		cryp[13] = 0;
		cryp[25] = 1;
		cryp[19] = 2;
		cryp[61] = 3;
		cryp[35] = 4;
		cryp[49] = 5;
		cryp[47] = 6;
		cryp[59] = 7;
		cryp[55] = 8;
		cryp[11] = 9;
		
		int test = Integer.parseInt(br.readLine());
		StringTokenizer st ;
		StringBuilder sb = new StringBuilder();
		for(int testCase = 1; testCase <= test ; testCase++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int result = 0;
			for(int i = 0 ; i < n ; i++) {
				char[] arr = new char[m];
				String str = br.readLine();
				int idx = -1;
				for(int j = 0 ; j < m ; j++) {
					arr[j] = str.charAt(j);
					if(arr[j] == '1') {
						idx = j;
					}
				}
				if(idx == -1) {
					continue ;
				}
				int count = 8;
				int chkResult = 0;
				result = 0;
				for(int j = idx ; j > idx - 56 ; j -= 7) {
					int temp = make(j,arr);
					if(temp == -1) {
						result = 0;
						chkResult = 0;
						break;
					}else {
						if(count % 2 == 0) {
							chkResult += cryp[temp];
						}else {
							chkResult += cryp[temp] * 3;
						}
						result += cryp[temp];
						count--;
					}
				}
				if(chkResult != 0 && chkResult % 10 != 0) {
					result = 0;
				}
			}
			sb.append("#").append(testCase).append(" ").append(result).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static private int make(int index , char[] arr) {
		int power = 0;
		int result = 0;
		for(int idx = index ; idx > index - 7  ; idx--, power++) {
			int temp = arr[idx] - '0';
			result += temp * Math.pow(2, power);
		}
		return result;
	}
	
}
