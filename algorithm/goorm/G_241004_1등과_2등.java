package Algorithm.algorithm.goorm;
import java.io.*;
public class G_241004_1등과_2등 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine();
    boolean twoToOne = false;
    boolean oneToTwo = false;
    for(int i = 0 ; i < input.length() - 1; i++){
      if(!twoToOne && input.charAt(i) == '2' && input.charAt(i + 1) == '1'){
        twoToOne = true;
        i++;
      }else if(!oneToTwo && input.charAt(i) == '1' && input.charAt(i + 1) == '2'){
        oneToTwo = true;
        i++;
      }
    }
    String result = "No";
    if(twoToOne && oneToTwo){
      result = "Yes";
    }
    System.out.println(result);
  }
}
