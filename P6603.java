package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class P6603 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str;
		while(true) {
			List<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
			str = new StringTokenizer(bfr.readLine());
			int n = Integer.parseInt(str.nextToken());
			if(n==0)
				break;
			int[] ar = new int[n];
			for(int i=0; i<n; i++) {
				ar[i] = Integer.parseInt(str.nextToken());
			}
 			Arrays.sort(ar);
			for(int i=0; i<(1<<n); i++) {
				if(Integer.bitCount(i)==6) {
					ArrayList<Integer> ar_candi = new ArrayList<Integer>();
					for(int j=0; j<n; j++) {
						if(((1<<j)&i)>0) {
							ar_candi.add(ar[j]);
						}
					}
					list.add(ar_candi);
				}
			}
			Collections.sort(list, new Comparator<ArrayList<Integer>>() {
				@Override
				public int compare(ArrayList<Integer> ar1, ArrayList<Integer> ar2) {
					
					
					return ar1.get(0).compareTo(ar2.get(0));
				}

			});
			for(ArrayList<Integer> ar_temp : list) {
				for(int i : ar_temp) {
					System.out.print(i + " ");
				}
				System.out.println();
			}
		}
	}

}
