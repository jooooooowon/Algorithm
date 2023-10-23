package Algorithm.algorithm.programmers;

import java.util.*;

public class Jwon_20231025_P_징검다리 {

	public int solution(int distance, int[] rocks, int n) {
		int answer = distance;
		Arrays.sort(rocks);
		int[] newRocks = new int[rocks.length + 2];
		newRocks[0] = 0;
		newRocks[newRocks.length - 1] = distance;
		for (int i = 0; i < rocks.length; i++) {
			newRocks[i + 1] = rocks[i];
		}

		int left = 1;
		int right = distance;
		while (left <= right) {
			int mid = (left + right) / 2;
			int temp = n;

			for (int i = 1, j = 0; i < newRocks.length; i++) {

				int tempDis = newRocks[i] - newRocks[j];

				while (tempDis < mid) {
					i++;
					temp--;
					if (i >= newRocks.length) {
						break;
					}
					tempDis = newRocks[i] - newRocks[j];
				}
				
				j = i;
			}

			if (temp >= 0) {
				left = mid + 1;
				answer = mid;
			} else if (temp < 0) {
				right = mid - 1;
			}
		}

		return answer;
	}
}
