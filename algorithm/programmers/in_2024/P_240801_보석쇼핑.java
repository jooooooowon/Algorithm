package Algorithm.algorithm.programmers.in_2024;

import java.util.*;
public class P_240801_보석쇼핑 {
  public int[] solution(String[] gems) {
    Map<String, Integer> map = new HashMap<>();
    Set<String> set = new HashSet<>();
    for(String gem : gems){
      set.add(gem);
    }

    int[] answer = new int[2];

    int start = 0;
    int n = gems.length;
    int len = n;

    for(int end = 0; end < n ; end++){
      map.put(gems[end], map.getOrDefault(gems[end],0) + 1);

      while(map.get(gems[start]) > 1){
        map.put(gems[start], map.get(gems[start]) - 1);
        start++;
      }

      if(map.size() == set.size() && len > (end - start)){
        answer[0] = start + 1;
        answer[1] = end + 1;
        len = end - start;
      }

    }


    return answer;
  }
}
