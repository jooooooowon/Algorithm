package Algorithm.algorithm.baekjoon.in_2024;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_241031_파이프옮기기_1_17070 {
  static int[][] arr;

  static int n;
  static int answer = 0;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    arr = new int[n][n];
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    dfs(0, 1, 0);
    System.out.println(answer);
  }

  // direction 0 : 가로, 1 : 대각선, 2 : 세로
  static void dfs(int y, int x, int direction) {
    if (y == n - 1 && x == n - 1) {
      answer++;
      return;
    }
    if (direction == 0) {
      if (x + 1 < n && arr[y][x + 1] == 0) dfs(y, x + 1, 0);
      if (x + 1 < n && y + 1 < n && arr[y + 1][x + 1] == 0 && arr[y][x + 1] == 0 && arr[y + 1][x] == 0) dfs(y + 1, x + 1, 1);
    } else if (direction == 1) {
      if (x + 1 < n && arr[y][x + 1] == 0) dfs(y, x + 1, 0);
      if (x + 1 < n && y + 1 < n && arr[y + 1][x + 1] == 0 && arr[y][x + 1] == 0 && arr[y + 1][x] == 0)
        dfs(y + 1, x + 1, 1);
      if (y + 1 < n && arr[y + 1][x] == 0) dfs(y + 1, x, 2);
    } else {
      if (x + 1 < n && y + 1 < n && arr[y + 1][x + 1] == 0 && arr[y][x + 1] == 0 && arr[y + 1][x] == 0) dfs(y + 1, x + 1, 1);
      if (y + 1 < n && arr[y + 1][x] == 0) dfs(y + 1, x, 2);
    }
  }
}
