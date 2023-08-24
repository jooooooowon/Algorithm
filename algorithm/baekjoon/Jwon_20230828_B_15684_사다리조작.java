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
		ladder = new int[h + 2][n + 1];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			ladder[y][x] = x + 1;
			ladder[y][x + 1] = x;
		}
		for (int i = 0; i < h + 2; i++) {
			for (int j = 1; j < n + 1; j++) {
				System.out.print(ladder[i][j] + " ");
			}
			System.out.println();
		}

		ArrayList<Ladder> ladderList = new ArrayList<>();
		for (int i = 1; i < h + 1; i++) {
			for (int j = 1; j < n; j++) {
				if (ladder[i][j] == 0) {
					System.out.print("i : " + i);
					System.out.println(" j : " + j);
					ladderList.add(new Ladder(i, j));
				}
			}
		}
		System.out.println("ladder size : " + ladderList.size());
		System.out.println(combination(ladderList, 0, 0));
	}

	private static int combination(ArrayList<Ladder> ladderList, int start, int count) {
		if (count > 3) {
			return -1;
		} else {
			boolean tf = true;
			for (int j = 1; j < n + 1; j++) {
				int result = dfs(j, 0);
				if (result != j) {
					tf = false;
					break;
				}
			}
			if (tf) {
				System.out.println("end count : " + count);
				return count;
			}
		}
		for (int i = start; i < ladderList.size(); i++) {
			Ladder temp = ladderList.get(i);
			if (ladder[temp.y][temp.x] == 0 && ladder[temp.y][temp.x + 1] == 0) {
				ladder[temp.y][temp.x] = temp.x + 1;
				ladder[temp.y][temp.x + 1] = temp.x;
				System.out.println("count : " + count);
				for (int y = 0; y < h + 2; y++) {
					for (int x = 1; x < n + 1; x++) {
						System.out.print(ladder[y][x] + " ");
					}
					System.out.println();
				}
				int result = combination(ladderList, start + 1, count + 1);
				ladder[temp.y][temp.x] = 0;
				ladder[temp.y][temp.x + 1] = 0;
				if (result != -1) {
					return result;
				}
			} else {
				int result = combination(ladderList, start + 1, count + 1);
				if (result != -1) {
					return result;
				}
			}
		}
		return -1;
	}

	private static int dfs(int x, int y) {
		if (h + 1 == y) {
			return x;
		}

		if (ladder[y][x] == 0) {
			return dfs(x, y + 1);
		}

		return dfs(ladder[y][x], y + 1);
	}

	static class Ladder {
		int y;
		int x;

		public Ladder(int y, int x) {
			this.y = y;
			this.x = x;
		}

	}

}
