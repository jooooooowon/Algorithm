package Algorithm.algorithm.programmers.in_2024;

import java.util.*;

public class P_241117_모의고사2_보물지도 {
  public int solution(int n, int m, int[][] hole) {
    int answer = 0;
    int[] dirY = {1, -1, 0, 0};
    int[] dirX = {0, 0, 1, -1};
    int[][][] dp = new int[n][m][2];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        dp[i][j][0] = Integer.MAX_VALUE;
        dp[i][j][1] = Integer.MAX_VALUE;
      }
    }
    boolean[][] holeArr = new boolean[n][m];
    for (int[] arr : hole) {
      holeArr[arr[0] - 1][arr[1] - 1] = true;
    }
    Queue<Node> queue = new LinkedList<>();
    queue.offer(new Node(0, 0, true));
    dp[0][0][0] = 0;
    while (!queue.isEmpty()) {
      Node node = queue.poll();
      for (int i = 0; i < 4; i++) {
        int nextY = node.y + dirY[i];
        int nextX = node.x + dirX[i];
        if (nextY >= 0 && nextY < n && nextX >= 0 && nextX < m && !holeArr[nextY][nextX]) {
          if (node.jump && dp[nextY][nextX][0] > dp[node.y][node.x][0] + 1) {
            queue.offer(new Node(nextY, nextX, node.jump));
            dp[nextY][nextX][0] = dp[node.y][node.x][0] + 1;
          } else if (!node.jump && dp[nextY][nextX][1] > dp[node.y][node.x][1] + 1) {
            queue.offer(new Node(nextY, nextX, node.jump));
            dp[nextY][nextX][1] = dp[node.y][node.x][1] + 1;
          }
        }
        if (node.jump) {
          nextY += dirY[i];
          nextX += dirX[i];
          if (nextY >= 0 && nextY < n && nextX >= 0 && nextX < m && !holeArr[nextY][nextX]) {
            if (dp[nextY][nextX][1] > dp[node.y][node.x][0] + 1) {
              queue.offer(new Node(nextY, nextX, false));
              dp[nextY][nextX][1] = dp[node.y][node.x][0] + 1;
            }
          }
        }
      }
    }
    answer = Math.min(dp[n - 1][m - 1][0], dp[n - 1][m - 1][1]);

    return answer == Integer.MAX_VALUE ? -1 : answer;
  }

  class Node {
    int y;
    int x;
    boolean jump;

    Node(int y, int x, boolean jump) {
      this.y = y;
      this.x = x;
      this.jump = jump;
    }
  }
}
