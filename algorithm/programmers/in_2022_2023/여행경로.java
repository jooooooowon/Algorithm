package Algorithm.algorithm.programmers.in_2022_2023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class 여행경로 {
	static ArrayList<String> answerList;
	static HashMap<String, Integer> count;
	static HashMap<String, ArrayList<Boolean>> visited;
	static int len;

	public static String[] solution(String[][] tickets) {
		HashMap<String, ArrayList<String>> map = new HashMap<>();
		len = tickets.length + 1;
		// 각 출발지에 도착지를 저장해준다.
		for (int i = 0; i < tickets.length; i++) {
			if (!map.containsKey(tickets[i][0])) {
				map.put(tickets[i][0], new ArrayList<>());
			}
			ArrayList<String> list = map.get(tickets[i][0]);
			list.add(tickets[i][1]);
			map.put(tickets[i][0], list);
		}
		count = new HashMap<>();
		visited = new HashMap<>();
		for (String key : map.keySet()) {
			ArrayList<String> temp = map.get(key);
			count.put(key, temp.size());
			ArrayList<Boolean> boolTemp = new ArrayList<>();
			for (int i = 0; i < temp.size(); i++) {
				boolTemp.add(false);
			}
			visited.put(key, boolTemp);
			Collections.sort(temp);
			map.put(key, temp);
		}
		answerList = new ArrayList<>();
		answerList.add("ICN");
		dfs("ICN", map);
		Object[] temp = answerList.toArray();
		String[] answer = new String[temp.length];
		for (int i = 0; i < temp.length; i++) {
			answer[i] = (String) temp[i];
		}
		return answer;
	}

	private static boolean dfs(String str, HashMap<String, ArrayList<String>> map) {
		ArrayList<String> list = map.get(str);
		if (list == null || list.isEmpty() || count.get(str) == 0) {
			for (String key : count.keySet()) {
				if (count.get(key) != 0) {
					return false;
				}
			}
			return true;
		}
		for (int i = 0; i < list.size(); i++) {
			ArrayList<Boolean> boolTemp = visited.get(str);
			if (!boolTemp.get(i)) {
				boolTemp.set(i, true);
				String next = list.get(i);
				count.put(str, count.get(str) - 1);
				answerList.add(next);
				boolean tf = dfs(next, map);
				if (tf) {
					return true;
				}
				answerList.remove(answerList.size() - 1);
				count.put(str, count.get(str) + 1);
				boolTemp.set(i, false);
			}
		}
		return false;
	}

	public static void main(String[] args) {
		String[][] arr = { { "ICN", "JFK" }, { "HND", "IAD" }, { "JFK", "HND" } };
		System.out.println(Arrays.toString(solution(arr)));
		String[][] arr1 = { { "ICN", "SFO" }, { "ICN", "ATL" }, { "SFO", "ATL" }, { "ATL", "ICN" }, { "ATL", "SFO" } };
		System.out.println(Arrays.toString(solution(arr1)));
	}
}
