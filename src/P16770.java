package BAEKJOON;
import java.io.*;
import java.util.*;
public class P16770 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(bfr.readLine());
		int N = Integer.parseInt(str.nextToken());
		int[] bucket_time = new int[1001];
		int max = 0;
		
		for (int i=0; i<N; i++) {
			str = new StringTokenizer(bfr.readLine());
			int start = Integer.parseInt(str.nextToken());
			int end = Integer.parseInt(str.nextToken());	
			int count = Integer.parseInt(str.nextToken());
			for (int j = start; j<=end; j++) {
				bucket_time[j] +=count;
			}
		}
		for(int i=0;i<=1000;i++) {
			max = Math.max(max, bucket_time[i]);
		}
		System.out.println(max);
	}

}
