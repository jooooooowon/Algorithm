package Algorithm.algorithm.programmers.in_2024;
import java.util.*;
public class P_241116_모의고사1_운영체제 {
  public long[] solution(int[][] program) {
    long[] answer = new long[11];
    PriorityQueue<int[]> pque = new PriorityQueue<>((m1,m2) -> m1[1] - m2[1]);
    for(int[] pro : program){
      pque.offer(pro);
    }
    PriorityQueue<int[]> programPque = new PriorityQueue<>((m1,m2) -> {
      if(m1[0] == m2[0]){
        return m1[1] - m2[1];
      }
      return m1[0] - m2[0];
    });

    int time = 0;
    while(!pque.isEmpty()){
      while(!pque.isEmpty() && pque.peek()[1] <= time){
        programPque.offer(pque.poll());
      }
      if(!programPque.isEmpty() && programPque.peek()[1] <= time){
        int[] temp = programPque.poll();
        answer[temp[0]] += time - temp[1];
        time += temp[2];
      }else{
        time++;
      }
    }
    while(!programPque.isEmpty()){
      int[] temp = programPque.poll();
      answer[temp[0]] += time - temp[1];
      time += temp[2];
    }
    answer[0] = time;

    return answer;
  }
}
