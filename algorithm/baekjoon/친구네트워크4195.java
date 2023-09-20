package Algorithm.algorithm.baekjoon;

import java.util.HashMap;
import java.util.Scanner;

public class 친구네트워크4195 {
	static HashMap<String, String> map;
	static HashMap<String, Integer> countMap;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for (int testCase = 0; testCase < test; testCase++) {
			map = new HashMap<>();
			countMap = new HashMap<>();
			int f = sc.nextInt();
			for (int i = 0; i < f; i++) {
				String friend1 = sc.next();
				String friend2 = sc.next();
				makeUnion(friend1, friend2);
				System.out.println(map.toString());
				System.out.println(countMap.get(map.get(friend1)));
			}
		}
	}

	private static void makeUnion(String friend1, String friend2) {
		if (!map.containsKey(friend1)) {
			map.put(friend1, friend1);
		}
		if (!map.containsKey(friend2)) {
			map.put(friend2, friend2);
		}
		String from = find(friend1,countMap.getOrDefault(friend1, 0));
		String to = find(friend2,countMap.getOrDefault(friend2, 0));
		map.put(from, map.get(to));
	}

	private static String find(String friend, int size) {
		if(!countMap.containsKey(friend)) {
			size++;
		}
		countMap.put(friend, size);
		if (map.get(friend).equals(friend)) {
			return friend;
		}
		map.put(friend, find(map.get(friend),size));
//		countMap.put(map.get(friend), countMap.getOrDefault(friend, 1));
		return map.get(friend);
	}
}
