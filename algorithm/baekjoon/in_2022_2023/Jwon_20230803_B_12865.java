package Algorithm.algorithm.baekjoon.in_2022_2023;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Jwon_20230803_B_12865 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		// ��ǰ�� ������ �� ���� �� ��Ȯ�� �𸣱� ������ list�� �ִ´�.
		// ��ǰ�� ���԰� ��ƿ �� �ִ� ���Ժ��� ũ�ٸ� ������ �� �ֱ� ����.
		ArrayList<BackPack> list = new ArrayList<>();
		int[] maxValArr = new int[k + 1];
		for (int i = 0; i < n; i++) {
			int w = sc.nextInt();
			int v = sc.nextInt();
			// ��ǰ�� ���԰� ��ƿ �� �ִ� ���Ժ��� ũ�ٸ� �����Ѵ�.
			if (w > k || v == 0) {
				continue;
			}
			list.add(new BackPack(w, v));
		}

		// ��ǰ���� ���� ������ �������� �����Ѵ�.
		// ��ǰ���� ���� ������ �������� �����ϴ� ���� :
		// ���԰� ���ſ� ��ǰ�� ���� ��� �� ���ſ� ��ǰ�� ��ġ�� ���� ���ִ� ������ ��ǰ���� �տ� ���� ��ġ�� ���ؾ��ϴµ�
		// ���ſ� ��ǰ���� �ִ´ٸ� ���߿� ������ ��ǰ���� ���� �� ���� ����� ���������� ��ġ�� �κ��� ���� �� �ִ�.
		// ���� �켱 ���ſ� ��ǰ���� ������ �� ������ ��ǰ�� ���ζ�� ��� �����ϸ� �����Ѵ�.
		// �Ŀ� ���ſ� ��ǰ�� ���� �� ������ ��ǰ��� ä���� ������ �ִ� ������ ��ġ�� ���Ͽ� �� ū ��ġ�� ã�Ƴ���.
		Collections.sort(list, new Comparator<BackPack>() {

			@Override
			public int compare(BackPack o1, BackPack o2) {
				return o1.w - o2.w;
			}
		});

		// ��� ��ǰ���� Ȯ���Ѵ�.
		for (BackPack backPack : list) {
			int w = backPack.w;
			// �� ��ǰ�� �־��� �� ����� ���Կ� ���� ���ο� ��ġ���� ���� array.
			// �̷��� �ϴ� ���� : ��ġ�� ���� �� �� �̻� �� �� �ֱ� ����.
			// ���� ��� ���԰� 3�̰� ��ƿ �� �ִ� ������ ���԰� 9��� 4~9���� 3�� �־��� ��ġ�� ���� ��� �������� ������ �ƿ� �ٸ� �迭�� �־��ش�.
			int[] tempArr = new int[k+1];
			// tempArr = maxValArr�� ���� �ʴ� ����:
			// �ּҰ��� ���������� ������ �ǹ̰� ��������. ��, maxValArr�� ���� ����Ǹ� �ּҰ��� ���� ������ tempArr�� ���� ������ �ȴ�.
			for(int i = 0 ; i < k+1 ; i++) {
				tempArr[i] = maxValArr[i];
			}
			
			for (int j = 0; w + j < k + 1; j++) {
				// ���� ����ִ� ��ġ���� ���ο� ��ġ�� �� ũ�ٸ� �������ش�.
				if (tempArr[w + j] < backPack.v + maxValArr[j]) {
					tempArr[w + j] = backPack.v + maxValArr[j];
				} else {
					// �̰� ���� ���ϱ� �ʿ䰡 ����...
					tempArr[w + j] = maxValArr[w + j];
				}
				
			}
			
			// maxValArr�� ���� ���� �迭�� �����Ѵ�.
			for(int i = 0 ; i < k+1 ; i++) {
				maxValArr[i] = tempArr[i];
			}
		}
		System.out.println(maxValArr[k]);
	}

	static class BackPack {
		int w;
		int v;

		public BackPack(int w, int v) {
			this.w = w;
			this.v = v;
		}

	}
}
