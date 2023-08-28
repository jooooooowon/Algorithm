package Algorithm.algorithm.baekjoon.IM;

import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

public class 창고다각형2304 {
	public static void main(String[] args) {
		int[] arr = new int[1001];
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		PriorityQueue<Integer> pQue = new PriorityQueue<>();
		int max = 0;
		int midIdx = 0;
		for (int i = 0; i < n; i++) {
			int l = sc.nextInt();
			int h = sc.nextInt();
			arr[l] = h;
			pQue.offer(l);
			if (max < h) {
				max = h;
				midIdx = l;
			}
		}
		Stack<Integer> stack = new Stack<>();
		stack.push(pQue.poll());

		for (int i = 1; i < n; i++) {
			int idx = pQue.poll();
			if (idx > midIdx) {
				while (arr[idx] > arr[stack.peek()]) {
					stack.pop();
				}
				stack.push(idx);
			} else {
				if (arr[idx] >= arr[stack.peek()]) {
					stack.push(idx);
				}
			}
		}

		int area = max;
		int right = stack.pop();
		while (!stack.isEmpty()) {
			int left = stack.pop();
			int width = right - left;
			int height = Math.min(arr[right], arr[left]);
			right = left;

			area += width * height;
		}
		System.out.println(area);

	}
}
