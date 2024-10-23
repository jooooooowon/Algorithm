package Algorithm.algorithm.baekjoon.in_2024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_240129_미로탐색_2178 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        int[][] count = new int[n][m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = str.charAt(j) - '0';
                if (arr[i][j] == 0) {
                    visited[i][j] = true;
                }
            }
        }
        Queue<Coordinate> queue = new LinkedList<>();
        queue.offer(new Coordinate(0, 0));
        count[0][0] = 1;
        int[] dirX = {1, -1, 0, 0};
        int[] dirY = {0, 0, 1, -1};

        while (!queue.isEmpty()) {
            Coordinate now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = now.x + dirX[i];
                int nextY = now.y + dirY[i];
                if (nextX >= 0 && nextY >= 0 && nextY < n && nextX < m && !visited[nextY][nextX]) {
                    queue.offer(new Coordinate(nextX, nextY));
                    visited[nextY][nextX] = true;
                    count[nextY][nextX] = count[now.y][now.x] + 1;
                }
            }
        }
        System.out.println(count[n - 1][m - 1]);
    }

    static class Coordinate {
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
