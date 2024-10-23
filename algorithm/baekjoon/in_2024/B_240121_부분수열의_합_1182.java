package Algorithm.algorithm.baekjoon.in_2024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_240121_부분수열의_합_1182 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());

        for(int i = 0 ; i < n ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int result = 0;
        for(int num = 0 ; num < (1 << n) ; num++){
            int temp = 0;
            boolean tf = false;
            for(int bit = 0;  bit < n ; bit++){
                if((num & (1 << bit)) > 0){
                    temp += arr[bit];
                    tf = true;
                }
            }
            if(tf && temp == s){
                result++;
            }
        }
        System.out.println(result);
    }
}
