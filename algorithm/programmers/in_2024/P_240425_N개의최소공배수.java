package Algorithm.algorithm.programmers.in_2024;

import java.util.Arrays;

public class P_240425_N개의최소공배수 {
  public int solution(int[] arr) {
    int answer = Arrays.stream(arr)
        .reduce(this::lcm)
        .orElseThrow(IllegalAccessError::new);
    return answer;
  }

  private int gcd(int a, int b) {
    int small = Math.min(a, b);
    int big = Math.max(a, b);
    if (small == 0) {
      return a;
    }
    return gcd(small, big % small);
  }

  private int lcm(int a, int b) {
    return a * b / gcd(a, b);
  }
}
