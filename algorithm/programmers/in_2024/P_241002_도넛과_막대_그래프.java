package Algorithm.algorithm.programmers.in_2024;

public class P_241002_도넛과_막대_그래프 {
  public int[] solution(int[][] edges) {
    int[] answer = new int[4];

    int[] startArr = new int[1000001];
    int[] endArr = new int[1000001];
    int n = 0;

    for(int i = 0; i < edges.length; i++){
      int start = edges[i][0];
      int end = edges[i][1];
      n = Math.max(n, Math.max(start, end));
      startArr[start]++;
      endArr[end]++;
    }

    int startNode = 0;
    int eightCount = 0;
    int straightCount = 0;
    for(int i = 1 ; i <= n ; i++){
      if(startArr[i] >= 2 && endArr[i] == 0){
        startNode = i;
        break;
      }
    }
    // for(int i = 0 ; i < edges.length; i++){
    //     int start = edges[i][0];
    //     int end = edges[i][1];
    //     if(start == startNode){
    //         endArr[end]--;
    //     }
    // }
    for(int i = 1 ; i <= n ; i++){
      if(startArr[i] == 2 && endArr[i] >= 2){
        eightCount++;
      }else if(startArr[i] == 0 && endArr[i] > 0){
        straightCount++;
      }
    }

    answer[0] = startNode;
    answer[1] = startArr[startNode] - eightCount - straightCount;
    answer[2] = straightCount;
    answer[3] = eightCount;
    return answer;
  }
}
