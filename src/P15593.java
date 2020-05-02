package BAEKJOON;

import java.util.*;
import java.io.*;
public class P15593 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(bfr.readLine());
		int N = Integer.parseInt(str.nextToken());
		int[][] lg = new int[N][2];
		for (int i=0; i<N; i++) {
			str = new StringTokenizer(bfr.readLine());
			lg[i][0] = Integer.parseInt(str.nextToken());
			lg[i][1] = Integer.parseInt(str.nextToken());
		}
		
		int max=0;
		for (int i=0; i<N; i++) {
			int[] tmp = new int[1000];
			for (int j=0; j<N; j++) {
				if(i!=j) {
					for (int z = lg[j][0]; z<lg[j][1]; z++) {
						tmp[z] = 1;
					}
				}
			}
			int compare=0;
			for (int j=0; j<1000; j++) {
				if(tmp[j]==1) compare++;
			}
			max = Math.max(max, compare);
		}
        System.out.println(max);
	}

}
