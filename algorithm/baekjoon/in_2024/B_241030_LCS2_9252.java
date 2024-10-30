package Algorithm.algorithm.baekjoon.in_2024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B_241030_LCS2_9252 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str1 = br.readLine();
    String str2 = br.readLine();
    int n = str1.length();
    char[] strN = new char[n+1];
    for(int i = 0 ; i < n ; i++){
      strN[i+1] = str1.charAt(i);
    }
    int m = str2.length();
    char[] strM = new char[m+1];
    for(int i = 0 ; i < m ; i++){
      strM[i+1] = str2.charAt(i);
    }
    int[][] arr = new int[n + 1][m + 1];
    for(int i = 1 ; i <= n ; i++){
      for(int j = 1 ; j <= m ; j++){
        if(strN[i] == strM[j]){
          arr[i][j] = arr[i-1][j-1] + 1;
        }else{
          arr[i][j] = Math.max(arr[i-1][j], arr[i][j-1]);
        }
      }
    }
    int num = arr[n][m];
    int y = n;
    int x = m;
    StringBuilder sb = new StringBuilder();
    while(true){
      if(arr[y][x] == 0) break;
      while(arr[y][x] == arr[y-1][x]){
        y--;
      }
      while(arr[y][x] == arr[y][x-1]){
        x--;
      }
      if(strN[y] == strM[x]){
        sb.append(strN[y]);
        y--;
        x--;
      }
    }

    System.out.println(num);
    System.out.println(sb.reverse().toString());

  }

}
