package Algorithm.sasfy_algirithm_part.d2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백만개의정수정렬병합정렬 {
	static int[] arr = new int[1000000];
	static int[] sortedArr = new int[1000000];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("./input.txt")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < 1000000; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		mergeSort(0, 999999);
		System.out.println(arr[500000]);
		
//		int[] arr = {4,3,5,6,7,3,5,6,3,45,6,7,5,7,8,5,4,3,4,5,6,7,8,8,9,4,56,7,567,4,345,234,1,4346,45};
//		mergeSort(arr, 0, arr.length - 1);
//		System.out.println(Arrays.toString(arr));
	}

	private static void mergeSort(int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			mergeSort(left, mid);
			mergeSort(mid + 1, right);
			merge(left, mid, right);
		}
		return;
	}

	private static void merge(int left, int mid, int right) {
		int idx = left;
		int tempLeft = left;
		int tempRight = mid + 1;
		while (tempLeft <= mid && tempRight <= right) {
			if(arr[tempLeft] <= arr[tempRight]) {
				sortedArr[idx++] = arr[tempLeft++];
			}else {
				sortedArr[idx++] = arr[tempRight++];
			}
		}
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
