package Algorithm.algorithm.programmers.in_2024;

import java.util.*;
public class P_241116_모의고사1_유전법칙 {
  List<String> list = new ArrayList<>();
  public String[] solution(int[][] queries) {

    for(int[] query : queries){
      int n = query[0];
      int p = query[1];
      long startCnt = (long) Math.pow(4, n - 1);
      // System.out.println(startCnt);
      find(1,p,startCnt,0L,n,"Rr");
    }
    // System.out.println(list.toString());
    String[] answer = new String[list.size()];
    for(int i = 0 ; i < answer.length; i++){
      answer[i] = list.get(i);
    }
    return answer;
  }

  void find(int depth, int p, long maxCount, long minCount, int n, String str){
    // System.out.println("depth : " + depth + " maxCount : " +maxCount);
    if(n == depth){
      list.add(str);
      return;
    }
    long temp = (maxCount - minCount) / 4;
    if(p <= minCount + temp){
      long nextMaxCount = minCount + temp;

      if(str.equals("rr")){
        find(depth + 1, p, nextMaxCount, nextMaxCount - temp, n, "rr");
      }else{
        find(depth + 1, p, nextMaxCount, nextMaxCount - temp, n, "RR");
      }
    }else if(p <= minCount + temp * 2){
      long nextMaxCount = minCount + temp * 2;
      if(str.equals("RR")){
        find(depth + 1, p, nextMaxCount, nextMaxCount - temp, n, "RR");
      }else if(str.equals("rr")){
        find(depth + 1, p, nextMaxCount, nextMaxCount - temp, n, "rr");
      }else {
        find(depth + 1, p, nextMaxCount, nextMaxCount - temp, n, "Rr");
      }
    }else if(p <= minCount + temp * 3){
      long nextMaxCount = minCount + temp * 3;
      if(str.equals("RR")){
        find(depth + 1, p, nextMaxCount, nextMaxCount - temp, n, "RR");
      }else if(str.equals("rr")){
        find(depth + 1, p, nextMaxCount, nextMaxCount - temp, n, "rr");
      }else {
        find(depth + 1, p, nextMaxCount, nextMaxCount - temp, n, "Rr");
      }
    }else{
      long nextMaxCount = minCount + temp * 4;
      if(str.equals("RR")){
        find(depth + 1, p, nextMaxCount, nextMaxCount - temp, n, "RR");
      }else{
        find(depth + 1, p, nextMaxCount, nextMaxCount - temp, n, "rr");
      }
    }
  }
}
