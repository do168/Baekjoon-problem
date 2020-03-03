package baekjoon;
import java.io.*;
import java.util.*;

public class P16769 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(bfr.readLine());
		int[] bucket1 = new int[11];
		int[] bucket2 = new int[11];
		boolean[] isbucket1 = new boolean[101];
		boolean[] isbucket2 = new boolean[101];
		int cnt_b1=0;
		int cnt_b2 = 0;
		ArrayList<Integer> spec = new ArrayList<Integer>();
		ArrayList<Integer> spec1 = new ArrayList<Integer>();
		ArrayList<Integer> spec2 = new ArrayList<Integer>();
		for (int i=1; i<=10; i++) {
			bucket1[i] = Integer.parseInt(str.nextToken());
			if(isbucket1[bucket1[i]]!=true) {cnt_b1++; spec1.add(bucket1[i]); isbucket1[bucket1[i]] = true;}
		}
		str = new StringTokenizer(bfr.readLine());
		for (int i=1; i<=10; i++) {
			bucket2[i] = Integer.parseInt(str.nextToken());
			if(isbucket2[bucket2[i]]!=true) {cnt_b2++; spec2.add(bucket2[i]);isbucket2[bucket2[i]] = true;}
		}
		
		for (int i=1; i<=10; i++) {
			for(int j=i+1;j<=10; j++) {
				int tue = bucket1[i];
				int wed = bucket2[i];
				int thu = bucket1[j];
				int fri = bucket2[j];
				int sum = (wed+fri)-(tue+thu);
				if(!spec.contains(sum) || spec.isEmpty()) spec.add(sum);
			}
		}
		for(int i=0; i<cnt_b1; i++) {
			for(int j =0; j<cnt_b2; j++) {
				int sum = spec2.get(j) - spec1.get(i);
				if(!spec.contains(sum)) spec.add(sum);
			}
		}
		System.out.println(spec.size()+1);
	}

}
