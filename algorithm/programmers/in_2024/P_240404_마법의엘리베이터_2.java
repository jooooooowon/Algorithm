package Algorithm.algorithm.programmers.in_2024;

import java.util.Arrays;
import java.util.PriorityQueue;

public class P_240404_마법의엘리베이터_2 {

  public static int solution(int storey) {
    int answer = 0;
    while (storey > 0) {
      int num = storey % 10;
      storey /= 10;
      if (num > 5) {
        answer += 10 - num;
        storey++;
      } else if (num < 5) {
        answer += num;
      } else if (storey % 10 >= 5) {
        storey++;
        answer += 5;
      } else {
        answer += 5;
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    System.out.println(solution(9));
    System.out.println(solution(16));
    System.out.println(solution(2554));
//    System.out.println(solution(999));
//    System.out.println(solution(155));
//    System.out.println(solution(154));
//    System.out.println(solution(545));
  }
}
