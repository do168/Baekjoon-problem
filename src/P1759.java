package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1759 {
	static int L;
	static int C;
	static String[] ar;
	static boolean[] isVisit;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bfr = new  BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(bfr.readLine());
		L = Integer.parseInt(str.nextToken());
		C = Integer.parseInt(str.nextToken());
		str = new StringTokenizer(bfr.readLine());
		ar = new String[C];
		isVisit = new boolean[C];
		for(int i=0; i<C; i++) {
			ar[i] = str.nextToken();
		}
		Arrays.sort(ar);
		
	}
	
	static void DFS(int index, int c_cnt, int v_cnt, int size) {
		for(int i=index; i<C; i++) {
			isVisit[i] = true;
//			DFS(i+1, c_cnt+1, )
		}
	}

}
