package Algorithm.algorithm.baekjoon.in_2022_2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Jwon_20230807_B_1966_printQueue {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		StringTokenizer st ;
		for(int testCase = 0 ; testCase < test ; testCase++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			// index�� ���� queue
			Queue<Integer> queue = new LinkedList<>();
			// �߿䵵 ������ ���� ���� priority queue
			// Collections.reverseOrder()�� �̿��Ͽ� ū ���� �켱������ �д�.
			PriorityQueue<Integer> pQueue = new PriorityQueue<>(Collections.reverseOrder());
			st = new StringTokenizer(br.readLine());
			
			// queue���� ���� �ε����� �̿��Ͽ� ���� ���� �����ϱ� ���� arr
			int[] arr = new int[n];
			for(int i = 0 ; i < n ; i++) {
				int num = Integer.parseInt(st.nextToken());
				
				// �� ��°�� �ִ� ������ ���� arr�� �ִ´�.
				arr[i] = num;
				
				// �߿䵵 ������ �������� priority queue���� �߿䵵�� �ִ´�.
				pQueue.offer(num);
				
				// arr�� index�� �����ϱ� ���� index�� �ִ´�. ( �� ��° �迭�� �ִ� ���� �� Ȯ���ϰ� arr�� �����ϱ� ���� )
				queue.offer(i);
			}
			
			// �� ��°�� �ִ� ���� �� Ȯ��.
			int count = 0;
			while(!queue.isEmpty()) {
				// ���⼭�� ������ queue�� �ϳ��� ������ ������ count++
				count++;
				// ���� ���� �߿䵵�� ���� ���ڸ� max�� �ְ�
				int max = pQueue.poll();
				// queue�� �ִ� index�� idx�� �ְ�
				int idx = queue.poll();
				
				// ���� idx�� �ִ� ���ڰ� max�� ���� �� Ȯ���ϰ� �ٸ��ٸ� �� �������� �ְ� �� ���� ���� �̾Ƽ� Ȯ���Ѵ�.
				while(arr[idx] != max) {
					queue.offer(idx);
					idx = queue.poll();
				}
				
				// ���� ã�� �ʹ� index�� ���翡 idx�� ���� �� Ȯ���ϰ� ���ٸ� while�� ��.
				if(idx == m) {
					break;
				}
			}
			
			// ����.
			System.out.println(count);
			
		}
	}
}
