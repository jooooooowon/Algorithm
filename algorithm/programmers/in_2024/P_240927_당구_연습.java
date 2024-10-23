package Algorithm.algorithm.programmers.in_2024;

import java.util.*;

public class P_240927_당구_연습 {
  public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
    int ballCount = balls.length;
    int[] answer = new int[ballCount];
    for (int i = 0; i < ballCount; i++) {
      // x,y
      // 0 y Up, 1 y Down, 2 x Right, 3 x Left
      int[][] newBalls = new int[4][2];
      newBalls[0][1] = n - balls[i][1] + n;
      newBalls[0][0] = balls[i][0];
      newBalls[1][1] = -balls[i][1];
      newBalls[1][0] = balls[i][0];
      newBalls[2][1] = balls[i][1];
      newBalls[2][0] = m - balls[i][0] + m;
      newBalls[3][1] = balls[i][1];
      newBalls[3][0] = -balls[i][0];

      int min = Integer.MAX_VALUE;

      if (balls[i][0] == startX) {
        for (int j = 2; j < 4; j++) {
          int temp = (int) Math.pow(startX - newBalls[j][0], 2) + (int) Math.pow(startY - newBalls[j][1], 2);
          min = Math.min(min, temp);
        }

        if (balls[i][1] > startY) {
          min = Math.min(min, (int) Math.pow(startY * 2 + balls[i][1] - startY, 2));
        } else {
          min = Math.min(min, (int) Math.pow((n - startY) * 2 + startY - balls[i][1], 2));
        }
      } else if (balls[i][1] == startY) {
        for (int j = 0; j < 2; j++) {
          int temp = (int) Math.pow(startX - newBalls[j][0], 2) + (int) Math.pow(startY - newBalls[j][1], 2);
          min = Math.min(min, temp);
        }

        if (balls[i][0] > startX) {
          min = Math.min(min, (int) Math.pow(startX * 2 + balls[i][0] - startX, 2));
        } else {
          min = Math.min(min, (int) Math.pow((m - startX) * 2 + startX - balls[i][0], 2));
        }
      } else {
        for (int j = 0; j < 4; j++) {
          int temp = (int) Math.pow(startX - newBalls[j][0], 2) + (int) Math.pow(startY - newBalls[j][1], 2);
          min = Math.min(min, temp);
        }
      }

      answer[i] = min;
    }
    return answer;
  }
}

