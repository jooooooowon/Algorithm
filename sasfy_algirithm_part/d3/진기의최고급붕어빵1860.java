package Algorithm.sasfy_algirithm_part.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class 진기의최고급붕어빵1860 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test = Integer.parseInt(br.readLine());
		StringTokenizer st ;
		StringBuilder sb = new StringBuilder();
		for(int testCase = 1; testCase <= test ; testCase++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			// 예약자 중 
			PriorityQueue<Integer> pQue = new PriorityQueue<>();
			for(int i = 0 ; i < n ; i++) {
				pQue.offer(Integer.parseInt(st.nextToken()));
			}
			Queue<Integer> que = new LinkedList<Integer>();
			int time = 0;
			boolean tf = true;
			while(!pQue.isEmpty()) {
				time += m;
				for(int i = 0 ; i < k ; i++) {
					que.offer(time);
				}
				while(!que.isEmpty() && !pQue.isEmpty()) {
					int bread = que.poll();
					int customer = pQue.poll();
					if(bread > customer) {
						tf = false;
						break;
					}
				}
				if(!tf) {
					break;
				}
			}
			sb.append("#").append(testCase).append(" ");
			if(tf) {
				sb.append("Possible");
			}else {
				sb.append("Impossible");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
