package Algorithm.algorithm.programmers.in_2022_2023;

import java.util.Collections;
import java.util.PriorityQueue;

public class Jwon_20230807_p_minerals {
	public static int solution(int[] picks, String[] materials) {
		int answer = 0;
		
		// �� ����� ���� ���߿� � �����̱��� Ķ �� �ִ� �� Ȯ���ϱ� �������� ��� �Դ�.
		int pickCount = 0;
		
		for(int i = 0 ; i < 3 ; i++) {
			pickCount += picks[i];
		}
		
		
		// ���� 5���� ������ �� 5���� �������� ��ġ�� �߽����� �����ϱ�� �ߴ�.
		// 5���� ���� �� �� ���� ū ��ġ�� ������ ������ ������ ���� ��� ��̷� ĳ�� �ȴٴ� ������ �ߴ�.
		// ���� �� ���� ��ġ�� �־��ش�.
		// �ָ��ϰ� ���̾� 3 ö 2 �� 1�� �ϸ� ��ġ�� ���� ���� ������ �������� ��ġ�� ū ���� ��ġ�� ħ���ϱ� ������ ���� 100 10 1�� �������ش�.
		// ���ظ� ���� �ϱ� ���� ����) ö 5���� 10�̰� 3���� �������� ���̾Ʒ� ������ �� �ִ�. �׷��� 100 10 1���� �ϸ� ���� ħ���� �� �����Ƿ� 100 10 1�� ��������.
		// 5�� �� ������ ��ġ�� ���� ū �ͺ��� �̱����� �켱���� ť, ���� ��� ��̺��� ���� ��̱��� �̿�����.
		PriorityQueue<Integer> pQue = new PriorityQueue<>(Collections.reverseOrder());
		
		// 5���� ���� ���� i(������)�� 5���� �����ش�.
		for(int i = 0 ; i < materials.length; i += 5) {
			// ���� �� �̻� �����̵��� ��Ƶ� ����� �� �ִ� ����� ������ ���ٸ� �� �̻� �����̸� ���� �ʿ䰡 �����Ƿ� break
			if(pickCount == 0) {
				break;
			}
			
			// ������ ������ ��ġ.
			int value = 0;
			// �ټ����� �׸��� �������� ������ �ѱ��� ���� ������ ��ġ�� �����ش�.
			for(int j = i ; j < i + 5 && j < materials.length; j++) {
				if(materials[j].equals("diamond")) {
					value += 100;
				}else if(materials[j].equals("iron")) {
					value += 10;
				}else if(materials[j].equals("stone")) {
					value += 1;
				}
			}
			
			// �������� ������ ��ġ�� �־��ش�.
			pQue.offer(value);
			// �� �������� ������ Ķ ��� ��� ������ �ϳ� ���ش�.
			pickCount--;
		}
		
		// ���� ��̰� ������ �������� ���Ƽ� ���� ���� ����Ͽ� ��ġ�� ū �������� ������ ���� ��� ��̺��� ����Ͽ� ĳ��!
		for(int i = 0 ; i < 3 ; i++) {
			// ���� ����� ������ ������ ĳ�� �ȵǱ⿡ picks[i] > 0
			// ����� ������ ���� �־ �� �̻� Ķ �������� ������ ���ٸ� �Ƿε��� �ö󰡸� �ȵǴϱ� !pQue.isEmpty()
			while(picks[i] > 0 && !pQue.isEmpty()) {
				// ���� ������ ���� �� ���� ū ��ġ�� ����
				int value = pQue.poll();
				// ���� ��� ��� �ϳ� ���⿡ ���� ���̳ʽ�
				picks[i]--;
				
				if(i == 0) {
					// ���� ���̾� ��̶��
					answer += value / 100;
					value %= 100;
					
					answer += value / 10;
					value %= 10;
					
					answer += value ;
				}else if(i == 1) {
					// ���� ö ��̶��
					answer += (value / 100) * 5;
					value %= 100;
					
					answer += value / 10;
					value %= 10;
					
					answer += value ;
					
				}else if(i == 2) {
					// ���� ������ ��̶��
					answer += (value / 100) * 25;
					value %= 100;
					
					answer += (value / 10) * 5;
					value %= 10;
					
					answer += value ;
				}
			}
		}
		
		// ��!
		return answer;
	}
	
	
	
	
	
	public static void main(String[] args) {
		// ���� �������� ���α׷��ӽ� ���� ���� ���...
		String[] minerals = {"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"};
		int[] picks ={1,3,2}; 
		System.out.println(solution(picks,minerals));

		String[] minerals2 = {"diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond"};
		int[] picks2 ={0,1,1}; 
		System.out.println(solution(picks2,minerals2));
		System.out.println(solution(new int[3], new String[3]));
		String[] minerals3 = {"diamond", "diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "diamond"};
		int[] picks3 ={1,1,1}; 
		System.out.println(solution(picks3,minerals3));
		String[] minerals4 = {"diamond", "diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "diamond"};
		int[] picks4 ={3,0,0}; 
		System.out.println(solution(picks4,minerals4));

	}
}
