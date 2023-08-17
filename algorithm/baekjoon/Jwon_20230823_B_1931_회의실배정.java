package Algorithm.algorithm.baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Jwon_20230823_B_1931_회의실배정 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Meeting> list = new ArrayList<>();
		for(int i = 0 ; i < n ; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			list.add(new Meeting(start, end));
		}
		
		Collections.sort(list, new Comparator<Meeting>() {

			@Override
			public int compare(Meeting o1, Meeting o2) {
				// TODO Auto-generated method stub
				if(o1.end == o2.end) {
					return o1.start - o2.start;
				}
				return o1.end - o2.end;
			}
		});
		
		int lastEnd = 0;
		int count = 0;
		for(int i = 0 ; i < n ; i++) {
			Meeting temp = list.get(i);
			if(temp.start >= lastEnd) {
				count++;
				lastEnd = temp.end;
			}
		}
		System.out.println(count);
	}
	
	static class Meeting{
		int start;
		int end;
		public Meeting(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
}
