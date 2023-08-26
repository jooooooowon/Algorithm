package Algorithm.algorithm.baekjoon.IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 참외밭2477 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int w = 0;
		int h = 0;
		int emptyBoxW = 0;
		int emptyBoxH = 0;
		int[] lenArr = new int[6];
		int[] dirArr = new int[6];
		for(int i = 0 ; i < 6; i++) {
			st = new StringTokenizer(br.readLine());
			dirArr[i] = Integer.parseInt(st.nextToken());
			lenArr[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 0 ; i < 6 ; i++) {
			if(dirArr[i] == 1 || dirArr[i] == 2) {
				w = Math.max(w, lenArr[i]);
			}else if(dirArr[i] == 3 || dirArr[i] == 4) {
				h = Math.max(h, lenArr[i]);
			}
			int curr = i;
			int next = curr + 1;
			if(next >= 6) {
				next = 0;
			}
			
			if(dirArr[curr] == 1 && dirArr[next] == 3) {
				emptyBoxW = lenArr[curr];
				emptyBoxH = lenArr[next];
			}else if(dirArr[curr] == 2 && dirArr[next] == 4) {
				emptyBoxW = lenArr[curr];
				emptyBoxH = lenArr[next];
			}else if(dirArr[curr] == 3 && dirArr[next] == 2) {
				emptyBoxH = lenArr[curr];
				emptyBoxW = lenArr[next];
			}else if(dirArr[curr] == 4 && dirArr[next] == 1) {
				emptyBoxH = lenArr[curr];
				emptyBoxW = lenArr[next];
			}
		}
		int result = ((w * h) - (emptyBoxW * emptyBoxH)) * n;
		System.out.println(result);
	}
}
