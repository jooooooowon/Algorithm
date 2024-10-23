package Algorithm.algorithm.programmers.in_2024;
import java.util.*;
public class P_241021_연속_펄스_부분_수열의_합 {
  public long solution(int[] sequence) {
    int n = sequence.length;
    long[][] dp = new long[2][n];
    for(int i = 0 ; i < n; i++){
      dp[0][i] = (long)Math.pow(-1,i) * sequence[i];
      dp[1][i] = (long)Math.pow(-1,i + 1) * sequence[i];
    }
    // System.out.println(Arrays.toString(dp[0]));
    // System.out.println(Arrays.toString(dp[1]));

    long answer = Math.max(dp[0][0], dp[1][0]);
    for(int i = 0 ; i < n - 1; i++){
      long temp = dp[0][i] + dp[0][i+1];
      if(temp < 0){
        dp[0][i + 1] = 0;
      }else{
        dp[0][i + 1] = Math.max(temp,dp[0][i+1]);
      }

      temp = dp[1][i] + dp[1][i+1];
      if(temp < 0){
        dp[1][i + 1] = 0;
      }else{
        dp[1][i + 1] = Math.max(temp,dp[1][i+1]);
      }
      answer = Math.max(Math.max(dp[1][i+1], dp[0][i+1]), answer);
    }
    // System.out.println(Arrays.toString(dp[0]));
    // System.out.println(Arrays.toString(dp[1]));
    return answer;
  }
}
