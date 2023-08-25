package Algorithm.algorithm.baekjoon.IM;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 종이자르기2628 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int w = sc.nextInt();
		int h = sc.nextInt();
		int n = sc.nextInt();
		ArrayList<Integer> cutArrRow = new ArrayList<>();
		ArrayList<Integer> cutArrCol = new ArrayList<>();
		cutArrRow.add(0);
		cutArrCol.add(0);
		cutArrRow.add(h);
		cutArrCol.add(w);
		
		for (int cut = 0; cut < n; cut++) {
			int how = sc.nextInt();
			int num = sc.nextInt();
			if (how == 0) {
				cutArrRow.add(num);
			} else {
				cutArrCol.add(num);
			}
		}

		Collections.sort(cutArrRow);
		Collections.sort(cutArrCol);
		
		int max = 0;
		for(int i = 0 ; i < cutArrRow.size()-1; i++) {
			int tempRow = cutArrRow.get(i+1) - cutArrRow.get(i);
			for(int j = 0 ; j < cutArrCol.size()-1; j++) {
				int tempCol = cutArrCol.get(j+1) - cutArrCol.get(j);
				max = Math.max(max, tempRow * tempCol);
			}
		}
		
		System.out.println(max);

	}
}
