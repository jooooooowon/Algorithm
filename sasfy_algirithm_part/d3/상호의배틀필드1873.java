package Algorithm.sasfy_algirithm_part.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 상호의배틀필드1873 {
	static int[] dirX = { -1, 0, 1, 0 };
	static int[] dirY = { 0, -1, 0, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int testCase = 1; testCase <= test; testCase++) {
			st = new StringTokenizer(br.readLine());
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			char[][] arr = new char[h][w];
			
			int startY = 0;
			int startX = 0;
			int dir = 0;
			for (int i = 0; i < h; i++) {
				String str = br.readLine();
				for (int j = 0; j < w; j++) {
					arr[i][j] = str.charAt(j);
					if (arr[i][j] == '<' || arr[i][j] == '>' || arr[i][j] == '^' || arr[i][j] == 'v') {
						startY = i;
						startX = j;
						if (arr[i][j] == '<') {
							dir = 0;
						} else if (arr[i][j] == '^') {
							dir = 1;
						} else if (arr[i][j] == '>') {
							dir = 2;
						} else if (arr[i][j] == 'v') {
							dir = 3;
						}
					}
				}
			}
			int n = Integer.parseInt(br.readLine());
			String str = br.readLine();
			for (int i = 0; i < n; i++) {
				if (str.charAt(i) == 'S') {
					for (int j = 1; j < w || j < h; j++) {
						int moveX = dirX[dir] * j + startX;
						int moveY = dirY[dir] * j + startY;
						if (moveX >= 0 && moveX < w && moveY >= 0 && moveY < h) {
							if (arr[moveY][moveX] == '#') {
								break;
							}
							if (arr[moveY][moveX] == '*') {
								arr[moveY][moveX] = '.';
								break;
							}
						}
					}
				} else {
					if (str.charAt(i) == 'L') {
						dir = 0;
					} else if (str.charAt(i) == 'U') {
						dir = 1;
					} else if (str.charAt(i) == 'R') {
						dir = 2;
					} else if (str.charAt(i) == 'D') {
						dir = 3;
					}
					int moveX = dirX[dir] + startX;
					int moveY = dirY[dir] + startY;
					if (moveX >= 0 && moveX < w && moveY >= 0 && moveY < h && arr[moveY][moveX] == '.') {
						arr[startY][startX] = '.';
						startX = moveX;
						startY = moveY;
					}
				}
			}
			char lastTank = '.';
			if (dir == 0) {
				lastTank = '<';
			} else if (dir == 1) {
				lastTank = '^';
			} else if (dir == 2) {
				lastTank = '>';
			} else if (dir == 3) {
				lastTank = 'v';
			}
			arr[startY][startX] = lastTank;
			sb.append("#").append(testCase).append(" ");
			for(int i = 0; i < h ; i++) {
				for(int j = 0 ; j < w ; j++) {
					sb.append(arr[i][j]);
				}
				sb.append("\n");
			}
		}
		System.out.println(sb.toString());
	}
}
