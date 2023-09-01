package Algorithm.sasfy_algirithm_part.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 규영이와인영이의카드게임6808 {
	static ArrayList<Integer> gList;
	static ArrayList<Integer> iList;
	static int[] perm;
	static boolean[] chk;
	static int win;
	static int lose;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int testCase = 1; testCase <= test; testCase++) {
			st = new StringTokenizer(br.readLine());
			perm = new int[9];
			chk = new boolean[9];
			win = 0;
			lose = 0;
			gList = new ArrayList<>();
			iList = new ArrayList<>();
			for(int i = 1 ; i <= 18 ; i++) {
				iList.add(i);
			}
			for(int i = 0 ; i < 9 ; i++) {
				int num = Integer.parseInt(st.nextToken());
				gList.add(num);
				iList.remove(iList.indexOf(num));
			}
			find(0); 
			sb.append("#").append(testCase).append(" ").append(win).append(" ").append(lose).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	private static void find(int count) {
		if(count == 9) {
			int gNum = 0;
			int iNum = 0;
			for(int i = 0 ; i < 9 ; i++) {
				int tempG = gList.get(i);
				int tempI = perm[i];
				if(tempG > tempI) {
					gNum += tempG + tempI;
				}else {
					iNum += tempG + tempI;
				}
			}
			if(gNum > iNum) {
				win++;
			}else {
				lose++;
			}
			return ;
		}
		
		for(int i = 0 ; i < 9 ; i++) {
			if(!chk[i]) {
				chk[i] = true;
				perm[count] = iList.get(i);
				find(count+1);
				chk[i] = false;
			}
		}
	}
}
