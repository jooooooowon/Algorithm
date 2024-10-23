package Algorithm.algorithm.programmers.in_2024;

public class P_241018_산_모양_타일링 {
  public int solution(int n, int[] tops) {
    int answer = 0;
    int[][] dp = new int[n+1][2];
    // 0 비어져 있음, 1 막혀있음
    dp[0][0] = 1;
    int MOD = 10007;
    for(int i = 0 ; i < n ; i++){
      dp[i+1][1] = (dp[i][0] + dp[i][1]) % MOD;
      if(tops[i] == 1){
        dp[i+1][0] = (dp[i][0] * 3 + dp[i][1] * 2) % MOD;
      }else{
        dp[i+1][0] = (dp[i][0] * 2 + dp[i][1]) % MOD;
      }
    }
    answer = (dp[n][0] + dp[n][1]) % MOD;
    return answer;
  }
}
