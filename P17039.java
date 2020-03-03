package baekjoon;
import java.util.*;
import java.io.*;
public class P17039 {
	static long a,b,c;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		int min=0;
		long max=0;
		String[] cow_loc = bfr.readLine().split(" ");
		
			a = Long.parseLong(cow_loc[0]);
			b = Long.parseLong(cow_loc[1]);
			c = Long.parseLong(cow_loc[2]);
		
		if(a>b) swap(a,b);
		if(b>c) swap(b,c);
		if(a>b) swap(a,b);
		
		if(a+2==c) {min=0;}
		else if(b==a+2 || c==b+2) {min=1;}
		else min=2;
		max = Math.max(b-a, c-b)-1;
		System.out.println(min);
		System.out.println(max);
	}
	static void swap(long cow_loc, long cow_loc2) {
		long temp=cow_loc;
		cow_loc= cow_loc2;
		cow_loc2 = temp;
	}
}

