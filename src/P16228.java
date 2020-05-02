package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P16228 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(bfr.readLine());
		int N = Integer.parseInt(str.nextToken());
		int k = Integer.parseInt(str.nextToken());
		int[] compare = new int[k+1];
		str = new StringTokenizer(bfr.readLine());
		int[] isPossible = new int[N+1];
		for(int i=1; i<=N; i++) {
			isPossible[i] = Integer.parseInt(str.nextToken());
		}
		for(int i=1; i<=N; i++) {
			int temp = isPossible[i];
			for(int j=1; j<=k; j++) {
				if(compare[j]==0 || compare[j]<temp) {
					compare[j] = temp;
					break;
				}
				if(j==k && compare[j]>temp) {
					System.out.println("NO");
					return;
				}
			}
		}
		System.out.println("YES");
		
	}

}
