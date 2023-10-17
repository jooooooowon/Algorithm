package Algorithm.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 장난감_조립_2637 {
	
	// 완성된 장난감을 계속 부품들로 쪼개고 각 count 배열에 몇 번 째 만들어진 제품의 갯수를 정해준다.
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		StringTokenizer st;
		// 각 노드와 간선을 이을 list
		ArrayList<Edge>[] arr = new ArrayList[n + 1];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new ArrayList<>();
		}
		// 현재 단계까지 오기 전 단계의 갯수를 저장할 배열.
		int[] chk = new int[n + 1];
		// 기본 부품을 찾기 위한 배열 기본 부품은 false 
		boolean[] parts = new boolean[n + 1];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int big = Integer.parseInt(st.nextToken());
			int small = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			// 완성된 장난감에서 작은 부품들로 쪼개기 때문에 big -> small로 간다.
			arr[big].add(new Edge(small, k));
			// small로 오기전 몇 개의 big들이 처리되는 단계가 있는 지 저장한다.
			chk[small]++;
			// 중간 부품이면 true
			parts[big] = true;
		}
		// 장난감 갯수들을 저장할 배열.
		int[] count = new int[n + 1];
		Queue<Integer> queue = new LinkedList<>();
		// 완성된 장난감은 하나이므로 1 저장.
		count[n] = 1;
		queue.offer(n);
		
		while (!queue.isEmpty()) {
			int now = queue.poll();
			// 만약 현재 장난감이 다른 부품들로 쪼개진다면..
			if (arr[now].size() > 0) {
				for (Edge next : arr[now]) {
					// 완성된 중간 부품을 한 개 만들 때의 갯수인 k에 중간 부품의 갯수를 곱해서
					// 더 낮은 단계의 중간 부품의 갯수를 저장한다.
					count[next.to] += next.k * count[now];
					// next.to의 부품을 쪼개기 전까지 필요한 단계들의 갯수를 하나 줄인다.
					chk[next.to]--;
					// 만약 더 이상 먼저해야할 단계가 없다면 비로소 확인한다.
					if (chk[next.to] == 0) {
						queue.offer(next.to);
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < parts.length; i++) {
			// false가 기본 부품이므로 기본 부품들의 갯수만 확인한다.
			if (!parts[i]) {
				sb.append(i).append(" ").append(count[i]).append("\n");
			}
		}
		System.out.println(sb.toString());
	}

	static class Edge {
		int to;
		int k;

		public Edge(int to, int k) {
			super();
			this.to = to;
			this.k = k;
		}

		@Override
		public String toString() {
			return "Edge [to=" + to + ", k=" + k + "]";
		}

	}
}
