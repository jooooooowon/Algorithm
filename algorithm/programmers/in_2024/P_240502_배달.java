package Algorithm.algorithm.programmers.in_2024;
import java.util.*;
public class P_240502_배달 {
  public int solution(int N, int[][] road, int K) {
    List<Edge>[] arr = new List[N + 1];
    for(int i = 0 ; i < arr.length; i++){
      arr[i] = new ArrayList<>();
    }
    for(int i = 0 ; i < road.length; i++){
      int from = road[i][0];
      int to = road[i][1];
      int distance = road[i][2];
      arr[from].add(new Edge(to,distance));
      arr[to].add(new Edge(from, distance));
    }

    int start = 1;
    int[] distanceArr = new int[N+1];
    for(int i = 0 ; i < N + 1 ; i++){
      distanceArr[i] = Integer.MAX_VALUE;
    }
    boolean[] visited = new boolean[N+1];
    PriorityQueue<Edge> pque = new PriorityQueue<>();
    pque.offer(new Edge(1,0));
    distanceArr[1] = 0;
    while(!pque.isEmpty()){
      Edge now = pque.poll();
      // visited[now.to] = true;
      for(Edge next : arr[now.to]){
        // if(!visited[next.to]){
        if(distanceArr[now.to] + next.distance < distanceArr[next.to]){
          distanceArr[next.to] = distanceArr[now.to] + next.distance;
          pque.offer(next);
        }
        // }
      }
    }

    int answer = 0;
    for(int temp : distanceArr){
      if(temp <= K){
        answer++;
      }
    }


    return answer;
  }

  class Edge implements Comparable<Edge>{
    int to;
    int distance;
    public Edge(int to, int distance){
      this.to = to;
      this.distance = distance;
    }

    @Override
    public int compareTo(Edge edge){
      return this.distance - edge.distance;
    }

    @Override
    public String toString(){
      return "to : " + to + " distance : " + distance;
    }
  }
}
