package Algorithm.algorithm.programmers.in_2024;

import java.util.HashSet;
import java.util.Set;
public class P_241023_전화번호_목록 {
  public boolean solution(String[] phoneBook) {
    Set<String> set = new HashSet<>();
    for (String phone : phoneBook) {
      set.add(phone);
    }
    for (String phone : phoneBook) {
      for (int i = 0; i < phone.length(); i++) {
        if (set.contains(phone.substring(0, i))) {
          return false;
        }
      }
    }
    return true;
  }
}
