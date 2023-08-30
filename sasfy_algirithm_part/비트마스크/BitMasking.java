package Algorithm.sasfy_algirithm_part.비트마스크;

public class BitMasking {
	public static void main(String[] args) {
		char[] arr = {'A','B','C','D','E'};
		
		for (int i = 0; i < (1 << arr.length); i++) {
			if(Integer.bitCount(i) == 3) {
				for (int j = 0; j < arr.length; j++) {
					if ((i & (1 << j)) > 0) {
						System.out.print(arr[j] + " ");
					}
				}
				System.out.println();
			}
		}
	}
}
