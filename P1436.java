package Fighting;
import java.util.*;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
public class P1436 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		int N = Integer.valueOf(str.nextToken());
		
		int answer = 0;
		long tmp =665;
		while (answer<N) {
			tmp++;
			String temp = tmp+"";
			if (temp.contains("666")) {
				answer++;
			}
			
		}
		System.out.println(tmp);
	}

}
