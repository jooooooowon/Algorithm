package Algorithm.algorithm.baekjoon.in_2024;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class B_241031_야구 {
  static int[][] innings;
  static int n;
  static int answer = 0;
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    innings = new int[n][9];
    for(int i = 0 ; i < n ; i++){
      StringTokenizer st = new StringTokenizer(br.readLine());
      for(int j = 0 ; j < 9 ; j++){
        innings[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    // 3 = 0
    int[] players = new int[9];
    boolean[] visited = new boolean[9];
    visited[0] = true;
    combination(0, players, visited);
    System.out.println(answer);
  }
  static void combination(int idx, int[] players, boolean[] visited){
    if(idx >= 9){
      playGround(players);
      return ;
    }
    if(idx == 3){
      combination(idx + 1, players, visited);
      return ;
    }
    for(int i = 1; i < 9 ; i++){
      if(visited[i]) continue;
      players[idx] = i;
      visited[i] = true;
      combination(idx + 1, players, visited);
      visited[i] = false;
    }
  }
  static void playGround(int[] players){
    int playerIdx = 0;
    // 0 : empty base, 1 : player on base
    int count = 0;
    for(int i = 0 ; i < n ; i++){
      int outCount = 0;
      boolean[] base = new boolean[3];
      while(outCount < 3){
        if(playerIdx >= 9){
          playerIdx = 0;
        }
        int player = players[playerIdx++];
        int temp = innings[i][player];
        if(temp == 0){
          outCount++;
        }else if(temp == 1){
          if(base[2]){
            count++;
          }
          base[2] = base[1];
          base[1] = base[0];
          base[0] = true;
        }else if(temp == 2){
          if(base[2]){
            count++;
          }
          if(base[1]){
            count++;
          }
          base[2] = base[0];
          base[1] = true;
          base[0] = false;
        }else if(temp == 3){
          if(base[2]){
            count++;
          }
          if(base[1]){
            count++;
          }
          if(base[0]){
            count++;
          }
          base[2] = true;
          base[1] = false;
          base[0] = false;
        }else if(temp == 4){
          count++;
          if(base[2]){
            count++;
          }
          if(base[1]){
            count++;
          }
          if(base[0]){
            count++;
          }
          base[2] = false;
          base[1] = false;
          base[0] = false;
        }
      }
    }
    answer = Math.max(answer, count);
  }

}
