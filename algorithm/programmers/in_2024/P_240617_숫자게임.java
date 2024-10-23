package Algorithm.algorithm.programmers.in_2024;

import java.util.*;

public class P_240617_숫자게임 {
  public int solution(int[] A, int[] B) {
    PriorityQueue<Integer> aPque = new PriorityQueue<>();
    PriorityQueue<Integer> bPque = new PriorityQueue<>();
    for (int a : A) {
      aPque.offer(a);
    }
    for (int b : B) {
      bPque.offer(b);
    }

    int temp = aPque.poll();
    int count = 0;
    while (!bPque.isEmpty()) {
      int b = bPque.poll();
      if (b > temp) {
        count++;
        if (!aPque.isEmpty()) {
          temp = aPque.poll();
        }
      }
    }
    return count;
  }
}
