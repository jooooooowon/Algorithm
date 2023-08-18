package Algorithm.sasfy_algirithm_part.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWProblemSolve3499 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int testCase = 1; testCase <= test ; testCase++) {
			int len = Integer.parseInt(br.readLine());
			String[] arr = new String[len];
			st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < len ; i++) {
				arr[i] = st.nextToken();
			}
			Queue<String> leftQue = new LinkedList<String>();
			Queue<String> rightQue = new LinkedList<String>();
			for(int i = 0 ; i < len ; i++) {
				if(i <= (len - 1) / 2) {
					leftQue.offer(arr[i]);
				}else {
					rightQue.offer(arr[i]);
				}
			}
			Queue<String> shuffleQueue = new LinkedList<>();
			while(!leftQue.isEmpty()) {
				shuffleQueue.offer(leftQue.poll());
				if(!rightQue.isEmpty()) {
					shuffleQueue.offer(rightQue.poll());
				}
			}
			sb.append("#").append(testCase).append(" ");
			while(!shuffleQueue.isEmpty()) {
				sb.append(shuffleQueue.poll()).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
