package Algorithm.algorithm.baekjoon.in_2024;

import java.util.Scanner;

public class B_240915_교수가_된_현우 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for(int i = 0 ; i < n ; i++){
      int num = sc.nextInt();
      int divideTwo = find(num,2);
      int divideFive = find(num, 5);
      System.out.println(Math.min(divideTwo, divideFive));
    }
  }
  private static int find(int num, int divideNum){
    int count = 0;
    int power = 1;
    while(true){
      int temp = num / (int)Math.pow(divideNum,power++);
      if(temp == 0){
        break;
      }
      count += temp;
    }
    return count;
  }
}
