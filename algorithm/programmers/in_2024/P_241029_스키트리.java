package Algorithm.algorithm.programmers.in_2024;

import java.util.*;
public class P_241029_스키트리 {
    public int solution(String skill, String[] skill_trees) {
      int answer = 0;
      char[] skillArr = new char[skill.length()];
      for(int i = 0; i < skillArr.length; i++){
        skillArr[i] = skill.charAt(i);
      }
      // System.out.println(Arrays.toString(skillArr));
      // System.out.println(skill_trees[1].charAt(0) == skillArr[0]);
      for(int i = 0 ; i < skill_trees.length; i++){
        boolean tf = true;
        int idx = -1;
        for(int j = 0 ; j < skill_trees[i].length(); j++){
          for(int k = 0 ; k < skillArr.length; k++){
            // System.out.println(skill_trees[i] + " , " + skill_trees[i].charAt(j) + " ,  " + skillArr[k]);
            if(skill_trees[i].charAt(j) == skillArr[k]){
              if(idx < skill.length() && k - 1 == idx){
                // System.out.println(k);
                idx = k;
                break;
              }else{
                tf = false;
                break;
              }
            }
          }
          if(!tf){
            break;
          }
        }
        if(tf){
          answer++;
        }
      }
      return answer;
    }
}
