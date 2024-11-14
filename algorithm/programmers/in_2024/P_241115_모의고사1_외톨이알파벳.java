package Algorithm.algorithm.programmers.in_2024;

import java.util.*;

public class P_241115_모의고사1_외톨이알파벳 {
  public String solution(String input_string) {
    Map<Character, Integer> map = new HashMap<>();
    map.put(input_string.charAt(0), 1);
    for (int i = 1; i < input_string.length(); i++) {
      if (input_string.charAt(i) != input_string.charAt(i - 1)) {
        map.put(input_string.charAt(i), map.getOrDefault(input_string.charAt(i), 0) + 1);
      }
    }
    List<Character> list = new ArrayList<>();
    for (Character ch : map.keySet()) {
      if (map.get(ch) > 1) {
        list.add(ch);
      }
    }
    Collections.sort(list);
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < list.size(); i++) {
      sb.append(list.get(i));
    }
    if (list.isEmpty()) {
      sb.append("N");
    }
    return sb.toString();
  }
}
