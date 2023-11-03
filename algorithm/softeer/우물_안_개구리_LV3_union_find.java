package Algorithm.algorithm.softeer;

import java.io.*;
import java.util.*;

public class 우물_안_개구리_LV3_union_find {

	static int[] people;
	static int[] weight;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		people = new int[n + 1];
		for (int i = 1; i < people.length; i++) {
			people[i] = i;
		}
		weight = new int[n + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < weight.length; i++) {
			weight[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			// 더 큰놈이 있다면 더 큰놈을 루트 노드로 만들어준다.
			if (weight[start] > weight[end]) {
				union(end, find(start));
			} else {
				union(start, find(end));
			}
		}
		int result = 0;
		// 만약 가장 큰 무게가 자신의 무게와 같다면 result++;
		for (int i = 1; i < people.length; i++) {
			if (weight[i] == weight[find(i)]) {
				result++;
			}
		}
		System.out.println(Arrays.toString(people));
		System.out.println(Arrays.toString(weight));
		System.out.println(result);
	}

	public static void union(int a, int b) {
		int start = find(a);
		int end = find(b);
		people[start] = end;
	}

	public static int find(int num) {
		if (people[num] == num) {
			return num;
		}
		return people[num] = find(people[num]);
	}

}
