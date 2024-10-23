package Algorithm.algorithm.baekjoon.in_2024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B_240915_NBA_농구 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] teamScore = new int[3];
    int[] teamTime = new int[3];
    int lastTime = 0;
    for(int i = 0 ; i < n ; i++){
      StringTokenizer st = new StringTokenizer(br.readLine());
      int goaler = Integer.parseInt(st.nextToken());
      String[] time = st.nextToken().split(":");
      int min = Integer.parseInt(time[0]);
      int sec = Integer.parseInt(time[1]);
      int newTime = min * 60 + sec;
      if(teamScore[1] > teamScore[2]){
        teamTime[1] += (newTime - lastTime);
      }else if(teamScore[2] > teamScore[1]){
        teamTime[2] += (newTime - lastTime);
      }

      lastTime = newTime;
      teamScore[goaler]++;
    }

    if(teamScore[1] > teamScore[2]){
      teamTime[1] += (48*60 - lastTime);
    }else if(teamScore[2] > teamScore[1]){
      teamTime[2] += (48*60 - lastTime);
    }
    for(int i = 1 ; i <= 2 ; i++){
      int min = teamTime[i] / 60;
      int sec = teamTime[i] % 60;
      StringBuilder sb = new StringBuilder();
      sb.append(min < 10 ? "0" + min : min);
      sb.append(":");
      sb.append(sec < 10 ? "0" + sec : sec);
      System.out.println(sb.toString());
    }

  }
}
