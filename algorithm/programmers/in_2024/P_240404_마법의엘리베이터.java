package Algorithm.algorithm.programmers.in_2024;

import java.util.Arrays;
import java.util.PriorityQueue;

public class P_240404_마법의엘리베이터 {

  public static int solution(int storey) {
    int answer = 0;
    int temp = storey;
    int c = 0;
    while (temp > 0) {
      c++;
      temp /= 10;
    }
    int max = (int) Math.pow(10, c) + 1;

    boolean[] visited = new boolean[max];
    System.out.println("max : " + max);
    PriorityQueue<Node> pque = new PriorityQueue<>();
    pque.offer(new Node(storey, 0));
    visited[storey] = true;
    while (!pque.isEmpty()) {
      Node node = pque.poll();
//      System.out.println(node);
      int num = node.num;
      int count = node.count;
      if (num == 0) {
        answer = node.count;
        break;
      }
      for (int i = 0; i < c; i++) {
        int plus = (int) Math.pow(10, i);
        if (num + plus < max && !visited[num + plus]) {
          visited[num + plus] = true;
          pque.add(new Node(num + plus, count + 1));
        }
        if (num - plus >= 0 && !visited[num - plus]) {
          visited[num - plus] = true;
          pque.add(new Node(num - plus, count + 1));
        }
      }
    }
    System.out.println(Arrays.toString(visited));
    return answer;
  }

  static class Node implements Comparable<Node> {
    int num;
    int count;

    public Node(int num, int count) {
      this.num = num;
      this.count = count;
    }

    @Override
    public int compareTo(Node o) {
      if(this.count == o.count){
        return this.num - o.num;
      }
      return this.count - o.count;
    }

    @Override
    public String toString() {
      return "num : " + num + ", count : " + count;
    }
  }

  public static void main(String[] args) {
    System.out.println(solution(9));
//    System.out.println(solution(2554));
//    System.out.println(solution(678));
//    System.out.println(solution(999));
//    System.out.println(solution(155));
//    System.out.println(solution(154));
//    System.out.println(solution(545));
  }
}
