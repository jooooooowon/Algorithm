package Algorithm.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Jwon_20230828_B_15684_사다리조작 {
	static int n;
	static int m;
	static int h;
	static int[][] ladder;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());

		// h+2인 이유 만약 6이라면 0~7까지 라고 생각
		// 0 : 시작, 7 : 끝.
		ladder = new int[h+2][n+1];
		for(int i = 0 ; i < m ; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			ladder[y][x] = x+1;
			ladder[y][x+1] = x;
		}
		
		ArrayList<Ladder> ladderList = new ArrayList<>();
		for(int i = 1 ; i < h+1; i++) {
			for(int j = 1 ; j < n ; j++) {
				if(ladder[i][j] == 0) {
					ladderList.add(new Ladder(i,j));
				}
			}
		}
		System.out.println("ladder size : " + ladderList.size());
		boolean[] chk = new boolean[ladderList.size()];
		System.out.println(combination(ladderList,0,0,chk));
	}
	
	private static int combination(ArrayList<Ladder> ladderList, int count ,int start, boolean[] chk) {
		System.out.println("count : " + count);
		System.out.println("start : " + start);
		if(count > 3) {
			System.out.println("here");
			return -1;
		}
		if(chkLadder(chk,ladderList)) {
			System.out.println("here2");
			return count;
		}
		
		for(int i = start ; start < chk.length; i++) {
			System.out.println("i : " + i);
			if(!chk[i]) {
				chk[i] = true;
				count++;
				int temp = combination(ladderList, count+1, start+1, chk);
				if(temp != -1) {
					return temp;
				}
				count--;
				chk[i] = false;
			}
		}
		return -1;
	}

	private static boolean chkLadder(boolean[] chk ,ArrayList<Ladder> ladderList) {
		int[][] tempLadder = new int[h+2][n+1];
		for(int i = 1; i < h + 1; i++) {
			for(int j = 0 ; j < n + 1; j++) {
				tempLadder[i][j] = ladder[i][j];
			}
		}
		for(int i = 0 ; i < chk.length ; i++) {
			if(chk[i]) {
				if(tempLadder[ladderList.get(i).y][ladderList.get(i).x] == 0) {
					tempLadder[ladderList.get(i).y][ladderList.get(i).x] = ladderList.get(i).x+1;
					tempLadder[ladderList.get(i).y][ladderList.get(i).x+1] = ladderList.get(i).x;
				}
			}
		}
		for(int i = 0 ; i < h + 2 ; i++) {
			for(int j = 1 ; j < n + 1 ; j++) {
				System.out.print(tempLadder[i][j] + " ");
			}
			System.out.println();
		}
		
		for(int i = 1 ; i < n ; i++) {
			if(i != dfs(i,1,tempLadder)) {
				return false;
			}
		}
		return true;
	}

	private static int dfs(int x, int y, int[][] tempLadder) {
		if(h + 2 == y) {
			return x;
		}
		
		if(tempLadder[y][x] == 0) {
			return dfs(x,y+1,tempLadder);
		}
		
		return dfs(tempLadder[y][x],y+1,tempLadder);
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
