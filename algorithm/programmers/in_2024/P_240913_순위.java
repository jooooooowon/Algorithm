package Algorithm.algorithm.programmers.in_2024;
import java.util.*;
public class P_240913_순위 {
  public int solution(int n, int[][] results) {
    int answer = 0;
    Integer[][] scores = new Integer[n][n];
    for(int i = 0 ; i < n ; i++){
      scores[i][i] = 0;
    }
    for(int i = 0 ; i < results.length; i++){
      int winner = results[i][0] - 1;
      int loser = results[i][1] - 1;
      scores[winner][loser] = 1;
      scores[loser][winner] = -1;
    }
    // for(int i = 0 ; i < n ; i++){
    //     for(int j = 0 ; j < n ; j++){
    //         if(scores[i][j] == null){
    //             break;
    //         }
    //         if(scores[i][j].equals(0)){
    //             System.out.println("hi");
    //         }
    //     }
    // }

    for(int i = 0; i < n ; i++){
      for(int j = 0 ; j < n ; j++){
        for(int k =0  ; k < n ; k++){
          if(scores[i][j] == null ){
            break;
          }
          if(scores[i][j].equals(1)){
            if(scores[k][i] != null && scores[k][i].equals(1)){
              scores[k][j] = 1;
              scores[j][k] = -1;
            }
            if(scores[k][j] != null && scores[k][j].equals(-1)){
              scores[k][j] = -1;
              scores[j][k] = 1;
            }
          }
        }
      }
    }
    // for(int i = 0 ; i < n ; i++){
    //     System.out.println(Arrays.toString(scores[i]));
    // }
    for(int i = 0 ; i < n ; i++){
      boolean find = true;
      for(int j = 0 ; j < n ; j++){
        if(scores[i][j] == null){
          find = false;
          break;
        }
      }
      if(find){
        answer++;
      }
    }



    return answer;
  }
}
