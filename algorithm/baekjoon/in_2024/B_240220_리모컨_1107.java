package Algorithm.algorithm.baekjoon.in_2024;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_240220_리모컨_1107 {
    static boolean[] arr;
    static int min;
    static ArrayList<Integer> list;
    static int n;
    static int maxSize;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        arr = new boolean[10];
        Arrays.fill(arr, true);
        list = new ArrayList<>();
        if(m != 0){
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);

            for (int i = 0; i < m; i++) {
                int channel = Integer.parseInt(st.nextToken());
                arr[channel] = false;
            }
        }
        for (int i = 0; i < 10; i++) {
            if (arr[i]) {
                list.add(i);
            }
        }
        min = Math.abs(100 - n);
        StringBuilder sb = new StringBuilder();
        maxSize = String.valueOf(n).length();
        permu(sb);
        System.out.println(min);
    }

    private static void permu(StringBuilder sb) {
        if(!sb.toString().isEmpty() && sb.length() != 0){
            min = Math.min(min, Math.abs(n - Integer.parseInt(sb.toString())) + sb.length());
        }
        if(sb.length() == maxSize + 1){
            return ;
        }
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            permu(sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
