package Algorithm.algorithm.programmers.in_2024;

import java.util.Arrays;

public class P_240422_이진변환반복하기 {
  public static int[] solution(String s) {
    int[] answer = new int[2];
    int zeroCount = 0;
    int count = 0;
    int num = 0;
    num = makeDecimal(s);
    System.out.println("num : " + num);
    while (num != 1) {
      count++;
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) == '1') {
          sb.append("1");
        } else {
          zeroCount++;
        }
      }
      Integer len = sb.length();
      sb = new StringBuilder();
      while (len > 0) {
        sb.append(len % 2);
        len /= 2;
      }
      s = sb.toString();
      num = makeDecimal(s);
    }
    answer[0] = count;
    answer[1] = zeroCount;
    return answer;
  }

  private static int makeDecimal(String str) {
    int num = 0;
    for (int i = 0; i < str.length(); i++) {
      if(str.charAt(i) == '1'){
        num += Math.pow(2,i);
      }
    }
    return num;
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(solution("1111111")));

  }
}
