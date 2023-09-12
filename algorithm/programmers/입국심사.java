package Algorithm.algorithm.programmers;

import java.util.Arrays;

public class 입국심사 {
	public long solution(int n, int[] times) {
		long answer = 0;
		Arrays.sort(times);
		long end = (long) n * (long) times[times.length - 1];
		long start = 1;

		while (start <= end) {
			long mid = (start + end) / 2;
			long count = 0;
			for (int i = 0; i < times.length; i++) {
				count += mid / times[i];
			}
			if (count >= n) {
				answer = mid;
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}

		return answer;
	}
}
