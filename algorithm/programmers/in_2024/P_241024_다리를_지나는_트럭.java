package Algorithm.algorithm.programmers.in_2024;
import java.util.*;
public class P_241024_다리를_지나는_트럭 {
  public int solution(int bridge_length, int weight, int[] truck_weights) {
    Queue<Integer> queue = new LinkedList<>();
    int idx = 0;
    int w = 0;
    int time = 0;
    for(int i = 0 ; i < bridge_length; i++){
      queue.offer(0);
    }
    while(!queue.isEmpty()){
      time++;
      w -= queue.poll();
      if(idx >= truck_weights.length) continue;
      if(w + truck_weights[idx] <= weight){
        w += truck_weights[idx];
        queue.offer(truck_weights[idx++]);
      }else{
        queue.offer(0);
      }
    }
    return time;
  }
}
