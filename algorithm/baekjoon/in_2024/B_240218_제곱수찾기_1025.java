package Algorithm.algorithm.baekjoon.in_2024;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_240218_제곱수찾기_1025 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }
        int max = -1;
        for (int startI = 0; startI < n; startI++) {
            for (int startJ = 0; startJ < m; startJ++) {
                for (int i = 0; i < n; i++) {
                    for (int j = -m; j < m; j++) {
                        if (i == 0 && j == 0) {
                            continue;
                        }
                        StringBuilder sb = new StringBuilder();
                        int y = startI;
                        int x = startJ;
                        while (y >= 0 && y < n && x < m && x >= 0) {
                            sb.append(arr[y][x]);
                            int num = Integer.parseInt(sb.toString());
                            if(Math.sqrt(num) % 1 == 0){
                                max = Math.max(max, num);
                            }
                            num = Integer.parseInt(sb.reverse().toString());
                            if(Math.sqrt(num) % 1 == 0){
                                max = Math.max(max, num);
                            }
                            y += i;
                            x += j;
                            sb.reverse();
                        }
                    }
                }
            }
        }
        System.out.println(max);
    }
}
