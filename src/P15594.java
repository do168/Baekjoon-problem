package BAEKJOON;
import java.io.*;
import java.util.*;
public class P15594 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(bfr.readLine());
		int n = Integer.parseInt(str.nextToken());
		int[] cows = new int[n];
		int tmp = 0;
		int tmp_a=0;
		while(tmp<n) {
			str = new StringTokenizer(bfr.readLine());
			int temp = Integer.parseInt(str.nextToken());
			if(tmp_a==0) {cows[tmp_a] = temp; tmp_a++;}
			else {
				
				if(temp != cows[tmp_a-1]) { cows[tmp_a] = temp; tmp_a++;} 
			}
			tmp++;
		}
		int answer=0;
		
		for (int i=tmp_a-1; i>0; i--) {
			if (cows[i]<cows[i-1]) {
				int tmp_b = cows[i-1];
				cows[i-1] = cows[i];
				cows[i] = tmp_b;
				answer++;
			}
		}
		for (int i=0; i<tmp_a-1; i++) {
			if( cows[i]>cows[i+1]) {
				cows[i+1] = cows[i];
				answer++;
			}
		}
		System.out.println(answer);
	}

}
