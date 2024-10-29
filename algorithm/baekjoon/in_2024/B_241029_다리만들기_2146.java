package Algorithm.algorithm.baekjoon.in_2024;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_241029_다리만들기_2146 {
  static int[][] arr;
  static int n;
  static int[] dirY = {1,-1,0,0};
  static int[] dirX = {0,0,1,-1};

  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    arr = new int[n][n];
    for(int i = 0 ; i < n ; i++){
      StringTokenizer st = new StringTokenizer(br.readLine());
      for(int j = 0 ; j < n ; j++){
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    int answer = n * n;
    boolean[][] visited = new boolean[n][n];
    int num = 2;
    for(int i = 0; i < n ; i++){
      for(int j = 0 ; j < n ; j++){
        if(arr[i][j] == 1 && !visited[i][j]){
//          System.out.println("i : " + i + " , j : " + j);
          arr[i][j] = num;
          Queue<Node> queue = new LinkedList<>();
          queue.offer(new Node(i,j));
          while(!queue.isEmpty()){
            Node node = queue.poll();
            for(int k = 0 ; k < 4; k++){
              int nextY = node.y + dirY[k];
              int nextX = node.x + dirX[k];
              if(nextY >= 0 && nextY < n && nextX >= 0 && nextX < n && arr[nextY][nextX] == 1){
                arr[nextY][nextX] = num;
                queue.offer(new Node(nextY,nextX));
              }
            }
          }
          num++;
        }
      }
    }
//    for(int[] tempArr : arr){
//      System.out.println(Arrays.toString(tempArr));
//    }
    for(int i = 0 ; i < n ; i++){
      for(int j = 0 ; j < n ; j++){
        if(arr[i][j] != 0){
          int temp = bfs(i,j);
          answer = temp == -1 ? answer : Math.min(temp,answer);
        }
      }
    }
    System.out.println(answer);
  }
  static int bfs(int y, int x){
//    System.out.println("--------------------------------");
    int result = -1;
    Queue<Node> queue = new LinkedList<>();
    queue.offer(new Node(y,x));
    boolean[][] visited = new boolean[n][n];
    visited[y][x] = true;
    int[][] dp = new int[n][n];
    int num = arr[y][x];
    while(!queue.isEmpty()){
      Node node = queue.poll();
//      System.out.println(node);
      for(int i = 0 ; i < 4 ; i++){
        int nextY = node.y + dirY[i];
        int nextX = node.x + dirX[i];
        if(nextY >= 0 && nextY < n && nextX >= 0 && nextX < n
                && arr[nextY][nextX] != num && !visited[nextY][nextX]){
          if(arr[nextY][nextX] != 0){
//            System.out.println("dp : " + dp[node.y][node.x]);
            return dp[node.y][node.x];
          }
          queue.offer(new Node(nextY, nextX));
          visited[nextY][nextX] = true;
          dp[nextY][nextX] = dp[node.y][node.x] + 1;
        }
      }

    }
    return result;
  }
  static class Node{
    int y;
    int x;
    Node(int y, int x){
      this.y = y;
      this.x = x;
    }
    @Override
    public String toString(){
      return "y : " + y + " , x : " + x;
    }
  }
}
