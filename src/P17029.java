package BAEKJOON;
import java.io.*;
import java.util.*;
public class P17029 {
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(bfr.readLine());
		int N = Integer.parseInt(str.nextToken());
		ArrayList<Node1> animal = new ArrayList<Node1>(); 
		for (int i=0; i<N; i++) {
			str = new StringTokenizer(bfr.readLine());
			ArrayList<String> char_tmp = new ArrayList<String>();
			String name_tmp = str.nextToken();
			int have_char = Integer.parseInt(str.nextToken());
			for(int j=0; j<have_char; j++) {
				char_tmp.add(str.nextToken());
			}
			animal.add(new Node1(name_tmp, char_tmp));
		}
		int answer=0;
		for (int i=0; i<N; i++) {
			Node1 a = animal.get(i);
			for (int j=i+1; j<N; j++) {
				int temp = 0;
				Node1 b = animal.get(j);
				for(int k=0; k<a.charac.size(); k++) {
					for (int z = 0; z<b.charac.size(); z++) {
						if(a.charac.get(k).equals(b.charac.get(z))) temp++;
					}
				}
				answer = Math.max(answer, temp);
			}
		}
		System.out.println(answer+1);
	}

}
class Node1 {
	String name;
	ArrayList<String> charac = new ArrayList<String>();
	Node1() {
		this.name = null;
		this.charac = null;
	}
	Node1(String name, ArrayList<String> charac) {
		this.name = name;
		this.charac = charac;
	}
}