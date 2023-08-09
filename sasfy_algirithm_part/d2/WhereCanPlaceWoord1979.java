package sasfy_algirithm_part.d2;

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

			// 가로 세로 길이를 초과했을 때 쉽게 구현을 하기 위해서 처음 배열의 크기를 n + 2로 지정해주었다.
			boolean[][] chk1 = new boolean[n + 2][n + 2];
			boolean[][] chk2 = new boolean[n + 2][n + 2];
			int[][] arr1 = new int[n + 2][n + 2];
			int[][] arr2 = new int[n + 2][n + 2];
			for (int i = 1; i < n + 1; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j < n + 1; j++) {
					if (st.nextToken().equals("1")) {
						// 한 번은 가로 한 번은 세로로 해야 됨으로 행과 열을 바꿔서 저장해주었다.
						chk1[i][j] = true;
						chk2[j][i] = true;
					}
				}
			}

			for (int i = 1; i < n + 1; i++) {
				for (int j = 1; j < n + 1; j++) {
					// 만약 현재 흰색이라면
					if (chk1[i][j]) {
						// 바로 전에 있는 값에 + 1 해준다.
						arr1[i][j] = arr1[i][j - 1] + 1;
						int temp = j;
						while (chk1[i][temp]) {
							// 그리고 현재 값을 이웃한 흰 색에 모두 저장해준다.
							arr1[i][temp] = arr1[i][j];
							temp--;
						}

					}
					
					// 행과 열이 바뀐 배열도 똑같이 해준다.
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
					// k와 같은 값의 갯수를 세준다.
					if (arr1[i][j] == k) {
						count++;
					}
					if (arr2[i][j] == k) {
						count++;
					}
				}
			}
			
			// k길이의 문자열은 k가 적혀져있는 흰색 바탕에만 들어갈 수 있고,
			// k가 적혀진 이웃한 흰색바탕들은 모두 k개의 길이를 가지고 있으므로
			// 실제 k길이의 문자열을 넣을 수 있는 갯수는 모든 k의 수에서 k를 나눈 값과 같다.
			count /= k;

			sb.append("#").append(testCase).append(" ").append(count).append("\n");
		}
		System.out.println(sb.toString());
	}

}
