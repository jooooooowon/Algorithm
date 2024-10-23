package Algorithm.algorithm.programmers.in_2024;

public class P_240513_예상대진표 {
  public int solution(int n, int a, int b) {
    int answer = 0;

    int max = Math.max(a, b);
    int min = Math.min(a, b);
    while (true) {
      answer++;
      if (max - min == 1 && max % 2 == 0 && min % 2 == 1) {
        break;
      }
      max++;
      min++;
      max /= 2;
      min /= 2;
    }
    return answer;
  }
}
