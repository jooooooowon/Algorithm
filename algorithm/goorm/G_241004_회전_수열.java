package Algorithm.algorithm.goorm;

import java.util.*;
import java.io.*;
public class G_241004_회전_수열 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    int[] originArr = new int[n];
    int[] tempArr = new int[n];
    for(int i = 0 ; i < n ; i++){
      originArr[i] = Integer.parseInt(st.nextToken());
      tempArr[i] = originArr[i];
    }
    int temp = 0;
    for(int i = 0 ; i < m ; i++){
      temp += originArr[temp];
      temp %= n;
    }

    System.out.println(originArr[temp]);

  }
}
