package BAEKJOON;
import java.util.*;
import java.io.*;
public class P17039 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		long[] cow_loc = new long[3];
		int min=0;
		int max=0;
		String[] cow_loc1 = bfr.readLine().split(" ");
		for(int i=0;i<3;i++) {
			cow_loc[i] = Long.parseLong(cow_loc1[i]);
		}
		long len1 = Math.abs(cow_loc[0]-cow_loc[1]);
		long len2 = Math.abs(cow_loc[1]-cow_loc[2]);
		boolean[] check = {len1<len2,
						   len1==len2,
						   len1>len2,
						   len1>2,
						   len1==2,
						   len1<2};
		if(check[4]) {
			if (check[0]) { min=1; max=2;}
			else if(check[1]) {min=1; max=2;}
			else {min=1; max=1;}
		}
		else if(check[3]) {
			if (check[0]) { min=2; max=2;}
			else if(check[1]) {min=2; max=2;}
			else {
				if(len2==2) {min=1; max=2;}
				else if(len2==1) {min=1; max=1;}
				else {min=2; max=2;}
			}
		}
		else {
			if(check[1]) {min=0; max=0;}
			else {
				if(len2==2) {min=1; max=1;}
				else {min=1; max=2;}
			}
		}
		System.out.println(min);
		System.out.println(max);
	}

}
