package Algorithm.algorithm.goorm;
import java.io.*;
import java.util.*;

public class G_241008_단풍나무 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[][] arr = new int[n][n];

    for(int i = 0 ; i < n ; i++){
      StringTokenizer st = new StringTokenizer(br.readLine());
      for(int j = 0 ; j < n ;j++){
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    int[] yDir = {1,-1,0,0};
    int[] xDir = {0,0,1,-1};
    int day = 0;
    while(true){
      Queue<Node> queue = new LinkedList<>();
      boolean tf = true;
      for(int i = 0; i < n ; i++){
        for(int j = 0 ; j < n ; j++){
          if(arr[i][j] < 0){
            arr[i][j] = 0;
          }else if(arr[i][j] > 0){
            tf = false;
            queue.offer(new Node(i,j));
          }
        }
      }
      if(tf){
        break;
      }
      day++;
      while(!queue.isEmpty()){
        Node node = queue.poll();
        for(int i = 0 ; i < 4 ; i++){
          int tempX = node.x + xDir[i];
          int tempY = node.y + yDir[i];
          if(tempX >= 0 && tempX < n && tempY >= 0 && tempY < n && arr[tempY][tempX] == 0){
            arr[node.y][node.x]--;
          }
        }
        if(arr[node.y][node.x] <= 0){
          arr[node.y][node.x] = -1;
        }

      }
    }
    System.out.println(day);

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
