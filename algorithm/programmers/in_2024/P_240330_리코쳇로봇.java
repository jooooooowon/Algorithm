package Algorithm.algorithm.programmers.in_2024;

import java.util.LinkedList;
import java.util.Queue;

public class P_240330_리코쳇로봇 {
    int n;
    int m;
    int startY, startX;
    boolean[][] visited;
    int[][] arr;

    public int solution(String[] board) {
        n = board.length;
        m = board[0].length();

        arr = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String str = board[i];
            for (int j = 0; j < m; j++) {
                char ch = str.charAt(j);
                if (ch == 'D') {
                    arr[i][j] = -1;
                }
                if (ch == 'R') {
                    startY = i;
                    startX = j;
                }
                if (ch == 'G') {
                    arr[i][j] = 1;
                }
            }
        }
        return bfs();
    }

    private int bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(startY, startX, 0));
        visited[startY][startX] = true;
        int[] dirY = {1, -1, 0, 0};
        int[] dirX = {0, 0, 1, -1};
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextY = now.y;
                int nextX = now.x;
                while (nextY >= 0 && nextY < n && nextX >= 0 && nextX < m && arr[nextY][nextX] != -1) {
                    nextY += dirY[i];
                    nextX += dirX[i];
                }
                nextY -= dirY[i];
                nextX -= dirX[i];
                if (!visited[nextY][nextX]) {
                    visited[nextY][nextX] = true;
                    queue.offer(new Node(nextY, nextX, now.depth + 1));
                }
                if (arr[nextY][nextX] == 1) {
                    return now.depth + 1;
                }
            }
        }
        return -1;
    }

    class Node {
        int y;
        int x;
        int depth;

        public Node(int y, int x, int depth) {
            this.y = y;
            this.x = x;
            this.depth = depth;
        }
    }
}
