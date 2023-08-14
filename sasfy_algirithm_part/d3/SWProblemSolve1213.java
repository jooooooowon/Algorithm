package Algorithm.sasfy_algirithm_part.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWProblemSolve1213 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int testCase = 0 ; testCase < 10 ; testCase++) {
			int test = Integer.parseInt(br.readLine());
			String findStr = br.readLine();
			char[] findArr = findStr.toCharArray();
			
			String str = br.readLine();
			char[] strArr = str.toCharArray();
			
			int count = 0;
			for(int i = 0 ; i + findArr.length <= strArr.length; i++) {
				char[] temp = new char[findArr.length];
				for(int j = 0 ; j < findArr.length ; j++) {
					temp[j] = strArr[j+i];
				}
				boolean tf = true;
				for(int j = 0 ; j < findArr.length ; j++) {
					if(temp[j] != findArr[j]) {
						tf = false;
						break;
					}
				}
				if(tf) {
					count++;
				}
			}
			sb.append("#").append(test).append(" ").append(count).append("\n");
		}
		System.out.println(sb.toString());
	}
}
