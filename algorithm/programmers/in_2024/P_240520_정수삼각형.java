package Algorithm.algorithm.programmers.in_2024;


public class P_240520_정수삼각형 {
  public int solution(int[][] triangle) {
    int answer = 0;
    int n = triangle.length;

    int[][] dp = new int[n][n];
    int max = 0;
    dp[0][0] = triangle[0][0];
    for(int i = 0 ; i < n; i++){
      for(int j = 0 ; j < triangle[i].length; j++){
        if(i + 1 < n && j + 1 < n){
          dp[i + 1][j] = Math.max(dp[i + 1][j], dp[i][j] + triangle[i + 1][j]);
          dp[i + 1][j + 1] = Math.max(dp[i + 1][j + 1],dp[i][j] + triangle[i + 1][j + 1]);
        }
        max = Math.max(dp[i][j],max);
      }
    }

    return max;
  }
}
