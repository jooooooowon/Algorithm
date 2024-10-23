package Algorithm.algorithm.programmers.in_2024;

import java.util.HashSet;
import java.util.Set;

public class P_241023_폰켓몬 {
  public int solution(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int num : nums) {
      if (!set.contains(num)) {
        set.add(num);
      }
    }
    if (set.size() > nums.length / 2) {
      return nums.length / 2;
    }
    return set.size();
  }
}
