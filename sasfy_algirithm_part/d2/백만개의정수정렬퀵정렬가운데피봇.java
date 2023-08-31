package Algorithm.sasfy_algirithm_part.d2;

import java.io.IOException;
import java.util.Arrays;

public class 백만개의정수정렬퀵정렬가운데피봇 {
	public static void main(String[] args) throws IOException {
		int[] arr = { 9, 2, 8, 3, 7, 4, 6, 5, 0, 10 };

		quickSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

	private static int[] quickSort(int[] arr, int left, int right) {
		int pivot = arr[(left + right) / 2];
		int tempLeft = left;
		int tempRight = right;
		while (tempLeft <= tempRight) {
			while (arr[tempLeft] < pivot) {
				tempLeft++;
			}
			while (arr[tempRight] > pivot) {
				tempRight--;
			}
			if (tempLeft <= tempRight) {
				int temp = arr[tempLeft];
				arr[tempLeft] = arr[tempRight];
				arr[tempRight] = temp;
				tempLeft++;
				tempRight--;
			}
		}

		if (left < tempRight) {
			quickSort(arr, left, tempRight);
		}
		if (tempLeft < right) {
			quickSort(arr, tempLeft, right);
		}
		return arr;
	}
}
