package Algorithm.algorithm.programmers.in_2024;

public class P_241117_카페_확장 {
  public int solution(int[] menu, int[] order, int k) {
    int answer = 0;
    int time = 0;
    int outPerson = 0;
    for(int i = 0 ; i < order.length; i++){
      if(time < i * k){
        time = i * k;
      }
      System.out.println("time : " + time);
      time += menu[order[i]];

      int enterPerson = time / k + (time % k > 0 ? 1 : 0);
      enterPerson = Math.min(enterPerson, order.length);
      answer = Math.max(answer, enterPerson - outPerson);
      outPerson++;
    }
    return answer;
  }
}
