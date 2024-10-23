package Algorithm.algorithm.programmers.in_2024;

import java.util.*;

public class P_240516_이중우선순위큐 {
  public int[] solution(String[] operations) {
    int[] answer = new int[2];
    PriorityQueue<Integer> pque = new PriorityQueue<>();
    PriorityQueue<Integer> rPque = new PriorityQueue<>(Collections.reverseOrder());
    for (String str : operations) {
      String[] temp = str.split(" ");

      if (temp[0].equals("I")) {
        pque.offer(Integer.parseInt(temp[1]));
        rPque.offer(Integer.parseInt(temp[1]));
      } else {
        if (pque.isEmpty())
          continue;
        if (Integer.parseInt(temp[1]) < 0) {
          int num = pque.poll();
          rPque.remove(num);
        } else {
          int num = rPque.poll();
          pque.remove(num);
        }
      }
    }
    System.out.println(pque.toString());
    System.out.println(rPque.toString());
    answer[1] = pque.isEmpty() ? 0 : pque.poll();
    answer[0] = rPque.isEmpty() ? 0 : rPque.poll();
    return answer;
  }
}
