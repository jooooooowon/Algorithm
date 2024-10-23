package Algorithm.algorithm.programmers.in_2024;

import java.util.*;

public class P_240610_야근지수 {
  public long solution(int n, int[] works) {
    long answer = 0;
    PriorityQueue<Integer> pque = new PriorityQueue<>(Collections.reverseOrder());
    for (int work : works) {
      pque.offer(work);
    }

    while (n > 0 && !pque.isEmpty()) {
      int max = pque.poll();
      max--;
      if (max > 0) {
        pque.offer(max);
      }
      n--;
    }
    while (!pque.isEmpty()) {
      int temp = pque.poll();
      answer += Math.pow(temp, 2);
    }
    return answer;
  }
}
