package Algorithm.algorithm.programmers.in_2024;
import java.util.*;

public class P_240915_스킬트리 {
    public int solution(String skill, String[] skill_trees) {
      int answer = 0;
      Map<Character, Integer> map = new HashMap<>();
      for(int i = 0 ; i < skill.length(); i++){
        map.put(skill.charAt(i),i);
      }
      for(String skill_tree : skill_trees){
        int index = 0;
        boolean tf = true;
        for(char ch : skill_tree.toCharArray()){
          if(map.get(ch) != null){
            if(map.get(ch) == index){
              index++;
            }else{
              tf = false;
              break;
            }
          }
        }
        if(tf){
          answer++;
        }

      }
      return answer;
    }
}
