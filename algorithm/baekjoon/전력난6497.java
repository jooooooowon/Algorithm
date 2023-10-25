package Algorithm.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 전력난6497 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		ArrayList<Edge>[] list = new ArrayList[m];
		for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int len = Integer.parseInt(st.nextToken());
			list[from].add(new Edge(to, len));
			list[to].add(new Edge(from, len));
		}
		boolean[] visited = new boolean[m];
		int[] countArr = new int[m];
		int lastIndex = 0;
		Arrays.fill(countArr, Integer.MAX_VALUE);
		countArr[0] = 0;
		PriorityQueue<Edge> pque = new PriorityQueue<>();
		for(Edge next : list[0]) {
			pque.offer(next);
		}
		visited[0] = true;
		while (!pque.isEmpty()) {
			Edge now = pque.poll();
			lastIndex = now.to;
			for (Edge next : list[now.to]) {
				if(!visited[next.to]){
					
				}
			}

		}
		br.readLine();
	}

	static class Edge implements Comparable<Edge> {
		int to;
		int len;

		public Edge(int to, int len) {
			super();
			this.to = to;
			this.len = len;
		}

		@Override
		public String toString() {
			return "Edge [to=" + to + ", len=" + len + "]";
		}

		@Override
		public int compareTo(Edge edge) {
			return this.len - edge.len;
		}

	}
}
