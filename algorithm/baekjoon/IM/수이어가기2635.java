package Algorithm.algorithm.baekjoon.IM;

import java.util.ArrayList;
import java.util.Scanner;

public class 수이어가기2635 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = n ; i > 0 ; i--) {
			ArrayList<Integer> tempList = new ArrayList<>();
			tempList.add(n);
			tempList.add(i);
			while(tempList.get(tempList.size()-1) >= 0) {
				int second = tempList.get(tempList.size()-1);
				int first = tempList.get(tempList.size()-2);
				tempList.add(first - second);
			}
			tempList.remove(tempList.size()-1);
			if(tempList.size() < list.size()) {
				break;
			}
			list = tempList;
		}
		System.out.println(list.size());
		for(int temp : list) {
			System.out.print(temp + " ");
		}
	}
}
