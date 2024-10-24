package Algorithm.algorithm.programmers.in_2024;
import java.util.*;
public class P_241025_주식가격 {
  public int[] solution(int[] prices) {
    int n = prices.length;
    int[] answer = new int[n];
    Stack<Integer> stack = new Stack<>();

    for(int i = 0 ; i < n ; i++){
      while(!stack.isEmpty() && prices[i] < prices[stack.peek()]){
        int idx = stack.pop();
        answer[idx] = i - idx;
      }
      stack.push(i);
    }
    while(!stack.isEmpty()){
      int idx = stack.pop();
      answer[idx] = n - 1 - idx;
    }
    return answer;
  }
}
