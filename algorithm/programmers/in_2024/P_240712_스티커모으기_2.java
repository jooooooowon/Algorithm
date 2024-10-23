package Algorithm.algorithm.programmers.in_2024;

public class P_240712_스티커모으기_2 {
  public int solution(int sticker[]) {
    int answer = 0;
    int n = sticker.length;
    if(n == 1){
      return sticker[0];
    }
    int[] dp1 = new int[n];
    int[] dp2 = new int[n];
    answer = Math.max(sticker[0],sticker[1]);
    dp1[0] = sticker[0];
    dp1[1] = sticker[0];
    dp2[1] = sticker[1];


    for(int i = 2 ; i < n - 1; i++){
      dp1[i] = Math.max(dp1[i - 2] + sticker[i], dp1[i - 1]);
      answer = Math.max(answer,dp1[i]);
    }
    for(int i = 2 ; i < n ; i++){
      dp2[i] = Math.max(dp2[i - 2] + sticker[i], dp2[i - 1]);
      answer = Math.max(answer,dp2[i]);
    }
    return answer;
  }
}
