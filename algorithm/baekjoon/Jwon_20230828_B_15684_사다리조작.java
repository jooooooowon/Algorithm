package Algorithm.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Jwon_20230828_B_15684_사다리조작 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());

		// h+2인 이유 만약 6이라면 0~7까지 라고 생각
		// 0 : 시작, 7 : 끝.
		int[][] ladder = new int[h+2][n];
		for(int i = 0 ; i < m ; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			ladder[y][x] = x+1;
			ladder[y][x+1] = x;
		}
		
		ArrayList<Ladder> ladderList = new ArrayList<>();
		for(int i = 1 ; i < h+1; i++) {
			for(int j = 0 ; j < n ; j++) {
				if(ladder[i][j] == 0) {
					ladderList.add(new Ladder(i,j));
				}
			}
		}
		
		
		combination(ladderList,m,new ArrayList<>());
	}
	
	private static int combination(ArrayList<Ladder> ladderList, int m, ArrayList arrayList) {
		int result =0;
		return result;
	}

	static class Ladder{
		int y;
		int x;
		public Ladder(int y, int x) {
			this.y = y;
			this.x = x;
		}
		
	}
	
}
