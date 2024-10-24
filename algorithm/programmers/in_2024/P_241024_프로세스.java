package Algorithm.algorithm.programmers.in_2024;
import java.util.*;
public class P_241024_프로세스 {
  public int solution(int[] priorities, int location) {
    int answer = 0;
    PriorityQueue<Integer> pqueue = new PriorityQueue<>(Collections.reverseOrder());
    for(int num : priorities){
      pqueue.offer(num);
    }
    Queue<Integer> queue = new LinkedList<>();
    for(int i = 0 ; i < priorities.length; i++){
      queue.offer(i);
    }
    while(!pqueue.isEmpty()){
      int num = pqueue.poll();
      boolean tf = false;
      while(true){
        int idx = queue.poll();
        if(num == priorities[idx]){
          answer++;
          if(idx == location){
            tf = true;
          }
          break;
        }else{
          queue.offer(idx);
        }
      }
      if(tf){
        break;
      }
    }
    return answer;
  }
}
