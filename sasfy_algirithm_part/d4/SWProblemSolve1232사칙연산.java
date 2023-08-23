package Algorithm.sasfy_algirithm_part.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWProblemSolve1232사칙연산 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int test = 1; test <= 10; test++) {
			int n = Integer.parseInt(br.readLine());
			Node[] arr = new Node[n + 1];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				int idx = Integer.parseInt(st.nextToken());
				String str = st.nextToken();
				Node node = new Node(str);
				if(st.hasMoreTokens()) {
					int left = Integer.parseInt(st.nextToken());
					int right = Integer.parseInt(st.nextToken());
					node.left = left;
					node.right = right;
				}
				arr[idx] = node;
			}
			sb.append("#").append(test).append(" ");
			sb.append(postOrder(1, arr, n)).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static class Node{
		int left;
		int right;
		String data;

		public Node(String data) {
			this.data = data;
		}
		
	}
	
	private static int postOrder(int idx, Node[] arr, int n) {
		Node node = arr[idx];
		if (node.data.charAt(0) >= 42 && node.data.charAt(0) <= 47) {
			int left = postOrder(node.left, arr, n);
			int right = postOrder(node.right, arr, n);
			int result = 0;
			if (node.data.equals("/")) {
				result = left / right;
			} else if (node.data.equals("+")) {
				result = left + right;
			} else if (node.data.equals("-")) {
				result = left - right;
			} else if (node.data.equals("*")) {
				result = left * right;
			}
			return result;
		}
		return Integer.parseInt(node.data);
	}
}
