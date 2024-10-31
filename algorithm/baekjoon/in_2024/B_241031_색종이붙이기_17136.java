package Algorithm.algorithm.baekjoon.in_2024;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_241031_색종이붙이기_17136 {
  static int[] papers = {0,5,5,5,5,5};
  static int answer = 101;
  static boolean[][] visited = new boolean[10][10];
  static int[][] arr = new int[10][10];
  public static void main(String[] args) throws Exception{

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    for(int i = 0 ; i < 10 ; i++){
      StringTokenizer st = new StringTokenizer(br.readLine());
      for(int j = 0 ; j < 10 ; j++){
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    dfs(0,0,0);
    System.out.println(answer == 101 ? -1 : answer);
  }

  static void dfs(int y, int x, int count){
    if(x > 9 && y >= 9){
      answer = Math.min(answer,count);
      return ;
    }
    if(x > 9){
      dfs(y + 1 , 0, count);
      return ;
    }
    if(!visited[y][x] && arr[y][x] == 1){
      for(int i = 5 ; i >= 1 ; i--){
        if(papers[i] > 0){
          if(chkPapers(y,x,i)){
            papers[i]--;
            putPapers(y,x,i);
            dfs(y,x + 1,count + 1);
            putPapers(y,x,i);
            papers[i]++;
          }
        }
      }
    }else{
      dfs(y, x + 1 , count);
    }
  }
  static void putPapers(int y, int x, int size){
    for(int i = y ; i < y + size; i++){
      for(int j = x ; j < x + size ; j++){
        visited[i][j] = !visited[i][j];
      }
    }
  }
  static boolean chkPapers(int y, int x, int size){
    for(int i = y ; i < y + size; i++){
      for(int j = x ; j < x + size ; j++){
        if(i > 9 || j > 9 || arr[i][j] != 1 || visited[i][j]){
          return false;
        }
      }
    }
    return true;
  }
}
