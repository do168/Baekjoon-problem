package BAEKJOON;
import java.util.*;
import java.io.*;
public class P15465 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(bfr.readLine());
		int N = Integer.valueOf(str.nextToken());
		
		ArrayList<Node> list = new ArrayList<Node>();
		int M = 0;
		int E = 0;
		int B = 0;
		int state = 0;
		int answer = 0;
		
		for (int i=0; i<N; i++) {
			str = new StringTokenizer(bfr.readLine());
			int day_temp = Integer.parseInt(str.nextToken());
			String name_temp = str.nextToken();
			String change_temp = str.nextToken();
			list.add(new Node(day_temp, name_temp, change_temp));
		}
		
		Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.day - o2.day;
            }
        });
		
		for (int i=0; i<N; i++) {
			Node n = list.get(i);
			switch(n.name) {
			case "Mildred" : {
				if(n.change.split("")[0].equals("+")) M+=Integer.parseInt(n.change.split("")[1]);
				else M-=Integer.parseInt(n.change.split("")[1]);
				break;
				}
			case "Elsie" : {
				if(n.change.split("")[0].equals("+")) E+=Integer.parseInt(n.change.split("")[1]);
				else E-=Integer.parseInt(n.change.split("")[1]);
				break;
				}
			case "Bessie" : {
				if(n.change.split("")[0].equals("+")) B+=Integer.parseInt(n.change.split("")[1]);
				else B-=Integer.parseInt(n.change.split("")[1]);
				break;
				}
			}
			if (state != display(M, E, B)) {
				state = display(M, E, B);
				answer++;
			}
		}
		System.out.println(answer);
	}
	static int display(int M, int E, int B) {
		if(M>E) {
			if(M>B) return 1;
			else if(M==B) return 2;
			else return 3;
		}
		else if (M==E) {
			if (M>B) return 4;
			else if(M==B) return 5;
			else return 3;
		}
		else {
			if(E>B) return 7;
			else if(E==B) return 8;
			else return 3;
		}
	}

}

class Node {
	int day;
	String name;
	String change;
	Node(int day, String name, String change) {
		this.day = day;
		this.name = name;
		this.change = change;
	}
}

