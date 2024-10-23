package Algorithm.algorithm.programmers.in_2024;

public class P_240425_숫자의표현 {
  public int solution(int n) {
    int answer = 0;
    int start = 0;
    int end = 0;
    int temp = 0;
    while (start <= end && end <= n) {
      if (temp < n) {
        temp += ++end;
      } else if (temp > n) {
        temp -= start++;
      } else {
        answer++;
        temp += ++end;
      }
    }
    return answer;
  }
}
