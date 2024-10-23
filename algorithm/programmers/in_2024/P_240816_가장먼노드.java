package Algorithm.algorithm.programmers.in_2024;

import java.util.*;

public class P_240816_가장먼노드 {
  public int solution(int n, int[][] edge) {
    List<Integer>[] arrList = new List[n+1];
    int[] costArr = new int[n+1];

    for(int i = 0; i < n + 1; i++){
      arrList[i] = new ArrayList<>();
    }

    for(int i = 0 ; i < edge.length ;i++){
      int start = edge[i][0];
      int end = edge[i][1];
      arrList[start].add(end);
      arrList[end].add(start);
    }
    // System.out.println(Arrays.toString(arrList));
    boolean[] visited = new boolean[n+1];
    visited[1] = true;
    PriorityQueue<Node> pque = new PriorityQueue<>();
    pque.offer(new Node(1,0));
    int max = 0;
    while(!pque.isEmpty()){
      Node node = pque.poll();
      for(int nextIndex : arrList[node.index]){
        if(!visited[nextIndex]){
          visited[nextIndex] = true;
          costArr[nextIndex] = costArr[node.index] + 1;
          pque.offer(new Node(nextIndex, costArr[nextIndex]));
          max = Math.max(costArr[nextIndex],max);
        }
      }
    }
    // System.out.println(Arrays.toString(costArr));
    int count = 0;
    for(int num : costArr){
      if(num == max){
        count++;
      }
    }
    return count;
  }

  class Node implements Comparable<Node>{
    int index;
    int cost;
    public Node(int index, int cost){
      this.index = index;
      this.cost = cost;
    }
    @Override
    public int compareTo(Node node){
      return this.cost - node.cost;
    }
  }
}
