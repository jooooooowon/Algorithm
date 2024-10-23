package Algorithm.algorithm.baekjoon.in_2024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_240205_합이_0_3115 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        long count = 0;
        for (int i = 0; i < n; i++) {
            int num = arr[i];
            int start = i + 1;
            int end = n - 1;
            while (start < end) {
                int temp = arr[start] + arr[end];
                if (num + temp > 0) {
                    end--;
                } else if (num + temp < 0) {
                    start++;
                } else {
                    if (arr[start] == arr[end]) {
                        int cnt = end - start + 1;
                        count += (cnt * (cnt - 1)) / 2;
                        end = start - 1;
                    } else {
                        int startIndex = start;
                        while (arr[startIndex] == arr[start]) {
                            startIndex++;
                        }
                        int endIndex = end;
                        while (arr[endIndex] == arr[end]) {
                            endIndex--;
                        }
                        count += (startIndex - start) * (end - endIndex);
                        start = startIndex;
                        end = endIndex;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
