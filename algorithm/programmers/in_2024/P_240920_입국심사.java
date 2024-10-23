package Algorithm.algorithm.programmers.in_2024;

import java.util.*;

public class P_240920_입국심사 {
  public long solution(int n, int[] times) {
    long answer = 0;
    long maxTime = 1;
    for (long time : times) {
      maxTime = Math.max(maxTime, time);
    }
    // Arrays.sort(times);

    maxTime *= (long) n;
    long minTime = 1;
    while (minTime <= maxTime) {
      long midTime = (minTime + maxTime) / 2;
      long temp = 0;
      for (long time : times) {
        temp += midTime / time;
      }
      if (temp >= n) {
        maxTime = midTime - 1;
        answer = midTime;
      } else if (temp < n) {
        minTime = midTime + 1;
      }
    }
    return answer;
  }
}
