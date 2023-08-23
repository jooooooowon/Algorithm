package Algorithm.sasfy_algirithm_part.d5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWProblemSolve1248공통조상 {
	static int[] arr;
	static int[] count;
	static boolean[] chk;
	static int[][] nodeList;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int testCase = 1; testCase <= test ; testCase++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
		
			arr = new int[v+1];
			count = new int[v+1];
			chk = new boolean[v+1];
			Arrays.fill(count, 1);
			count[0] = 0;
			
			nodeList = new int[v+1][2];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < e ; i++) {
				int parent = Integer.parseInt(st.nextToken());
				int child = Integer.parseInt(st.nextToken());
				arr[child] = parent;
				if(nodeList[parent][0] != 0) {
					nodeList[parent][1] = child;
				}else {
					nodeList[parent][0] = child;
				}
			}
			find(node1);
			int node = find(node2);
			int count = findCount(node);
			
			sb.append("#").append(testCase).append(" ").append(node).append(" ").append(count).append("\n");
		}
		System.out.println(sb.toString());
	}
	private static int findCount(int node) {
		if(node == 0) {
			return 0;
		}
		int left = findCount(nodeList[node][0]);
		int right = findCount(nodeList[node][1]);
		return count[node] += left + right;
	}
	private static int find(int node) {
		if(node == 0 || chk[node]) {
			return node;
		}
		chk[node] = true;
		return find(arr[node]);
	}
}
