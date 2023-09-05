package Algorithm.algorithm.baekjoon.A형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 구슬탈출2_13460 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		char[][] arr = new char[row][col];
		Marble marble = new Marble(); // 0 : red, 1 : blue
		for (int i = 0; i < row; i++) {
			String str = br.readLine();
			for (int j = 0; j < col; j++) {
				arr[i][j] = str.charAt(j);
				if (arr[i][j] == 'R') {
					marble.redY = i;
					marble.redX = j;
				}
				if (arr[i][j] == 'B') {
					marble.blueY = i;
					marble.blueX = j;
				}
			}
		}

		Queue<Marble> queue = new LinkedList<>();
		queue.offer(marble);
		int[] dirX = { 0, 0, -1, 1 };
		int[] dirY = { 1, -1, 0, 0 };

		int count = -1;
		while (queue.isEmpty()) {
			Marble temp = queue.poll();
			if (temp.blueY == -1) {
				continue;
			} else if (temp.redX == -1) {
				count = temp.count;
				break;
			}
			for (int i = 0; i < 4; i++) {
				// 상
				if (i == 0) {
					if (temp.blueX == temp.redX) {
						if (temp.blueY > temp.redY) {
							while (arr[temp.blueY][temp.blueX] == '.') {
								if (arr[temp.blueY + 1][temp.blueX] == '#') {
									break;
								}
								temp.blueY++;
							}
							temp.redY = temp.blueY - 1;
							temp.count += 1;
							queue.offer(temp);
						} else {
							while (arr[temp.redY][temp.redX] == '.') {
								if (arr[temp.redY + 1][temp.redX] == '#') {
									break;
								}
								temp.redY++;
							}
							temp.blueY = temp.redY - 1;
							temp.count += 1;
							queue.offer(temp);
						}
					} else {
						while (arr[temp.redY][temp.redX] == '.') {
							if (arr[temp.redY + 1][temp.redX] == '#') {
								break;
							}
							temp.redY++;
						}
						while (arr[temp.blueY][temp.blueX] == '.') {
							if (arr[temp.blueY + 1][temp.blueX] == '#') {
								break;
							}
							temp.blueY++;
						}
						temp.count += 1;
						queue.offer(temp);
					}
				}
				// 하
				if (i == 1) {
					if (temp.blueX == temp.redX) {
						if (temp.blueY < temp.redY) {
							while (arr[temp.blueY][temp.blueX] == '.') {
								if (arr[temp.blueY - 1][temp.blueX] == '#') {
									break;
								}
								temp.blueY--;
							}
							temp.redY = temp.blueY + 1;
							temp.count += 1;
							queue.offer(temp);
						} else {
							while (arr[temp.redY][temp.redX] == '.') {
								if (arr[temp.redY - 1][temp.redX] == '#') {
									break;
								}
								temp.redY--;
							}
							temp.blueY = temp.redY + 1;
							temp.count += 1;
							queue.offer(temp);
						}
					} else {
						while (arr[temp.redY][temp.redX] == '.') {
							if (arr[temp.redY - 1][temp.redX] == '#') {
								break;
							}
							temp.redY--;
						}
						while (arr[temp.blueY][temp.blueX] == '.') {
							if (arr[temp.blueY - 1][temp.blueX] == '#') {
								break;
							}
							temp.blueY--;
						}
						temp.count += 1;
						queue.offer(temp);
					}
				}
				// 좌
				if (i == 2) {
					if (temp.blueY == temp.redY) {
						if (temp.blueX < temp.redX) {
							while (arr[temp.blueY][temp.blueX] == '.') {
								if (arr[temp.blueY][temp.blueX - 1] == '#') {
									break;
								}
								temp.blueX--;
							}
							temp.redX = temp.blueX + 1;
							temp.count += 1;
							queue.offer(temp);
						} else {
							while (arr[temp.redY][temp.redX] == '.') {
								if (arr[temp.redY][temp.redX - 1] == '#') {
									break;
								}
								temp.redX--;
							}
							temp.blueX = temp.redX + 1;
							temp.count += 1;
							queue.offer(temp);
						}
					} else {
						while (arr[temp.redY][temp.redX] == '.') {
							if (arr[temp.redY][temp.redX - 1] == '#') {
								break;
							}
							temp.redX--;
						}
						while (arr[temp.blueY][temp.blueX] == '.') {
							if (arr[temp.blueY][temp.blueX - 1] == '#') {
								break;
							}
							temp.blueX--;
						}
						temp.count += 1;
						queue.offer(temp);
					}
				}
				// 우
				if (i == 3) {
					if (temp.blueY == temp.redY) {
						if (temp.blueX > temp.redX) {
							while (arr[temp.blueY][temp.blueX] == '.') {
								if (arr[temp.blueY][temp.blueX + 1] == '#') {
									break;
								}
								temp.blueX++;
							}
							temp.redX = temp.blueX - 1;
							temp.count += 1;
							queue.offer(temp);
						} else {
							while (arr[temp.redY][temp.redX] == '.') {
								if (arr[temp.redY][temp.redX + 1] == '#') {
									break;
								}
								temp.redX++;
							}
							temp.blueX = temp.redX - 1;
							temp.count += 1;
							queue.offer(temp);
						}
					} else {
						while (arr[temp.redY][temp.redX] == '.') {
							if (arr[temp.redY][temp.redX + 1] == '#') {
								break;
							}
							temp.redX++;
						}
						while (arr[temp.blueY][temp.blueX] == '.') {
							if (arr[temp.blueY][temp.blueX + 1] == '#') {
								break;
							}
							temp.blueX++;
						}
						temp.count += 1;
						queue.offer(temp);
					}
				}
			}

		}
	}

	static class Marble {
		int redY;
		int redX;
		int blueY;
		int blueX;
		int count;

		public Marble() {

		}

		public Marble(int redY, int redX, int blueY, int blueX, int count) {
			super();
			this.redY = redY;
			this.redX = redX;
			this.blueY = blueY;
			this.blueX = blueX;
			this.count = count;
		}

	}
}
