package Algorithm.sasfy_algirithm_part.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWProblemSolve1225 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st ;
		StringBuilder sb = new StringBuilder();
		for(int testCase= 0 ; testCase < 10 ; testCase++) {
			int test = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			Queue<Integer> queue = new LinkedList<Integer>();
			for(int i = 0 ; i < 8 ; i++) {
				queue.offer(Integer.parseInt(st.nextToken()));
			}
			int num = 0;
			while(queue.peek() > 0) {
				int temp = queue.poll() - ++num;
				if(temp <= 0) {
					queue.offer(0);
					break;
				}
				queue.offer(temp);
				if(num == 5) {
					num = 0;
				}
			}
			sb.append("#").append(test).append(" ");
			while(!queue.isEmpty()) {
				sb.append(queue.poll()).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
