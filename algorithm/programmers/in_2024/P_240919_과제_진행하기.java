package Algorithm.algorithm.programmers.in_2024;
import java.util.*;

public class P_240919_과제_진행하기 {
  public String[] solution(String[][] plans) {

    String[] answer = new String[plans.length];
    Arrays.sort(plans, (o1,o2) -> o1[1].compareTo(o2[1]));

    Stack<Work> stack = new Stack<>();
    int index = 0;
    int now = 0;
    for(int i = 0 ; i < plans.length; i++){
      String[] timeArr = plans[i][1].split(":");
      int start = Integer.parseInt(timeArr[0]) * 60 + Integer.parseInt(timeArr[1]);
      // System.out.println(stack.toString());
      // System.out.println(now);
      while(!stack.isEmpty() && now + stack.peek().left <= start){
        Work work = stack.pop();
        now += work.left;
        answer[index++] = work.name;
      }
      if(!stack.isEmpty() && now + stack.peek().left > start){
        Work work = stack.pop();
        stack.push(new Work(work.name, now + work.left - start));
      }
      now = start;
      stack.push(new Work(plans[i][0], Integer.parseInt(plans[i][2])));
    }
    while(!stack.isEmpty()){
      // System.out.println(stack.toString());
      answer[index++] = stack.pop().name;
    }

    return answer;
  }
  class Work{
    String name;
    int left;
    Work(String name, int left){
      this.name = name;
      this.left = left;
    }
    @Override
    public String toString(){
      return "name : " + name + ", left : " + left;
    }
  }
}
