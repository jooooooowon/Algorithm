package Algorithm.sasfy_algirithm_part.d6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWProblemSolve1267작업순서 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int testCase = 1; testCase <= 10; testCase++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			ArrayList<Integer>[] list = new ArrayList[v + 1];
			int[] findStart = new int[v + 1];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < e; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				findStart[to]++;
				if (list[from] == null) {
					list[from] = new ArrayList<Integer>();
				}
				list[from].add(to);
			}
			Queue<Integer> queue = new LinkedList<>();
			for (int i = 1; i < findStart.length; i++) {
				if (findStart[i] == 0) {
					queue.offer(i);
				}
			}
			sb.append("#").append(testCase).append(" ");
			while (!queue.isEmpty()) {
				int from = queue.poll();
				sb.append(from).append(" ");
				if (list[from] != null) {
					for (int next : list[from]) {
						findStart[next]--;
						if(findStart[next] == 0) {
							queue.offer(next);
						}
					}
				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
