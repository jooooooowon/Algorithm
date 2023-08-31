package Algorithm.sasfy_algirithm_part.d2;

import java.io.IOException;
import java.util.Arrays;

public class 백만개의정수정렬퀵정렬왼쪽피봇 {
	public static void main(String[] args) throws IOException {
		int[] arr = { 9, 2, 8, 3, 7, 4, 6, 5, 0, 10 };

		quickSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

	private static void quickSort(int[] arr, int left, int right) {
		// 어느 정렬되어 있지 않은 무리의 왼족을 피봇으로 잡는다.
		int pivot = arr[left];

		// 피봇의 바로 오른쪽부터 tempLeft로 잡고 확인한다.
		// tempLeft는 피봇보다 작은 값을 피봇보다 왼쪽으로 옮기기위함이다.
		int tempLeft = left + 1;
		
		// 가장 오른쪽부터 tempRight라고 잡고 확인한다.
		// tempRight는 피봇보다 큰 값을 피봇보다 오른쪽으로 옮기기위함이다.
		int tempRight = right;
		
		// 만약 더 작은 값을 옮기기 위한 tempLeft와 
		// 더 큰 값을 옮기기 위한 tempRight가 교차된다면 정렬을 종료한다.
		while (tempLeft <= tempRight) {
			// tempLeft가 가르키는 원소가 pivot보다 크다면 그 때의 tempLeft를 기억한다.
			// tempLeft가 가르키는 원소가 pivot보다 작다면 내버려두고 pivot보다 더 큰 원소를 찾으러 간다.
			while (tempLeft <= tempRight && arr[tempLeft] <= pivot) {
				tempLeft++;
			}
			// tempRight가 가르키는 원소가 pivot보다 작다면 그 때의 tempRight를 기억한다.
			// tempRight가  가르키는 원소가 pivot보다 크다면 내버려두고 pivot보다 더 작은 원소를 찾으러 간다.
			while (arr[tempRight] > pivot) {
				tempRight--;
			}
			
			// 만약 tempRight가 피봇보다 더 작은 원소를 찾지 못하고,
			// temoLeft가 피봇보다 더 큰 원소를 찾지 못했다면 (즉, tempLeft와 tempRight가 교차하였다면)
			// 피봇보다 작은 값은 왼쪽, 피봇보다 큰 값은 오른쪽에 있음을 알 수 있다.
			// 따라서 tempLeft와 tempRight가 변경해야할 값이 있어 중간에 멈췄다면 (이럴 경우엔 tempLeft와 tempRight가 교차하지 않는다.)
			// tempLeft와 tempRight가 가르키는 두 개의 값을 변경해준다.
			if (tempLeft < tempRight) {
				int temp = arr[tempLeft];
				arr[tempLeft] = arr[tempRight];
				arr[tempRight] = temp;
			}
		}
		
		// tempRight는 계속 줄어들다가 결국 피봇보다 작은 값을 가르키게되며 while문을 빠져나온다.
		// tempLeft는 계속 늘어나다가 결국 피봇보다 큰 값을 가르키게되며 while문을 빠져나온다.
		// 피봇보다 작은 값이 왼쪽으로 가야 하므로 tempRight가 가르키는 값을 pivot과 변경을 해줘야 한다. (pivot을 가장 왼쪽으로 잡았기 떄문)
		arr[left] = arr[tempRight];
		arr[tempRight] = pivot;

		
		// 정렬 후 피봇보다 작은 값들을 다시 정렬해준다.
		if (left < tempRight - 1) {
			quickSort(arr, left, tempRight - 1);
		}
		// 정렬 후 피봇보다 큰 값들을 다시 정렬해준다.
		if (tempRight + 1 < right - 1) {
			quickSort(arr, tempRight + 1, right);
		}

		return;
	}
}
