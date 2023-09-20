package Algorithm.sasfy_algirithm_part.모의역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWProblem하나로1251 {
	static int[] unionChk;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int testCase = 1; testCase <= test; testCase++) {
			int n = Integer.parseInt(br.readLine());
			Node[] nodes = new Node[n];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				nodes[i] = new Node();
				nodes[i].x = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				nodes[i].y = Integer.parseInt(st.nextToken());
			}
			double e = Double.parseDouble(br.readLine());
			PriorityQueue<Edge> pque = new PriorityQueue<>();
			for (int i = 0; i < n; i++) {
				for (int j = i + 1; j < n; j++) {
					Node tempNode1 = nodes[i];
					Node tempNode2 = nodes[j];
					double len = calLen(tempNode1, tempNode2);
					pque.offer(new Edge(i, j, len));
				}
			}
			unionChk = new int[n + 1];
			for (int i = 1; i <= n; i++) {
				unionChk[i] = i;
			}

			int count = 0;
			double len = 0;
			while (count != n - 1) {
				Edge edge = pque.poll();
				if (find(edge.fromIndex) != find(edge.toIndex)) {
					len += edge.len * e;
					makeUnion(edge.fromIndex, edge.toIndex);
					count++;
				}
			}
			sb.append("#").append(testCase).append(" ").append(Math.round(len)).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void makeUnion(int fromIndex, int toIndex) {
		int from = find(fromIndex);
		int to = find(toIndex);
		unionChk[from] = unionChk[to];
	}

	public static int find(int index) {
		if (unionChk[index] == index) {
			return index;
		}
		return unionChk[index] = find(unionChk[index]);
	}

	public static double calLen(Node node1, Node node2) {
		double tempY = Math.pow(node1.y - node2.y, 2);
		double tempX = Math.pow(node1.x - node2.x, 2);
		return tempY + tempX;
	}

	static class Node {
		int y;
		int x;
	}

	static class Edge implements Comparable<Edge> {
		int fromIndex;
		int toIndex;
		double len;

		public Edge(int fromIndex, int toIndex, double len) {
			super();
			this.fromIndex = fromIndex;
			this.toIndex = toIndex;
			this.len = len;
		}

		@Override
		public String toString() {
			return "Edge [fromIndex=" + fromIndex + ", toIndex=" + toIndex + ", len=" + len + "]";
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return (int) (this.len - o.len);
		}

	}
}
