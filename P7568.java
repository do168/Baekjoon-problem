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
		
		int N = Integer.parseInt(str.nextToken()); // N입력
		Integer[][] people = new Integer[N][2]; //[N][2]로 몸무게,키 배열 생성
		
		for (int i=0; i<N; i++) { // people배열에 순서대로 저장
			str = new StringTokenizer(bfr.readLine());
			people[i][0] = Integer.parseInt(str.nextToken());
			people[i][1] = Integer.parseInt(str.nextToken());
		}
		
		for (int i=0; i<N; i++) {
			int rank_tmp = 1; //덩치 랭크 초기값 1
			for (int j=0; j<N; j++) {
				
				if (people[i][0] < people[j][0] && people[i][1] < people[j][1]) { //자신보다 몸무게,키 모두 큰 사람이 있는 경우에만
					rank_tmp++; //자신의 덩치 랭크 한단계 낮게
				}
			}
			System.out.print(rank_tmp + " ");
		}
	}

}
