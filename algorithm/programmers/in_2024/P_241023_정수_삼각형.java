package Algorithm.algorithm.programmers.in_2024;

public class P_241023_정수_삼각형 {
  public int solution(int[][] triangle) {
    int answer = 0;
    int n = triangle.length;
    int[][] dp = new int[n][n];
    dp[0][0] = triangle[0][0];
    for(int i = 0 ; i < n - 1 ; i++){
      for(int j = 0 ; j < i + 1 ; j++){
        dp[i + 1][j] = Math.max(dp[i+1][j],dp[i][j] + triangle[i + 1][j]);
        dp[i + 1][j + 1] = Math.max(dp[i+1][j+1],dp[i][j] + triangle[i + 1][j + 1]);
      }
    }

    for(int i = 0 ; i < n ; i++){
      answer = Math.max(dp[n-1][i], answer);
    }
    // for(int i = 0 ; i < n; i++){
    //     System.out.println(Arrays.toString(dp[i]));
    // }
    return answer;
  }
}
