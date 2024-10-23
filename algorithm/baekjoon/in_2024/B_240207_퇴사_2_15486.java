package Algorithm.algorithm.baekjoon.in_2024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_240207_퇴사_2_15486 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] arr = new int[n + 1][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
//        int[] dp = new int[n + 1];
//        for (int i = n - 1; i >= 0; i--) {
//            int day = arr[i][0];
//            int price = arr[i][1];
//            if (i + day <= n) {
//                dp[i] = Math.max(price + dp[i + day], dp[i + 1]);
//            }
//        }
//        System.out.println(dp[0]);
        int[] dp = new int[n + 1];
        int max = 0;
        for (int i = 0; i < n + 1; i++) {
            if (max < dp[i]) max = dp[i];
            int day = i + arr[i][0];
            if (day < n + 1) {
                dp[day] = Math.max(dp[day], max + arr[i][1]);
            }
        }
        System.out.println(max);
    }
}
