package sasfy_algirithm_part.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class ProfessionalExcersize5684 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int testCase = 1; testCase <= test; testCase++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			Map<Integer, Integer>[] arr = new HashMap[n+1];
			for(int i = 0 ; i < n+1 ; i++) {
				arr[i] = new HashMap<>();
			}
			
			for(int i = 0 ; i < m ; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				Map<Integer, Integer> map = arr[s];
				map.put(e, c);
				arr[s] = map;
			}
			int min =Integer.MAX_VALUE;
			for(int i = 0 ; i < n ; i++) {
				min = Math.min(bfs(i,arr),min);
			}
			sb.append("#").append(testCase).append(" ").append(min).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static int bfs(int num, Map<Integer,Integer>[] arr) {
		
		Queue<Road> queue = new LinkedList<>();
		
		int[] countArr = new int[arr.length];
		boolean[] chk = new boolean[arr.length];
		Arrays.fill(countArr, Integer.MAX_VALUE);
		queue.offer(new Road(num, arr[num]));
		while(!queue.isEmpty()) {
			Road road = queue.poll();
			Map<Integer, Integer> map = road.map;
			chk[road.idx] = true;
			for(int idx : map.keySet()) {
				int temp = countArr[road.idx] + map.get(idx);
				if(!chk[idx] || countArr[idx] > temp) {
					countArr[idx] = temp;
					queue.offer(new Road(idx, arr[idx]));
				}
			}
		}
		return countArr[num];
	}
	
	static class Road{
		int idx;
		Map<Integer, Integer> map;
		
		public Road() {
		}
		
		public Road(int idx, Map<Integer, Integer> map) {
			this.idx = idx;
			this.map = map;
		}
		
	}
	
}
