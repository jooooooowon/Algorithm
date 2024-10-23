package Algorithm.algorithm.goorm;
import java.util.*;
import java.io.*;

public class G_241008_0커플 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PriorityQueue<Integer> positivePque = new PriorityQueue<>();
    PriorityQueue<Integer> negativePque = new PriorityQueue<>(Collections.reverseOrder());
    int n = Integer.parseInt(br.readLine());
    String[] arr = br.readLine().split(" ");
    for(int i = 0 ; i < n ; i++){
      if(Integer.parseInt(arr[i]) < 0){
        negativePque.offer(Integer.parseInt(arr[i]));
      }else{
        positivePque.offer(Integer.parseInt(arr[i]));
      }
    }
    // System.out.println(negativePque.toString());
    // System.out.println(positivePque.toString());
    int result = 0;
    while(!negativePque.isEmpty() && !positivePque.isEmpty()){
      int tempNum = negativePque.peek() + positivePque.peek();
      if(tempNum == 0){
        negativePque.poll();
        positivePque.poll();
      }else if(tempNum > 0){
        result += negativePque.poll();
      }else{
        result += positivePque.poll();
      }
    }
    while(!negativePque.isEmpty()){
      result += negativePque.poll();
    }
    while(!positivePque.isEmpty()){
      result += positivePque.poll();
    }

    System.out.println(result);
  }
}
