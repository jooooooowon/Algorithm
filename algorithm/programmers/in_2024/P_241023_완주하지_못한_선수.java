package Algorithm.algorithm.programmers.in_2024;

import java.util.HashMap;
import java.util.Map;

public class P_241023_완주하지_못한_선수 {
  public String solution(String[] participant, String[] completion) {
    String answer = "";
    Map<String,Integer> map = new HashMap<>();
    for(String person : participant){
      map.put(person, map.getOrDefault(person, 0 ) + 1);
    }
    for(String person : completion){
      int num = map.get(person) - 1;
      if(num == 0){
        map.remove(person);
      }else{
        map.put(person, num);
      }
    }
    for(String key : map.keySet()){
      answer = key;
    }
    return answer;
  }
}
