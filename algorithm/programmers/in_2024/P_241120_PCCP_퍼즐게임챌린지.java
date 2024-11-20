package Algorithm.algorithm.programmers.in_2024;
import java.util.*;
public class P_241120_PCCP_퍼즐게임챌린지 {
      public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        int min = 1;
        int max = 100000;
        int n = diffs.length;
        while(min <= max){
            int mid = (min + max) / 2;
            long tempTime = times[0];
            
            for(int i = 1 ; i < n; i++){
                if(diffs[i] > mid){
                    tempTime += (diffs[i] - mid) * (times[i] + times[i-1]);
                    tempTime += times[i];
                }else{
                    tempTime += times[i];
                }
            }
            if(tempTime > limit){
                min = mid + 1;
            }else{
                answer = mid;
                max = mid - 1;
            }
        }
        return answer;
    }
  
}
