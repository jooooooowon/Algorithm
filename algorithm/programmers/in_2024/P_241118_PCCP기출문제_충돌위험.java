package Algorithm.algorithm.programmers.in_2024;
import java.util.*;
public class P_241118_PCCP기출문제_충돌위험 {
  public int solution(int[][] points, int[][] routes) {
    int answer = 0;
    Queue<Node>[] queArr = new Queue[routes.length];
    int maxSize = 0;
    for(int i = 0 ; i < routes.length ; i++){
      queArr[i] = new LinkedList<>();
      for(int j = 0 ; j < routes[i].length - 1; j++){
        int startPoint = routes[i][j];
        int endPoint = routes[i][j + 1];

        int startY = points[startPoint - 1][0];
        int startX = points[startPoint - 1][1];
        int endY = points[endPoint - 1][0];
        int endX = points[endPoint - 1][1];
        if(queArr[i].isEmpty()){
          queArr[i].offer(new Node(startY,startX));
        }
        while(startY != endY){
          if(startY > endY){
            startY--;
          }else if(startY < endY){
            startY++;
          }
          queArr[i].offer(new Node(startY, startX));
        }
        while(startX != endX){
          if(startX > endX){
            startX--;
          }else if(startX < endX){
            startX++;
          }
          queArr[i].offer(new Node(startY, startX));
        }
      }
      maxSize = Math.max(queArr[i].size(),maxSize);
    }


    int[][][] cntArr = new int[101][101][maxSize + 1];
    for(int i = 0; i < queArr.length; i++){
      Queue<Node> queue = queArr[i];
      int count = 0;
      // System.out.println(queue.toString());
      while(!queue.isEmpty()){
        Node node = queue.poll();
        cntArr[node.y][node.x][count++]++;
      }
    }
    for(int i = 0 ; i < 101; i++){
      for(int j = 0 ; j <101 ; j++){
        for(int k = 0 ; k < maxSize + 1; k++){
          if(cntArr[i][j][k] > 1){
            // System.out.println("i : " + i + " j : " + j + " k : " + k);
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
    @Override
    public String toString(){
      return "{y : "+  y + " x : " + x + "}";
    }
  }
}
