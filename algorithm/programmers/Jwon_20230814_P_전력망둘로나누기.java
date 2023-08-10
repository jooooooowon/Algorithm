package algorithm.programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Jwon_20230814_P_전력망둘로나누기 {
	
	
	public static int solution(int n, int[][] wires) {
		int answer = n;
		
		ArrayList<Integer>[] arr = new ArrayList[n+1];
		
		for(int i = 0 ; i < arr.length ; i++) {
			arr[i] = new ArrayList<>();
		}
		
		
		for(int i = 0 ; i < wires.length ; i++) {
			int start = wires[i][0];
			int end = wires[i][1];
			ArrayList<Integer> list = arr[start];
			list.add(end);
			arr[start] = list;

			list = arr[end];
			list.add(start);
			arr[end] = list;
		}
		
		for(int start = 1 ; start < arr.length ; start++) {
			for(int end = 0 ; end < arr[start].size() ; end++) {
				int count = cut(start,end,arr);
				answer = Math.min(answer, count);
//				System.out.println(" start : " + start
//						+ " end : " + end
//						+ " count : " + count
//						+ " answer : " + answer);
			}
		}
		
		
		return answer;
	}
	
	public static int cut(int start, int end, ArrayList<Integer>[] arr) {
		ArrayList<Integer> list1 = arr[start];
		int removeNum = list1.remove(end);
//		System.out.print("removeNum : " + removeNum);
		arr[start] = list1;

		ArrayList<Integer> list2 = arr[removeNum];
		list2.remove(list2.indexOf(start));
		arr[removeNum] = list2;
		
		int result = find(arr);
		
		list1.add(removeNum);
		arr[start] = list1;

		list2.add(start);
		arr[removeNum] = list2;
		
		return result;
	}

	public static int find(ArrayList<Integer>[] arr) {
		
		boolean[] chk = new boolean[arr.length];
		Queue<Integer> que = new LinkedList<>();
		
		que.offer(1);
		
		while(!que.isEmpty()) {
			int tempStart = que.poll();
			chk[tempStart] = true;
			for(int end : arr[tempStart]) {
				if(!chk[end])
					que.offer(end);
			}
		}
		
		int trueNum = 0;
		int falseNum = 0;
		for(int i = 1 ; i < chk.length; i++) {
			if(chk[i]) {
//				System.out.print(" o");
				trueNum++;
			}else {
//				System.out.print(" x");
				falseNum++;
			}
		}
		
		
		return Math.abs(trueNum - falseNum);
	}
	
	
	public static void main(String[] args) {
		int n = 8 ;
		int[][] arr1 = {{1, 2},{1, 3},{3, 4},{3, 5},{5, 6},{5, 7},{7, 8}};
		System.out.println(solution(n,arr1));
		
		System.out.println("--------------------------------------");
		System.out.println("--------------------------------------");
		System.out.println("--------------------------------------");
		n = 7 ;
		int[][] arr2 = 	{{1, 2}, {2, 7}, {3, 7}, {3, 4}, {4, 5}, {6, 7}};
		System.out.println(solution(n,arr2));

		System.out.println("--------------------------------------");
		System.out.println("--------------------------------------");
		System.out.println("--------------------------------------");
		n = 9 ;
		int[][] arr3 = 	{{1, 2}, {2, 3}, {1, 4}, {1, 5}, {1, 6}, {1, 7}, {1, 8}, {1, 9}};
		System.out.println(solution(n,arr3));
		
	}
}
