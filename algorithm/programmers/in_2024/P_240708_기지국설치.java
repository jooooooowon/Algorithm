package Algorithm.algorithm.programmers.in_2024;
import java.util.*;

public class P_240708_기지국설치 {
  public int solution(int n, int[] stations, int w) {
    int start = 1;
    int width = 2 * w + 1;
    int result = 0;
    for(int i = 0 ; i < stations.length; i++){
      int station = stations[i];
      if(start < station - w){
        int temp = (station - w) - start;
        result += temp / width;
        if(temp % width > 0){
          result++;
        }
      }
      start = station + w + 1;
      // System.out.println("start : " + start);
    }

    if(start < n + 1){
      int temp = n + 1 - start;
      if(temp % width == 0){
        result += temp / width;
      }else{
        result += temp / width;
        result++;
      }
    }
    return result;
  }
}
