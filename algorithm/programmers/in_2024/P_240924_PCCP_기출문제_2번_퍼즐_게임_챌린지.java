package Algorithm.algorithm.programmers.in_2024;

public class P_240924_PCCP_기출문제_2번_퍼즐_게임_챌린지 {
  public int solution(int[] diffs, int[] times, long limit) {
    int answer = 0;
    int max = 100000;
    int min = 1;
    int n = diffs.length;
    while(max >= min){
      int mid = (max + min) / 2;
      long temp = 0;
      for(int i = 0 ; i < n ; i++){
        if(mid >= diffs[i]){
          temp += times[i];
        }else{
          temp += (diffs[i] - mid) * (times[i-1] + times[i]);
          temp += times[i];
        }
      }

      if(temp <= limit){
        answer = mid;
        max = mid - 1;
      }else{
        min = mid + 1;
      }
    }

    return answer;
  }
}
