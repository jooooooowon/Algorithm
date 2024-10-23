package Algorithm.algorithm.programmers.in_2024;
import java.util.*;

public class P_240927_PCCP_기출문제_3번_충돌위험_찾기 {
  public int solution(int[][] points, int[][] routes) {
    int answer = 0;
    int n = routes.length;
    Queue<Node>[] queue = new Queue[n];
    for(int i = 0 ; i < n ; i++){
      queue[i] = new LinkedList<>();

      int[] route = routes[i];
      for(int j = 0 ; j < route.length - 1; j++){
        int startY = points[route[j] - 1][0];
        int startX = points[route[j] - 1][1];
        int endY = points[route[j + 1] - 1][0];
        int endX = points[route[j + 1] - 1][1];
        if(queue[i].isEmpty()){
          queue[i].offer(new Node(startY,startX));
        }
        while(startY != endY){
          if(startY < endY){
            startY++;
          }else{
            startY--;
          }
          queue[i].offer(new Node(startY,startX));
        }
        while(startX != endX){
          if(startX < endX){
            startX++;
          }else{
            startX--;
          }
          queue[i].offer(new Node(startY,startX));
        }
      }
    }

    int count = 0;
    while(count != n){
      int[][] countMap = new int[101][101];
      count = 0;
      for(int i = 0 ; i < n ; i++){
        if(queue[i].isEmpty()){
          count++;
        }else{
          Node node = queue[i].poll();
          countMap[node.y][node.x]++;
        }
      }
      for(int i = 0 ; i < 101; i++){
        for(int j = 0 ; j < 101; j++){
          if(countMap[i][j] > 1){
            answer++;
          }
        }
      }
    }
    return answer;
  }
  class Node{
    int y;
    int x;
    Node(int y, int x){
      this.y = y;
      this.x = x;
    }
  }
}
