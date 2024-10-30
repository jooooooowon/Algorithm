package Algorithm.algorithm.baekjoon.in_2024;

import java.util.Arrays;
import java.util.Scanner;

public class B_241030_계단_수_1562 {
  static int[][][] dp = new int[101][10][1 << 10];

  public static void main(String[] args) {
    final int  MOD = 1000000000;
    Scanner sc = new Scanner(System.in);
    for(int i = 1 ; i < 10 ; i++){
      dp[1][i][1 << i] = 1;
    }
    for(int i = 2 ; i < 101 ; i++){
      for(int j = 0 ; j < 10 ; j++){
        for(int k = 1 ; k < 1 << 10 ; k++){
          if(j == 0){
            dp[i][j][k|(1<<j)] = (dp[i][j][k|(1<<j)] + dp[i-1][1][k]) % MOD;
          }else if(j == 9){
            dp[i][j][k|(1<<j)] = (dp[i][j][k|(1<<j)] + dp[i-1][8][k]) % MOD;
          }else{
            dp[i][j][k|(1<<j)] = (dp[i][j][k|(1<<j)] + dp[i-1][j-1][k] + dp[i-1][j+1][k]) % MOD;
          }
        }
      }
    }
    int n = sc.nextInt();
    int sum = 0;
    for(int i = 0 ; i < 10 ; i++){
      sum += dp[n][i][(1 << 10) - 1];
      sum %= MOD;
    }
    System.out.println(sum);
  }
}
