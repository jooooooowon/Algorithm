package Algorithm.algorithm.baekjoon.in_2024;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class B_240220_무한수열_1351 {
    static long p;
    static long q;
    static Map<Long, Long> map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        p = Long.parseLong(st.nextToken());
        q = Long.parseLong(st.nextToken());
        map = new HashMap<>();
        System.out.println(find(n));
    }

    private static long find(long num) {
        if (num == 0) {
            return 1;
        }
        if (map.get(num) != null) {
            return map.get(num);
        }
        long temp = find(num / p) + find(num / q);
        map.put(num, temp);
        return temp;
    }
}
