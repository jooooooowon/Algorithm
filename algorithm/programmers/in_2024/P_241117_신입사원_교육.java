package Algorithm.algorithm.programmers.in_2024;
import java.util.*;

public class P_241117_신입사원_교육 {
  public int solution(int[] ability, int number) {
    int answer = 0;
    PriorityQueue<Integer> pque = new PriorityQueue<>();
    for(int i : ability){
      pque.offer(i);
    }
    for(int i = 0 ; i < number; i++){
      int num1 = pque.poll();
      int num2 = pque.poll();
      pque.offer(num1 + num2);
      pque.offer(num1 + num2);
    }
    while(!pque.isEmpty()){
      answer += pque.poll();
    }
    return answer;
  }
}
