package Algorithm.algorithm.baekjoon.in_2024;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_241031_배열_돌리기4_17406 {
  static int n;
  static int m;
  static int k;
  static int[][] arr;
  static int[][] rotation;
  static int answer = Integer.MAX_VALUE;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    arr = new int[n][m];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    rotation = new int[k][3];
    for (int i = 0; i < k; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 3; j++) {
        rotation[i][j] = Integer.parseInt(st.nextToken());
      }
    }
//    for(int[] temp : arr){
//      System.out.println(Arrays.toString(temp));
//    }
    combination(0, new boolean[k], new int[k]);
    System.out.println(answer);
  }

  static void combination(int idx, boolean[] visited, int[] result) {
    if (idx >= k) {
      make(result);
      return;
    }
    for (int i = 0; i < k; i++) {
      if (visited[i]) continue;
      visited[i] = true;
      result[idx] = i;
      combination(idx + 1, visited, result);
      visited[i] = false;
    }
  }

  static void make(int[] result) {
    int[][] tempArr = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        tempArr[i][j] = arr[i][j];
      }
    }
//    System.out.println(Arrays.toString(result));
    for (int i = 0; i < k; i++) {
      int idx = result[i];
      rotation(rotation[idx][0], rotation[idx][1], rotation[idx][2], tempArr, 0);
    }
    sumRow(tempArr);
  }

  static void rotation(int r, int c, int s, int[][] tempArr, int size) {
    int leftY = r - s - 1 + size;
    int leftX = c - s - 1 + size;
    int rightY = r + s - 1 - size;
    int rightX = c + s - 1 - size;
    if (leftY >= rightY || leftX >= rightX) {
      return;
    }
    int tempNum = tempArr[leftY][leftX];
    int temp;
    for (int i = leftX; i < rightX; i++) {
      temp = tempArr[leftY][i + 1];
      tempArr[leftY][i + 1] = tempNum;
      tempNum = temp;
    }
    temp = tempArr[leftY + 1][rightX];
    tempArr[leftY + 1][rightX] = tempNum;
    tempNum = temp;
    for (int i = leftY + 1; i < rightY; i++) {
      temp = tempArr[i + 1][rightX];
      tempArr[i + 1][rightX] = tempNum;
      tempNum = temp;
    }
    temp = tempArr[rightY][rightX - 1];
    tempArr[rightY][rightX - 1] = tempNum;
    tempNum = temp;
    for (int i = rightX - 1; i > leftX; i--) {
      temp = tempArr[rightY][i - 1];
      tempArr[rightY][i - 1] = tempNum;
      tempNum = temp;
    }
    temp = tempArr[rightY - 1][leftX];
    tempArr[rightY - 1][leftX] = tempNum;
    tempNum = temp;
    for (int i = rightY - 1; i > leftY; i--) {
      temp = tempArr[i-1][leftX];
      tempArr[i - 1][leftX] = tempNum;
      tempNum = temp;
    }
//    System.out.println("------------------------------------------------------------");
//    for(int[] tempA : tempArr){
//      System.out.println(Arrays.toString(tempA));
//    }
    rotation(r, c, s, tempArr, size + 1);
  }

  static void sumRow(int[][] tempArr) {

    for (int i = 0; i < n; i++) {
      int sum = 0;
      for (int j = 0; j < m; j++) {
        sum += tempArr[i][j];
      }
      answer = Math.min(answer,sum);
    }
  }
}
