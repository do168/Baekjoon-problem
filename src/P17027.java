package BAEKJOON;
import java.io.*;
import java.util.*;
public class P17027 {
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bfr =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(bfr.readLine());
		int N = Integer.parseInt(str.nextToken());
		int[] a = new int[N+1];
		int[] b = new int[N+1];
		int[] guess = new int[N+1];
		int max = 0;
		for (int i=1; i<=N; i++) {
			str = new StringTokenizer(bfr.readLine());
			a[i] = Integer.parseInt(str.nextToken());
			b[i] = Integer.parseInt(str.nextToken());
			guess[i] = Integer.parseInt(str.nextToken());
		}
		for (int i=1; i<=3; i++) {
			int sim = i;
			int max_tmp = 0;
			for (int j=1; j<=N; j++) {
				if(sim==a[j]) sim = b[j]; 
				else if(sim==b[j]) sim = a[j]; 
				if(sim==guess[j]) max_tmp++;
			}
			max = Math.max(max, max_tmp);
		}
		System.out.println(max);
	}
}
