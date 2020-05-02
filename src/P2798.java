package BAEKJOON;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;
public class P2798 {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer str = new StringTokenizer(bfr.readLine());
	    
		int N = Integer.parseInt(str.nextToken());
		int M = Integer.parseInt(str.nextToken());
		Integer[] cards = new Integer[N];
		str = new StringTokenizer(bfr.readLine());
		for (int i=0; i<N; i++) {
			  cards[i] = Integer.parseInt(str.nextToken());
		}
		int max = 0;
		for (int i=0; i<N-2; i++) {
			for (int j=i+1; j<N-1; j++) {
				for (int k=j+1; k<N; k++) {
					int tmp_max = cards[i]+cards[j]+cards[k];
					if (tmp_max <=M && tmp_max>max) 
						max = tmp_max;
				}
			}
		}
		System.out.println(max);
	}
}
