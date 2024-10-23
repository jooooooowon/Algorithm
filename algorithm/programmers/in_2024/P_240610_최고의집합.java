package Algorithm.algorithm.programmers.in_2024;

import java.util.*;

public class P_240610_최고의집합 {
  public int[] solution(int n, int s) {
    int quotient = s / n;
    int remainder = s % n;
    if (quotient == 0) {
      int[] answer = {-1};
      return answer;
    }
    int[] answer = new int[n];
    Arrays.fill(answer, quotient);
    for (int i = 0; i < remainder; i++) {
      answer[i]++;
    }
    Arrays.sort(answer);
    return answer;
  }
}
