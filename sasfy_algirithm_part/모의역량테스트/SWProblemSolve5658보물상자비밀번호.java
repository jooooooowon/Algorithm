package Algorithm.sasfy_algirithm_part.모의역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWProblemSolve5658보물상자비밀번호 {
	static HashSet<Long> set;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int testCase = 1; testCase <= test; testCase++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			String str = br.readLine();
			Queue<Character> queue = new LinkedList<Character>();
			for (int i = 0; i < str.length(); i++) {
				queue.offer(str.charAt(i));
			}

			set = new HashSet<>();
			for (int i = 0; i < n / 4; i++) {
				make10(queue, n);
				queue.offer(queue.poll());
			}
			Object[] tempArr = set.toArray();
			Long[] result = new Long[tempArr.length];
			for (int i = 0; i < tempArr.length; i++) {
				result[i] = (Long) tempArr[i];
			}
			Arrays.sort(result,Collections.reverseOrder());
			sb.append("#").append(testCase).append(" ").append(result[k-1]).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void make10(Queue<Character> queue, int size) {
		Character[] arr = new Character[size];
		Object[] tempArr = queue.toArray();
		for (int i = 0; i < size; i++) {
			arr[i] = (Character) tempArr[i];
		}
		for (int i = size - 1; i >= 0; i -= size / 4) {
			int power = 0;
			long num = 0;
			for (int j = 0; j < size / 4; j++) {
				long temp = 0;
				if (arr[i - j] >= '0' && arr[i - j] <= '9') {
					temp = (long) (arr[i - j] - '0');
				} else {
					temp = (long) (arr[i - j] - 'A' + 10);
				}
				temp *= Math.pow(16, power++);
				num += temp;
			}
			set.add(num);
		}

	}
}
