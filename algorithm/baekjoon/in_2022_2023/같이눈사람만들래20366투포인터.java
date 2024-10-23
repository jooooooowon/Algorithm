package Algorithm.algorithm.baekjoon.in_2022_2023;

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
					// 혹시 left가 증가하다가 i 혹은 j가 된다면 피해준다.
					if (left == i || left == j) {
						left++;
					}
					// 혹시 right가 감소하다가 i 혹은 j가 된다면 피해준다.
					if (right == i || right == j) {
						right--;
					}
					youngerSister = arr[left] + arr[right];

					// 여기서 olderSister의 눈사람 크기는 잠시 고정되어있지만
					// youngerSister의 눈사람 크기는 투포인터로 변경될 수 있음을 생각하자.
					// 차이 값을 줄이는 것이기 때문에 
					// olderSister의 눈사람 크기가 더 크다면 
					// youngerSister의 눈사람 크기를 키워야하므로 left++
					if(olderSister > youngerSister) {
						left++;
					}
					// olderSister의 눈사람 크기가 더 작다면
					// youngerSister의 눈사람 크기를 줄여야하므로 right--
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
