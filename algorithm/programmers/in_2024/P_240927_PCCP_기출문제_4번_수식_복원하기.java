package Algorithm.algorithm.programmers.in_2024;

import java.util.*;

public class P_240927_PCCP_기출문제_4번_수식_복원하기 {

  public String[] solution(String[] expressions) {

    Set<Integer> set = new HashSet<>();
    for (int i = 1; i <= 9; i++) {
      set.add(i);
    }
    List<String> answerList = new ArrayList<>();
    for (String str : expressions) {
      StringTokenizer st = new StringTokenizer(str);
      String num1 = st.nextToken();
      String plus = st.nextToken();
      String num2 = st.nextToken();
      st.nextToken();
      String result = st.nextToken();
      for (int i = 0; i < num1.length(); i++) {
        for (int j = 1; j <= num1.charAt(i) - '0'; j++) {
          set.remove(j);
        }
      }
      for (int i = 0; i < num2.length(); i++) {
        for (int j = 1; j <= num2.charAt(i) - '0'; j++) {
          set.remove(j);
        }
      }
      if (!result.equals("X")) {
        for (int i = 0; i < result.length(); i++) {
          for (int j = 1; j <= result.charAt(i) - '0'; j++) {
            set.remove(j);
          }
        }
        List<Integer> list = new ArrayList<>();
        for (int form : set) {
          int number1 = 0;
          for (int i = 0; i < num1.length(); i++) {
            number1 += (num1.charAt(i) - '0') * Math.pow(form, Math.abs(num1.length() - (i + 1)));
          }

          int number2 = 0;
          for (int i = 0; i < num2.length(); i++) {
            number2 += (num2.charAt(i) - '0') * Math.pow(form, Math.abs(num2.length() - (i + 1)));
          }

          int resultNum = 0;
          for (int i = 0; i < result.length(); i++) {
            resultNum += (result.charAt(i) - '0') * Math.pow(form, Math.abs(result.length() - (i + 1)));
          }
          if (plus.equals("+") && number1 + number2 != resultNum) {
            list.add(form);
          } else if (plus.equals("-") && number1 - number2 != resultNum) {
            list.add(form);
          }
        }
        for (int form : list) {
          set.remove(form);
        }
      } else {
        answerList.add(str);
      }

      // System.out.println(set.toString());
    }
    String[] answer = new String[answerList.size()];

    for (int idx = 0; idx < answerList.size(); idx++) {
      String str = answerList.get(idx);
      String tempResult = new String();
      StringTokenizer st = new StringTokenizer(str);
      String num1 = st.nextToken();
      String plus = st.nextToken();
      String num2 = st.nextToken();
      boolean tf = true;
      for (int form : set) {
        int number1 = 0;
        for (int i = 0; i < num1.length(); i++) {
          number1 += (num1.charAt(i) - '0') * Math.pow(form, Math.abs(num1.length() - (i + 1)));
        }

        int number2 = 0;
        for (int i = 0; i < num2.length(); i++) {
          number2 += (num2.charAt(i) - '0') * Math.pow(form, Math.abs(num2.length() - (i + 1)));
        }

        StringBuilder sb = new StringBuilder();
        int resultNum = 0;
        if (plus.equals("+")) {
          resultNum = number1 + number2;
        } else {
          resultNum = number1 - number2;
        }
        if (resultNum == 0) {
          sb.append(0);
        }
        while (resultNum > 0) {
          sb.insert(0, resultNum % form);
          resultNum /= form;
        }
        if (tempResult.isEmpty()) {
          tempResult = sb.toString();
        } else if (!tempResult.equals(sb.toString())) {
          tf = false;
          break;
        }
      }
      if (tf) {
        answer[idx] = str.replaceAll("X", tempResult);
      } else {
        answer[idx] = str.replaceAll("X", "?");
      }
    }
    // System.out.println(answerList.toString());
    // System.out.println(Arrays.toString(answer));

    return answer;
  }
}
