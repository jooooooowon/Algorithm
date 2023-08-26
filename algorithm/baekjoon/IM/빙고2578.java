	package Algorithm.algorithm.baekjoon.IM;
	
	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.util.StringTokenizer;
	
	public class 빙고2578 {
		static int[][] arr = new int[5][5];
		static int num = 0;
		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st;
			for(int i = 0; i < 5 ; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0 ; j < 5 ; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
	
			int count = 0;
			for(int i = 0; i < 5 ; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0 ; j < 5 ; j++) {
					count++;
					int temp = Integer.parseInt(st.nextToken());
					int[] result = find(temp);
					bingo(result[0],result[1]);
					if(num >= 3) {
						System.out.println(count);
						System.exit(0);
					}
				}
			}
		}
		
		private static int[] find(int temp) {
			for(int i = 0 ; i < 5 ; i++) {
				for(int j = 0 ; j < 5 ; j++) {
					if(arr[i][j] == temp) {
						arr[i][j] = 0;
						int[] result = new int[2];
						result[0] = i;
						result[1] = j;
						return result;
					}
				}
			}
			return null;
		}
		
		private static void bingo(int y, int x) {
			boolean tf = true;
			for(int i = 0 ; i < 5 ; i++) {
				if(arr[y][i] != 0) {
					tf = false;
					break;
				}
			}
			if(tf) {
				num++;
			}
			
			tf = true;
			for(int i = 0 ; i < 5 ; i++) {
				if(arr[i][x] != 0) {
					tf = false;
					break;
				}
			}
			if(tf) {
				num++;
			}
			
			if(y == x) {
				tf = true;
				for(int i = 0 ; i < 5 ; i++) {
					if(arr[i][i] != 0) {
						tf = false;
						break;
					}
				}
				if(tf) {
					num++;
				}
			}
			
			if(y + x == 4) {
				tf = true;
				for(int i = 0 ; i < 5 ; i++) {
					if(arr[i][4-i] != 0) {
						tf = false;
						break;
					}
				}
				if(tf) {
					num++;
				}
			}
	
			
		}
	}
