package Algorithm.algorithm.baekjoon.in_2024;

import java.util.Scanner;

public class B_241030_쉬운_계단_수_10844 {
  static int[][] dp = new int[101][10];
  public static void main(String[] args) {
    final int MOD = 1000000000;
    Scanner sc = new Scanner(System.in);
    for(int i = 1 ; i <= 9 ; i++){
      dp[1][i] = 1;
    }

    for(int i = 2 ; i < 101; i++){
      for(int j = 1 ; j < 9 ; j++){
        dp[i][j] = (dp[i-1][j-1] % MOD + dp[i-1][j+1] % MOD) % MOD;
      }
      dp[i][0] = dp[i-1][1] % MOD;
      dp[i][9] = dp[i-1][8] % MOD;
    }
    int n = sc.nextInt();
    int sum = 0;
    for(int i = 0 ; i < 10 ; i++){
      sum += dp[n][i];
      sum %= MOD;
    }
    System.out.println(sum);
  }
}
