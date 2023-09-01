package Algorithm.sasfy_algirithm_part.d5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWProblemSolve1247최적경로 {
	static Coordinate[] arr;
	static Coordinate[] perm;
	static boolean[] chk;
	static int min;
	static Coordinate company;
	static Coordinate home;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());

		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int testCase = 1; testCase <= test; testCase++) {
			int n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			company = new Coordinate(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			home = new Coordinate(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

			arr = new Coordinate[n];
			perm = new Coordinate[n];
			chk = new boolean[n];
			for (int i = 0; i < n; i++) {
				arr[i] = new Coordinate(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			min = Integer.MAX_VALUE;
			find(0, n);
			sb.append("#").append(testCase).append(" ").append(min).append("\n");
		}
		System.out.println(sb.toString());

	}

	private static void find(int idx, int n) {
		if (idx == n) {
			min = Math.min(min, cal());
			return;
		}

		for (int i = 0; i < n; i++) {
			if (!chk[i]) {
				chk[i] = true;
				perm[idx] = arr[i];
				find(idx + 1, n);
				chk[i] = false;
			}
		}

	}

	private static int cal() {
		int result = 0;
		int x = company.x;
		int y = company.y;
		for (int i = 0; i < perm.length; i++) {
			int tempX = perm[i].x;
			int tempY = perm[i].y;
			result += Math.abs(x - tempX) + Math.abs(y - tempY);
			x = tempX;
			y = tempY;
		}
		result += Math.abs(x - home.x) + Math.abs(y - home.y);
		return result;
	}

	static class Coordinate {
		int y;
		int x;

		public Coordinate(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}

	}
}
