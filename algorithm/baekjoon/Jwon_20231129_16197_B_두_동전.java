package Algorithm.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Jwon_20231129_16197_B_두_동전 {
	// 10보다 큰면 -1을 표시한다는 말은 곧 10이 최대
	// 따라서 11로 잡아준다.
	static int minCount = 11;
	static int n;
	static int m;
	static char[][] arr;
	static boolean[][][][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new char[n][m];
		
		// 방문처리 해주기, 동전이 두 갠데 두 개의 위치를 모두 기억해주어야 하므로
		// 4중 배열로 체크 해준다.
		visited = new boolean[n][m][n][m];
		Coin[] coins = new Coin[2];
		int coinIndex = 0;
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				arr[i][j] = str.charAt(j);
				if (arr[i][j] == 'o') {
					coins[coinIndex++] = new Coin(i, j);
					arr[i][j] = '.';
				}
			}
		}
		// 두 동전의 위치가 바뀐 상태였을 때도 이미 방문을 한 것과 같으므로 
		// 두 동전의 위치를 각각 저장해준다.
		visited[coins[0].y][coins[0].x][coins[1].y][coins[1].x] = true;
		visited[coins[1].y][coins[1].x][coins[0].y][coins[0].x] = true;
		dfs(coins, 1);
		
		// 10보다 크면 -1
		if (minCount > 10) {
			System.out.println(-1);
		} else {
			System.out.println(minCount);
		}
	}

	// 상 하 우 좌
	static int[] dirY = { 1, -1, 0, 0 };
	static int[] dirX = { 0, 0, 1, -1 };

	private static void dfs(Coin[] coins, int count) {
		// 만약 지금 들어온 count가 현재 제일 작은 minCount보다 크거나 같으면
		// 더 이상 할 필요가 없으므로 return 
		if (minCount <= count) {
			return;
		}


		for (int i = 0; i < 4; i++) {
			// 혹시 모를 깊은 복사
			Coin coin1 = new Coin(coins[0].y, coins[0].x);
			Coin coin2 = new Coin(coins[1].y, coins[1].x);

			coin1.y += dirY[i];
			coin2.y += dirY[i];
			
			coin1.x += dirX[i];
			coin2.x += dirX[i];
			
			// 만약 떨어진 코인이 1이라면 리턴
			// 0이라면 더 이상 dfs에 들어갈 필요가 없으므로 continue
			int leftCoin = 2;
			if (!(coin1.x >= 0 && coin1.x < m && coin1.y >= 0 && coin1.y < n)) {
				leftCoin--;
			}
			if (!(coin2.x >= 0 && coin2.x < m && coin2.y >= 0 && coin2.y < n)) {
				leftCoin--;
			}
			
			Coin[] nextCoins = new Coin[2];
			nextCoins[0] = new Coin(coins[0].y,coins[0].x);
			nextCoins[1] = new Coin(coins[1].y,coins[1].x);

			if (leftCoin == 0) {
				continue;
			} else if (leftCoin == 1) {
				minCount = count;
				return;
			}

			
			// 만약 이동한 곳이 #이라면 그 동전은 이동하지 않는다.
			// 그렇지 않다면 이동한 동전으로 만들어준다.
			if (arr[coin1.y][coin1.x] != '#') {
				nextCoins[0] = coin1;
			}
			if (arr[coin2.y][coin2.x] != '#') {
				nextCoins[1] = coin2;
			}
			
			// 두 코인이 겹쳐있지 않고(두 코인이 겹친다면 하나만 떨어질 수 없으므로 애초에 생각하지 않는다.)
			// 방문처리가 되어 있지 않은 곳이라면
			if (!((nextCoins[0].y == nextCoins[1].y) && (nextCoins[0].x == nextCoins[1].x))
					&& !visited[nextCoins[0].y][nextCoins[0].x][nextCoins[1].y][nextCoins[1].x]
					&& !visited[nextCoins[1].y][nextCoins[1].x][nextCoins[0].y][nextCoins[0].x]) {
				
				// 방문처리를 해준 후 그 다음 단계를 확인한다.
				visited[nextCoins[0].y][nextCoins[0].x][nextCoins[1].y][nextCoins[1].x] = true;
				visited[nextCoins[1].y][nextCoins[1].x][nextCoins[0].y][nextCoins[0].x] = true;
				
				dfs(nextCoins, count + 1);
				
				// 백트래킹 후 복기
				visited[nextCoins[0].y][nextCoins[0].x][nextCoins[1].y][nextCoins[1].x] = false;
				visited[nextCoins[1].y][nextCoins[1].x][nextCoins[0].y][nextCoins[0].x] = false;
			}
		}
	}

	static class Coin {
		int y;
		int x;

		public Coin(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}

		@Override
		public String toString() {
			return "Coin [y=" + y + ", x=" + x + "]";
		}

	}
}
