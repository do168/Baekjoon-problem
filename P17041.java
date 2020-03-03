package baekjoon;
import java.util.*;

import java.io.*;
public class P17041 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(bfr.readLine());
		int N = Integer.parseInt(str.nextToken());
		ArrayList<Node> mile = new ArrayList<Node>();
		for (int i=0; i<N; i++) {
			str = new StringTokenizer(bfr.readLine());
			String lamp_temp = str.nextToken();
			int min_temp = Integer.parseInt(str.nextToken());
			int max_temp = Integer.parseInt(str.nextToken());
			mile.add(new Node(lamp_temp, min_temp, max_temp));
		}
		int a = -N*1000-1;
		int b = N*1000+1;
		
		for(int i=N-1; i>=0; i--) {
			Node temp = mile.get(i);
			switch(temp.lamp) {
			case "none" : {a = Math.max(a, temp.min); b = Math.min(b, temp.max); break;}
			case "on" : {a=Math.max(0, a-temp.max); b-=temp.min; break;}
			case "off" : {a+=temp.min; b+=temp.max; break;}
			}
		}
		System.out.println(a+" "+b);
		for(int i=0; i<N; i++) {
			Node temp = mile.get(i);
			switch(temp.lamp) {
			case "none" : {a = Math.max(a, temp.min); b = Math.min(b, temp.max); break;}
			case "off" : {a=Math.max(0, a-temp.max); b-=temp.min; break;}
			case "on" : {a+=temp.min; b+=temp.max; break;}
			}
		}
		System.out.println(a+" "+b);
		
		
	}

}
class Node{
	String lamp;
	int min;
	int max;
	Node() {
		this.lamp=null;
		this.min=0;
		this.max=0;
		
	}
	
	Node(String lamp, int min, int max) {
		this.lamp = lamp;
		this.min = min;
		this.max= max;
	}
}