package Algorithm.sasfy_algirithm_part.d2;

import java.io.IOException;
import java.util.Arrays;

public class 백만개의정수정렬병합정렬 {
	static int[] arr = {4,3,5,6,7,3,5,6,3,45,6,7,5,7,8,5,4,3,4,5,6,7,8,8,9,4,56,7,567,4,345,234,1,4346,45};
	static int[] sortedArr = new int[arr.length];
	public static void main(String[] args) throws IOException {
		mergeSort(0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

	private static void mergeSort(int left, int right) {
		// left가  right보다 작아야만 둘로 나눌 수 있다. 
		if (left < right) {
			int mid = (left + right) / 2;
			// left ~ mid까지
			mergeSort(left, mid);
			// mid ~ right까지
			mergeSort(mid + 1, right);
			
			// 두개의 정렬되어 있는 것들을 다시 병합하며 정렬한다.
			merge(left, mid, right);
		}
		return;
	}

	private static void merge(int left, int mid, int right) {
		int idx = left;
		int tempLeft = left;
		int tempRight = mid + 1;
		
		while (tempLeft <= mid && tempRight <= right) {
			// 오름차순을 하기 위해 더 작은 것들을 차례로 넣는다.
			if(arr[tempLeft] <= arr[tempRight]) {
				sortedArr[idx++] = arr[tempLeft++];
			}else {
				sortedArr[idx++] = arr[tempRight++];
			}
		}
		
		// 아직 남아있는 것들을 모두 넣는다.
		while(tempLeft <= mid) {
			sortedArr[idx++] = arr[tempLeft++];
		}
		while(tempRight <= right) {
			sortedArr[idx++] = arr[tempRight++];
		}
		for(int i = left; i <= right; i++) {
			arr[i] = sortedArr[i];
		}
		return ;
	}
}
