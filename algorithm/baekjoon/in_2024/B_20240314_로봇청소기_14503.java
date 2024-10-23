package Algorithm.algorithm.baekjoon.in_2024;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_20240314_로봇청소기_14503 {
    static int[][] arr;
    static int n;
    static int m;
    static int count ;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        // 0:북 , 1:동 , 2:남, 3:서
        int d = Integer.parseInt(st.nextToken());

        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        count = 0;
        dfs(r, c, d);
        System.out.println(count);

    }

    static int[] dirY = {1, 0, -1, 0};
    static int[] dirX = {0, 1, 0, -1};

    private static void dfs(int y, int x, int d) {
        count++;
        for (int i = 0; i < 4; i++) {
            int dir = d - i + 4;
            dir %= 4;
            int nextY = dirY[dir];
            int nextX = dirX[dir];
            if (nextY >= 0 && nextY < n && nextX >= 0 && nextX < m && arr[nextY][nextX] == 0) {
                arr[nextY][nextX] = 2;
                dfs(nextY, nextX, dir);
            }
        }
    }
}
