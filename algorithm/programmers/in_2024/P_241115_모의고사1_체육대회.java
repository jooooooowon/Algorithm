package Algorithm.algorithm.programmers.in_2024;

public class P_241115_모의고사1_체육대회 {
  int[][] ability;
  int answer = 0;
  int n;
  int m;
  public int solution(int[][] ability) {
    this.ability = ability;
    n = ability.length;
    m = ability[0].length;
    int[] visited = new int[m];
    for(int i = 0 ; i < m ; i++){
      visited[i] = -1;
    }
    backTracking(visited, 0);
    return answer;
  }
  void backTracking(int[] visited, int idx){

    if(idx >= m){
      int sum = 0;
      for(int i = 0 ; i < visited.length ; i++){
        sum += ability[visited[i]][i];
      }
      answer = Math.max(answer, sum);
      return;
    }

    for(int i = 0 ; i < n; i++){
      boolean tf = true;
      for(int j = 0 ; j < idx ; j++){
        if(visited[j] == i){
          tf = false;
          break;
        }
      }
      if(!tf) continue;
      visited[idx] = i;
      backTracking(visited, idx + 1);
      visited[idx] = -1;
    }
  }
}
