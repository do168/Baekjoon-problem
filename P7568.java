package Fighting;
import java.util.*;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
public class P7568 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(bfr.readLine());
		
		int N = Integer.parseInt(str.nextToken()); // N�Է�
		Integer[][] people = new Integer[N][2]; //[N][2]�� ������,Ű �迭 ����
		
		for (int i=0; i<N; i++) { // people�迭�� ������� ����
			str = new StringTokenizer(bfr.readLine());
			people[i][0] = Integer.parseInt(str.nextToken());
			people[i][1] = Integer.parseInt(str.nextToken());
		}
		
		for (int i=0; i<N; i++) {
			int rank_tmp = 1; //��ġ ��ũ �ʱⰪ 1
			for (int j=0; j<N; j++) {
				
				if (people[i][0] < people[j][0] && people[i][1] < people[j][1]) { //�ڽź��� ������,Ű ��� ū ����� �ִ� ��쿡��
					rank_tmp++; //�ڽ��� ��ġ ��ũ �Ѵܰ� ����
				}
			}
			System.out.print(rank_tmp + " ");
		}
	}

}
