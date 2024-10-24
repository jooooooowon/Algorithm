package Algorithm.algorithm.programmers.in_2024;
import java.util.*;

public class P_241024_같은_숫자는_싫어 {
  public int[] solution(int []arr) {
    Stack<Integer> stack = new Stack<>();
    for(int i = 0 ; i < arr.length; i++){
      if(!stack.isEmpty() && stack.peek() == arr[i]){
        stack.pop();
      }
      stack.push(arr[i]);
    }
    List<Integer> list = new ArrayList<>(stack);
    int[] answer = new int[list.size()];
    for(int i = 0 ; i < answer.length; i++){
      answer[i] = list.get(i);
    }
    return answer;
  }
}
