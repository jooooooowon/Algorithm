package Algorithm.algorithm.goorm;
import java.io.*;
import java.util.*;

public class G_241008_현대모비스_예선_주차시스템 {
  static int result = 0;
  static int[][] arr;
  static int n;
  static int m;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    arr = new int[n][m];
    for(int i = 0 ; i < n ; i++){
      st = new StringTokenizer(br.readLine());
      for(int j = 0 ; j < m ; j++){
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    int[] dirY = {1,-1,0,0};
    int[] dirX = {0,0,1,-1};
    for(int i = 0 ; i < n ; i++){
      for(int j = 0 ; j < m ; j++){
        int count = 0;
        if(arr[i][j] != 1){
          if(arr[i][j] == 0){
            count = 1;
          }else if(arr[i][j] == 2){
            count = -2;
          }
          Queue<Node> queue = new LinkedList<>();
          queue.offer(new Node(i,j));
          arr[i][j] = 1;
          while(!queue.isEmpty()){
            Node node = queue.poll();

            for(int k = 0 ; k < 4 ; k++){
              int nextY = node.y + dirY[k];
              int nextX = node.x + dirX[k];
              if(nextY >= 0 && nextY < n && nextX >= 0 && nextX < m && arr[nextY][nextX] != 1){
                if(arr[nextY][nextX] == 0){
                  count += 1;
                }else if(arr[nextY][nextX] == 2){
                  count += -2;
                }
                arr[nextY][nextX] = 1;
                queue.offer(new Node(nextY, nextX));
              }
            }
          }
        }
        result = Math.max(result, count);
      }
    }
    System.out.println(result);
  }
  static class Node{
    int y;
    int x;
    Node(int y, int x){
      this.y = y;
      this.x = x;
    }
  }
}
