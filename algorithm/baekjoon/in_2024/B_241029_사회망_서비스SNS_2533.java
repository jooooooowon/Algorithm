package Algorithm.algorithm.baekjoon.in_2024;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B_241029_사회망_서비스SNS_2533 {
  static int[][] dp;
  static boolean[] visited;
  static List<Integer>[] arr;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    // 0 : not early adaptor
    // 1 : early adaptor
    dp = new int[n + 1][2];
    visited = new boolean[n + 1];
    arr = new List[n + 1];
    for (int i = 1; i < arr.length; i++) {
      arr[i] = new ArrayList<>();
    }
    for (int i = 0; i < n - 1; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      arr[start].add(end);
      arr[end].add(start);
    }
    dfs(1);
    System.out.println(Math.min(dp[1][1], dp[1][0]));
  }

  static void dfs(int num) {
    if (visited[num]) {
      return;
    }
    visited[num] = true;
    dp[num][1] = 1;
    for (int temp : arr[num]) {
      if(!visited[temp]){
        dfs(temp);
        dp[num][0] += dp[temp][1];
        dp[num][1] += Math.min(dp[temp][0], dp[temp][1]);
      }
    }
  }
}
