package Algorithm.algorithm.programmers.in_2024;

import java.util.*;

public class P_241122_아날로그_시계 {
  public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
    int answer = 0;

    int startSecond = h1 * 3600 + m1 * 60 + s1;
    int endSecond = h2 * 3600 + m2 * 60 + s2;
    for (int i = startSecond; i < endSecond; i++) {
      Time nowTime = new Time(i);
      Time nextTime = new Time(i + 1);

      double[] nowDegree = nowTime.getDegree();
      double[] nextDegree = nextTime.getDegree();
      boolean tfMin = false;
      boolean tfHour = false;
      // System.out.println(Arrays.toString(nowDegree));
      // System.out.println(Arrays.toString(nextDegree));
      if (nowDegree[2] < nowDegree[0] && (nextDegree[2] >= nextDegree[0] || nowDegree[2] == 354)) {
        tfHour = true;
      }
      if (nowDegree[2] < nowDegree[1] && (nextDegree[2] >= nextDegree[1] || nowDegree[2] == 354)) {
        tfMin = true;
      }
      if (tfHour) {
        answer++;
      }
      if (tfMin) {
        answer++;
      }
      if (tfHour && tfMin && nextDegree[2] == nextDegree[1]) {
        answer--;
      }
    }
    if (startSecond == 0 || startSecond == 12 * 3600) {
      answer++;
    }
    return answer;
  }

  class Time {
    int h;
    int m;
    int s;

    Time(int second) {
      this.h = second / 3600;
      this.m = (second % 3600) / 60;
      this.s = (second % 3600) % 60;
    }

    double[] getDegree() {
      double[] temp = new double[3];
      temp[0] = (this.h % 12) * 30d + this.m * 0.5d + this.s * (1d / 120d);
      temp[1] = this.m * 6d + this.s * 0.1d;
      temp[2] = this.s * 6d;
      return temp;
    }

    @Override
    public String toString() {
      return "h : " + h + " m : " + m + " s : " + s;
    }
  }
}
