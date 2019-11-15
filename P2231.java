package Fighting;
import java.util.*;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
public class P2231 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(bfr.readLine());
		
		int N = Integer.parseInt(str.nextToken());
		
		for (int i=1; i<N; i++) {
			int answer = i;
			int sum_tmp = answer;
			while (answer>0) {
				int pos_n = answer%10;
				sum_tmp += pos_n;
				answer/=10;
			}
			if (sum_tmp == N) {
				System.out.println(i);
				return;
			}
		}
		System.out.println("0");
	}

}
