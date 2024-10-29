package Algorithm.algorithm.baekjoon.in_2024;

import java.util.Scanner;

public class B_241030_123더하기4_15989 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int[][] arr = new int[10001][4];
    arr[1][1] = 1;
    arr[2][1] = 1;
    arr[2][2] = 1;
    arr[3][1] = 1;
    arr[3][2] = 1;
    arr[3][3] = 1;
    for(int i = 4 ; i < 10001 ; i++){
      arr[i][1] = arr[i-1][1];
      arr[i][2] = arr[i-2][1] + arr[i-2][2];
      arr[i][3] = arr[i-3][1] + arr[i-3][2] + arr[i-3][3];
    }

    int n = sc.nextInt();
    for(int i = 0 ; i < n ; i++){
      int num = sc.nextInt();
      System.out.println(arr[num][1] + arr[num][2] + arr[num][3]);
    }
  }
}
