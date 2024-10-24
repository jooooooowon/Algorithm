package Algorithm.algorithm.programmers.in_2024;
import java.util.*;
public class P_241024_기능개발 {
  public int[] solution(int[] progresses, int[] speeds) {
    int n = progresses.length;
    Queue<Integer> queue = new LinkedList<>();
    for(int i = 0; i < n ; i++){
      int leftProgress = 100 - progresses[i];
      if(leftProgress % speeds[i] == 0){
        queue.offer(leftProgress / speeds[i]);
      }else{
        queue.offer(leftProgress / speeds[i] + 1);
      }
    }
    List<Integer> list = new ArrayList<>();
    while(!queue.isEmpty()){
      int count = 1;
      int day = queue.poll();
      while(!queue.isEmpty() && queue.peek() <= day){
        queue.poll();
        count++;
      }
      list.add(count);
    }
    int[] answer = new int[list.size()];
    for(int i =0 ; i < answer.length; i++){
      answer[i] = list.get(i);
    }
    return answer;
  }
}
