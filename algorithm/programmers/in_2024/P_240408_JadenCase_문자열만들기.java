package Algorithm.algorithm.programmers.in_2024;

import java.util.Arrays;

public class P_240408_JadenCase_문자열만들기 {
  static public String solution(String s) {
    String answer = "";
    String[] arr = s.split(" ");
    System.out.println(s);
    StringBuilder sb = new StringBuilder();
    System.out.println(Arrays.toString(arr));
//    System.out.println(arr[0].substring(1,arr[0].length()).toLowerCase());
    for (String str : arr) {
      if (str.length() > 0) {

        sb.append(String.valueOf(str.charAt(0)).toUpperCase());
        sb.append(str.substring(1, str.length()).toLowerCase());
      }
      sb.append(" ");
    }
    sb.deleteCharAt(sb.length() - 1);
    int idx = s.length() - 1;
    while (s.charAt(idx--) == ' ') {
      sb.append(" ");
    }
    answer = sb.toString();
    return answer;
  }

  public static void main(String[] args) {
    System.out.println(solution("SdfasdfasdfsS                  1231231231 sdfsdf123123 Sdd      "));
  }
}
