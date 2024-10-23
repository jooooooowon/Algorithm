package Algorithm.algorithm.programmers.in_2024;

public class P_240425_다음큰숫자 {
  public int solution(int n) {
    int answer = 0;
    final int MAX_VALUE = 1000000;
    for (int i = n + 1; i < MAX_VALUE; i++) {
      if(Integer.bitCount(i) == Integer.bitCount(n)){
        answer = i;
        break;
      }
    }
    return answer;
  }
}
