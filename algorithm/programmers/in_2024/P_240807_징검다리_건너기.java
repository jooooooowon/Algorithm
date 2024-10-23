package Algorithm.algorithm.programmers.in_2024;

import java.util.*;
public class P_240807_징검다리_건너기 {
  int[] stones;
  int k;
  public int solution(int[] stones, int k) {
    this.stones = stones;
    this.k = k;
    int min = 0;
    int max = Integer.MAX_VALUE;
    int answer = (min + max) / 2;
    while(min <= max){
      int mid = (min + max) / 2;
      if(passBridge(mid)){
        min = mid + 1;
        answer = mid;
      }else{
        max = mid - 1;
      }
    }

    return answer;
  }

  private boolean passBridge(int peopleNum){
    int count = 0;
    for(int stone : stones){
      if(stone - peopleNum + 1 > 0){
        count = 0;
      }else{
        count++;
      }

      if(count == k) {
        return false;
      }

    }

    return true;
  }
}
