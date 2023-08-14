package Algorithm.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class FileMerge13975Baekjoon {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		StringTokenizer st ;
		StringBuilder sb = new StringBuilder();
		for(int testCase = 0 ; testCase < test ; testCase++) {
			int n = Integer.parseInt(br.readLine());
			// �켱 ���� ���� ���ڵ��� ���� ���� �������� �ȴٴ� �������� ������ �Ͽ���.
			// ���� ���� ���ڵ��� ��� ���ؼ� ���� ���� ���� ���� ã�� �� �ִ� �켱���� ť�� �̿�����.
			PriorityQueue<Long> pQue= new PriorityQueue<>();

			st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < n ; i++) {
				pQue.offer(Long.parseLong(st.nextToken()));
			}
			
			long sum = 0;
			
			// �켱���� ť�� ������ ���� ���� ������ �� ���� ���� ���� ���� ���� �����ش�.
			while(pQue.size() != 1) {
				long temp = pQue.poll();
				temp += pQue.poll();
				
				sum += temp;
				pQue.offer(temp);
			}
			sb.append(sum).append("\n");
		}
		
		System.out.println(sb.toString());
		
	}
}
