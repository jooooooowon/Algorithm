package algorithm.baekjoon;

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
			// 우선 제일 작은 숫자들이 제일 많이 더해지면 된다는 생각으로 접근을 하였다.
			// 제일 작은 숫자들을 얻기 위해서 제일 빨리 작은 수를 찾을 수 있는 우선순위 큐를 이용하자.
			PriorityQueue<Long> pQue= new PriorityQueue<>();

			st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < n ; i++) {
				pQue.offer(Long.parseLong(st.nextToken()));
			}
			
			long sum = 0;
			
			// 우선순위 큐에 마지막 값이 나올 때까지 매 순간 제일 작은 숫자 둘을 더해준다.
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
