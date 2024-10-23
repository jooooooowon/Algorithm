package Algorithm.algorithm.baekjoon.in_2024;

import java.util.*;

public class B_240130_세_수의_합_2295 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        ArrayList<Integer> sum = new ArrayList<>();


        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                sum.add(arr[i] + arr[j]);
            }
        }
        Arrays.sort(arr);
        Collections.sort(sum);



        int answer = 0;
        loop: for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                int num = arr[i] - arr[j];
                int start = 0;
                int end = sum.size() - 1;
                while (start <= end) {
                    int mid = (start + end) / 2;
                    if (sum.get(mid) == num) {
                        answer = arr[i];
                        break loop;
                    } else if (sum.get(mid) > num) {
                        end = mid - 1;
                    } else {
                        start = mid + 1;
                    }
                }
            }
        }
        System.out.println(answer);
    }

}
