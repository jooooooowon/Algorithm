package Algorithm.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최단경로1753 {
	static int[] distanceArr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine());
		ArrayList<Edge>[] arr = new ArrayList[v + 1];
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int distance = Integer.parseInt(st.nextToken());
			if (arr[from] == null) {
				arr[from] = new ArrayList<>();
			}
			arr[from].add(new Edge(to, distance));
		}

		boolean[] chk = new boolean[v + 1];
		distanceArr = new int[v + 1];
		
		// 다익스트라를 위한 INF 넣기.
		Arrays.fill(distanceArr, Integer.MAX_VALUE);
		// 시작점은 길이가 0
		distanceArr[start] = 0;
		PriorityQueue<Edge> pQueue = new PriorityQueue<>();
		// 시작점을 가르키는 간선을 처음에 넣고 시작.
		pQueue.offer(new Edge(start, 0));
		while (!pQueue.isEmpty()) {
			Edge now = pQueue.poll();
			// 이미 방문되어 있는 친구면 무시.
			if (chk[now.to]) {
				continue;
			}
			// 방문 체크.
			chk[now.to] = true;
			if (arr[now.to] != null) {
				for (Edge next : arr[now.to]) {
					// 다음에 볼 친구가 방문되어 있으면 무시.
					if (chk[next.to]) {
						continue;
					}
					
					// 지금까지의 길이와 그 다음 길이를 더해준 값이 이미 저장되어 있는 값보다 작으면 queue에 넣기
					// priorityQueue에서 다음 노드로 갈 길이 중 가장 짧은 것을 우선으로 해야하므로
					// 현재까지의 길이에 간선 길이를 더해서 queue에 넣어준다.
					next.distance += distanceArr[now.to];
					if (distanceArr[next.to] > next.distance) {
						distanceArr[next.to] = next.distance;
						pQueue.offer(next);
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < distanceArr.length; i++) {
			if(distanceArr[i] == Integer.MAX_VALUE) {
				sb.append("INF");
			}else {
				sb.append(distanceArr[i]);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	static class Edge implements Comparable<Edge> {
		int to;
		int distance;

		public Edge(int to, int distance) {
			super();
			this.to = to;
			this.distance = distance;
		}

		// 누적된 길이 비교.
		// 길이가 더 짧은 것을 먼저 해야한다.
		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return this.distance - o.distance;
		}

	}
}
