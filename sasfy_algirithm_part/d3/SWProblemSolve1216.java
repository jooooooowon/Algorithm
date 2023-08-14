package Algorithm.sasfy_algirithm_part.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWProblemSolve1216 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int testCase = 0 ; testCase < 10 ; testCase++) {
			int test = Integer.parseInt(br.readLine());
			char[][] arr = new char[100][100];
			for(int i = 0 ; i < 100 ; i++) {
				String str = br.readLine();
				for(int j = 0 ; j < 100 ; j++) {
					arr[i][j] = str.charAt(j);
				}
			}
			
			int max = 0;
			for(int i = 0 ; i < 100 ; i++) {
				for(int j = 0 ; j < 100 ; j++) {
					max = Math.max(make(i,j,arr),max);
				}
			}
			
			sb.append("#").append(test).append(" ").append(max).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	private static int make(int i, int j, char[][] arr) {
		int result = 0;
		for(int endX = 0 ; endX + j < arr.length ; endX++) {
			char[] tempXArr = new char[endX + 1];
			for(int startX = 0 ; startX < endX + 1; startX++) {
				tempXArr[startX] = arr[i][j+startX];
			}
			result = Math.max(result, find(tempXArr));
		}

		for(int endY = 0 ; endY + i < arr.length ; endY++) {
			char[] tempYArr = new char[endY+1];
			for(int startY = 0 ; startY < endY + 1; startY++) {
				tempYArr[startY] = arr[i+startY][j];
			}
			result = Math.max(result, find(tempYArr));
		}
		
		
		return result;
	}
	
	private static int find(char[] arr) {
		int result = 0;
		boolean tf = true;
		for(int i = 0 ; i < arr.length ; i++) {
			if(arr[i] != arr[Math.abs(arr.length - 1 - i)]) {
				tf = false;
				break;
			}
			result++;
		}
		if(tf) {
			return result;
		}else {
			return 0;
		}
		
	}
}
