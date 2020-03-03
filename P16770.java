package baekjoon;

import java.io.*;
import java.util.*;
public class P16770 {
	public static void main(String[] args) throws IOException{
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(bfr.readLine());
		int N = Integer.parseInt(str.nextToken());
		int[] bucket_time = new int[1001];
		int max = 0;	
		for (int i=0; i<N; i++) {
			str = new StringTokenizer(bfr.readLine());
			for (int j = Integer.parseInt(str.nextToken()); j<=Integer.parseInt(str.nextToken()); j++) {
				bucket_time[j] +=Integer.parseInt(str.nextToken());
                max=Math.max(max,bucket_time[j]);
			}
		}
		System.out.println(max);
	}
}