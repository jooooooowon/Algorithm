package Algorithm.algorithm.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class 같이눈사람만들래20366투포인터 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		// 투포인터를 이용하기 위해 배열들을 정렬해준다.
		Arrays.sort(arr);
		// 임의로 min을 정해준다. n의 최소가 4이기 때문에 0~3의 배열을 이용한다.
		int min = Math.abs((arr[3] + arr[2]) - (arr[1] + arr[0]));
		find: for (int i = 0; i < n; i++) {
			// 최소 2개는 들어가야 하므로 +3부터 확인한다.
			for (int j = i + 3; j < n; j++) {
				int left = i + 1;
				int right = j - 1;
				int olderSister = arr[i] + arr[j];
				int youngerSister = arr[left] + arr[right];
				while (left < right) {
					// min이 0이되면 더 이상 작아질 수가 없기 때문에 끝.
					if (min == 0) {
						break find;
					}
					if (left == i || left == j) {
						left++;
					}
					if (right == i || right == j) {
						right--;
					}
					youngerSister = arr[left] + arr[right];
					if(olderSister > youngerSister) {
						left++;
					}
					if(olderSister < youngerSister) {
						right--;
					}
					min = Math.min(min, Math.abs(olderSister-youngerSister));
				}
			}
		}
		System.out.println(min);
	}
}
