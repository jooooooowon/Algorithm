package Algorithm.algorithm.baekjoon.in_2024;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B_241031_피보나치수_2749 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    final int MOD = 1000000;
    long n = sc.nextLong();
    List<Integer> list = new ArrayList<>();
    int num1 = 0;
    int num2 = 1;
    long num = 2L;
    long count = 1L;
    while(num <= n){
      int temp = (num1 + num2) % MOD;
      num1 = num2;
      num2 = temp;
      list.add(temp);
      if(num1 == 0 && num2 == 1){
        break;
      }
      num++;
      count++;
    }
    int[] arr = new int[(int)count + 1];
    arr[1] = 1;
    for(int i = 2 ; i < arr.length; i++){
      arr[i] = (arr[i-1] + arr[i-2]) % MOD;
    }
    System.out.println(n <= count ? arr[(int)n] : arr[(int)(n % count)]);
  }
}
