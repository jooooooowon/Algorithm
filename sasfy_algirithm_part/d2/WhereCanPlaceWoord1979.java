package Algorithm.sasfy_algirithm_part.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class WhereCanPlaceWoord1979 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int testCase = 1; testCase <= test; testCase++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			// ���� ���� ���̸� �ʰ����� �� ���� ������ �ϱ� ���ؼ� ó�� �迭�� ũ�⸦ n + 2�� �������־���.
			boolean[][] chk1 = new boolean[n + 2][n + 2];
			boolean[][] chk2 = new boolean[n + 2][n + 2];
			int[][] arr1 = new int[n + 2][n + 2];
			int[][] arr2 = new int[n + 2][n + 2];
			for (int i = 1; i < n + 1; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j < n + 1; j++) {
					if (st.nextToken().equals("1")) {
						// �� ���� ���� �� ���� ���η� �ؾ� ������ ��� ���� �ٲ㼭 �������־���.
						chk1[i][j] = true;
						chk2[j][i] = true;
					}
				}
			}

			for (int i = 1; i < n + 1; i++) {
				for (int j = 1; j < n + 1; j++) {
					// ���� ���� ����̶��
					if (chk1[i][j]) {
						// �ٷ� ���� �ִ� ���� + 1 ���ش�.
						arr1[i][j] = arr1[i][j - 1] + 1;
						int temp = j;
						while (chk1[i][temp]) {
							// �׸��� ���� ���� �̿��� �� ���� ��� �������ش�.
							arr1[i][temp] = arr1[i][j];
							temp--;
						}

					}
					
					// ��� ���� �ٲ� �迭�� �Ȱ��� ���ش�.
					if (chk2[i][j]) {
						arr2[i][j] = arr2[i][j - 1] + 1;
						int temp = j;
						while (chk2[i][temp]) {
							arr2[i][temp] = arr2[i][j];
							temp--;
						}
					}
				}
			}

			int count = 0;
			for (int i = 1; i < n + 1; i++) {
				for (int j = 1; j < n + 1; j++) {
					// k�� ���� ���� ������ ���ش�.
					if (arr1[i][j] == k) {
						count++;
					}
					if (arr2[i][j] == k) {
						count++;
					}
				}
			}
			
			// k������ ���ڿ��� k�� �������ִ� ��� �������� �� �� �ְ�,
			// k�� ������ �̿��� ����������� ��� k���� ���̸� ������ �����Ƿ�
			// ���� k������ ���ڿ��� ���� �� �ִ� ������ ��� k�� ������ k�� ���� ���� ����.
			count /= k;

			sb.append("#").append(testCase).append(" ").append(count).append("\n");
		}
		System.out.println(sb.toString());
	}

}
