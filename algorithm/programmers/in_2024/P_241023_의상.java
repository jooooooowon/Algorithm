package Algorithm.algorithm.programmers.in_2024;

import java.util.HashMap;
import java.util.Map;
public class P_241023_의상 {
  public int solution(String[][] clothes) {
    int answer = 1;
    int n = clothes.length;
    Map<String,Integer> map = new HashMap<>();
    for(int i = 0 ; i < n ;i++){
      map.put(clothes[i][1],map.getOrDefault(clothes[i][1],0) + 1);
    }
    for(String key : map.keySet()){
      answer *= map.get(key) + 1;
    }

    return answer-1;
  }
}
