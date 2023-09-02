package Algorithm.sasfy_algirithm_part.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWProblemSolve2112보호필름3 {
	static int d;
	static int w;
	static int k;
	static int minCount;
	static int[][] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int testCase = 1; testCase <= test; testCase++) {
			st = new StringTokenizer(br.readLine());
			d = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			arr = new int[d][w];
			for (int i = 0; i < d; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			minCount = d;
			for (int bit = 0; bit < 1 << d; bit++) {
				if (Integer.bitCount(bit) < minCount) {
					ArrayList<Integer> list = new ArrayList<>();
					for (int i = 0; i < d; i++) {
						if ((bit & 1 << i) > 0) {
							list.add(i);
						}
					}
					if(make(list, 0, Integer.bitCount(bit), new int[d])) {
						minCount = Integer.bitCount(bit);
					}
				}
			}
			sb.append("#").append(testCase).append(" ").append(minCount).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static boolean make(ArrayList<Integer> list, int index, int size, int[] tempArr) {
//		System.out.println("list : " + list + " index : " + index + " size : " + size);
		if(index == size) {
			if(chk(tempArr,list)) {
				return true;
			}
			return false;
		}
		boolean tf = false;
		int[] tempA = new int[d];
		for(int i = 0 ; i < d; i++) {
			tempA[i] = tempArr[i];
		}
		tf = make(list, index + 1, size, tempA);
		if(tf) {
			return true;
		}
		int[] tempB = new int[d];
		for(int i = 0 ; i < d; i++) {
			tempB[i] = tempArr[i];
		}
		tempB[list.get(index)] = 1;
		tf = make(list, index + 1, size, tempB);
		if(tf) {
			return true;
		}
		return false;
	}

	private static boolean chk(int[] tempArr, ArrayList<Integer> list) {
		int[][] temp = new int[d][w];
		for (int i = 0; i < d; i++) {
			for (int j = 0; j < w; j++) {
				temp[i][j] = arr[i][j];
			}
		}
		for(int index : list) {
			Arrays.fill(temp[index],tempArr[index]);
		}
		int[] chkList = new int[w];
		Arrays.fill(chkList, 1);
		boolean[] chkResult = new boolean[w];
		for (int i = 1; i < d; i++) {
			for (int j = 0; j < w; j++) {
				if (temp[i - 1][j] == temp[i][j]) {
					chkList[j]++;
				} else {
					chkList[j] = 1;
				}
				if (chkList[j] >= k) {
					chkResult[j] = true;
				}
			}
		}
		for (int i = 0; i < w; i++) {
			if (!chkResult[i]) {
				return false;
			}
		}
		return true;
	}

}
