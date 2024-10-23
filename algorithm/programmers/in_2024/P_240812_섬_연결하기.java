package Algorithm.algorithm.programmers.in_2024;
import java.util.*;

public class P_240812_섬_연결하기 {
  int[] unionArr;

  public int solution(int n, int[][] costs) {
    int answer = 0;
    unionArr = new int[n + 1];

    for(int i = 0 ; i < unionArr.length; i++){
      unionArr[i] = i;
    }
    Arrays.sort(costs, (o1,o2) -> o1[2] - o2[2]);

    for(int i = 0 ; i < costs.length; i++){
      int start = costs[i][0];
      int end = costs[i][1];
      int cost = costs[i][2];
      if(find(start) != find(end)){
        union(start, end);
        answer += cost;
      }
    }


    return answer;
  }

  private int find(int index){
    if(index == unionArr[index]){
      return index;
    }
    return unionArr[index] = find(unionArr[index]);
  }

  private void union(int start, int end){
    int a = find(start);
    int b = find(end);
    unionArr[b] = a;
  }

}
