package Algorithm.algorithm.programmers.in_2024;

public class P_240513_도둑질 {
  public int solution(int[] money) {
    int answer = 0;
    int n = money.length;
    int[] dp = new int[n];
    int[] money_1 = new int[n];
    for (int i = 1; i < n; i++) {
      money_1[i] = money[i];
    }
    dp[1] = money_1[1];

    for (int i = 2; i < n; i++) {
      dp[i] = Math.max(dp[i - 2] + money_1[i], dp[i - 1]);
      answer = Math.max(answer, dp[i]);
    }

    int[] money_2 = new int[n];
    for (int i = 0; i < n - 1; i++) {
      money_2[i + 1] = money[i];
    }
    dp = new int[n];

    dp[1] = money_2[1];
    for (int i = 2; i < n; i++) {
      dp[i] = Math.max(dp[i - 2] + money_2[i], dp[i - 1]);
      answer = Math.max(answer, dp[i]);
    }


    return answer;
  }
}
