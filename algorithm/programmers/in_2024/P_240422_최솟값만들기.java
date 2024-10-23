package Algorithm.algorithm.programmers.in_2024;

import java.util.Arrays;
import java.util.Collections;

public class P_240422_최솟값만들기 {
  public int solution(int[] A, int[] B) {
    int answer = 0;
    Integer[] Aarray = new Integer[A.length];
    for (int i = 0; i < A.length; i++) {
      Aarray[i] = A[i];
    }
    Integer[] Barray = new Integer[B.length];
    for (int i = 0; i < B.length; i++) {
      Barray[i] = B[i];
    }
    Arrays.sort(Aarray);
    Arrays.sort(Barray, Collections.reverseOrder());
    for (int i = 0; i < Aarray.length; i++) {
      int temp = Aarray[i] * Barray[i];
      answer += temp;
    }

    return answer;
  }
}
