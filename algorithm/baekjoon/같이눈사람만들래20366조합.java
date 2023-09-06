package Algorithm.algorithm.baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class 같이눈사람만들래20366조합 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		// 만들 수 있는 눈사람의 모든 키를 담을 리스트
		ArrayList<Snowman> list = new ArrayList<>();

		// 2개로 만들 수 있는 눈 사람의 모든 키를 담는다.
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				list.add(new Snowman(i, j, arr[i] + arr[j]));
			}
		}
		// 리스트를 눈사람의 키를 기준으로 내림차순한다.
		Collections.sort(list, new Comparator<Snowman>() {

			@Override
			public int compare(Snowman o1, Snowman o2) {
				// TODO Auto-generated method stub

				return o2.height - o1.height;
			}
		});
		
		// 최소를 구한다.
		int min = Math.abs((arr[3] + arr[2]) - (arr[1] - arr[0]));
		for (int i = 0; i < list.size() - 1; i++) {
			// 오름차순으로 정렬했기 때문에 현재 인덱스의 바로 뒤에 있는 눈사람만 보면 된다.
			Snowman olderSister = list.get(i);
			Snowman youngerSister = list.get(i + 1);
			// 만약 겹치는 부분이 없다면 최소값을 갱신해준다.
			if (!(olderSister.firstIndex == youngerSister.firstIndex
					|| olderSister.firstIndex == youngerSister.secondIndex
					|| olderSister.secondIndex == youngerSister.firstIndex
					|| olderSister.secondIndex == youngerSister.secondIndex)) {
				min = Math.min(min, olderSister.height - youngerSister.height);
			}
			// 0이면 더 이상 작은 값은 나올 수 없으므로 break;
			if(min == 0) {
				break;
			}
		}
		System.out.println(min);
	}

	static class Snowman {
		int firstIndex;
		int secondIndex;
		int height;

		public Snowman(int firstIndex, int secondIndex, int height) {
			super();
			this.firstIndex = firstIndex;
			this.secondIndex = secondIndex;
			this.height = height;
		}

	}
}
