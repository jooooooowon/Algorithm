package Algorithm.algorithm.programmers.in_2024;
import java.util.*;
public class P_240617_등굣길 {
  static final Integer MOD = 1000000007;
  public int solution(int m, int n, int[][] puddles) {
    int answer = 0;
    int[][] arr = new int[n + 1][m  + 1];
    boolean[][] visited = new boolean[n + 1][m + 1];
    for(int[] puddle : puddles){
      int x = puddle[0];
      int y = puddle[1];
      visited[y][x] = true;
    }

    for(int i = 1 ; i < m + 1 ; i++){
      if(visited[1][i]) break;
      arr[1][i] = 1;
    }

    for(int i = 1 ; i < n + 1 ; i++){
      if(visited[i][1]) break;
      arr[i][1] = 1;
    }

    int min = Math.min(m,n);
    // System.out.println(min);
    for(int i = 2; i < min + 1; i++){
      for(int x = i ; x < m + 1 ; x++){
        if(visited[i][x]){
          continue;
        }
        arr[i][x] = (arr[i-1][x] % MOD + arr[i][x-1] % MOD) % MOD;
      }
      for(int y = i ; y < n + 1 ; y++){
        if(visited[y][i]){
          continue;
        }
        arr[y][i] = (arr[y-1][i] % MOD + arr[y][i-1] % MOD) % MOD;
      }
    }
    answer = arr[n][m];

    // for(int i = 0 ; i < n + 1 ;i++){
    //     for(int j = 0 ; j < m + 1 ; j++){
    //      System.out.print(arr[i][j] + " ");
    //     }
    //     System.out.println();
    // }
    return answer;
  }
}
