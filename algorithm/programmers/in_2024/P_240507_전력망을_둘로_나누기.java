package Algorithm.algorithm.programmers.in_2024;

import java.util.*;
public class P_240507_전력망을_둘로_나누기 {
  int[][] wires;
  int n;
  boolean[] visited;
  public int solution(int n, int[][] wires) {
    int answer = n;
    this.wires = wires;
    this.n = n;
    for(int i = 0; i < wires.length ; i++){
      List<Integer>[] list = makeList(i);
      visited = new boolean[n+1];
      visited[1] = true;
      // dfs(list, 1);
      bfs(list);
      int countTrue = 0;
      int countFalse = 0;
      for(int j = 1 ; j < n + 1 ; j++){
        if(visited[j]){
          countTrue++;
        }else{
          countFalse++;
        }
      }
      answer = Math.min(answer, Math.abs(countTrue - countFalse));
    }
    return answer;
  }

  private void dfs(List<Integer>[] list, int idx){

    for(int next : list[idx]){
      if(!visited[next]){
        visited[next] = true;
        dfs(list, next);
      }
    }
  }

  private void bfs(List<Integer>[] list){
    Queue<Integer> queue = new LinkedList<>();
    queue.offer(1);
    while(!queue.isEmpty()){
      int now = queue.poll();
      for(int next : list[now]){
        if(!visited[next]){
          visited[next] = true;
          queue.offer(next);
        }
      }
    }
  }

  private List<Integer>[] makeList(int idx){
    List<Integer>[] list = new List[n + 1];
    for(int i = 0 ; i < n + 1; i++){
      list[i] = new ArrayList<>();
    }
    for(int i = 0 ; i < wires.length ; i++){
      if(i == idx){
        continue;
      }
      int from = wires[i][0];
      int to = wires[i][1];
      list[from].add(to);
      list[to].add(from);
    }
    return list;
  }

}
