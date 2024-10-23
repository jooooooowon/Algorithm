package Algorithm.algorithm.programmers.in_2024;

public class P_240516_멀리뛰기 {
  static final int MOD = 1234567;
  public long solution(int n) {
    int[] dp = new int[n+1];
    dp[0] = 1;
    for(int i = 0 ; i < n+1 ; i++){
      dp[i] %= MOD;
      if(i + 2 < n+1){
        dp[i+2] += dp[i];
      }
      if(i + 1 < n+1){
        dp[i+1] += dp[i];
      }
    }
    return dp[n];
  }
}
