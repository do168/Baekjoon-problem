package baekjoon;
import java.io.*;
import java.util.*;
public class P17049 {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(bfr.readLine());
		int N = Integer.parseInt(str.nextToken());
		int M = Integer.parseInt(str.nextToken());
		Graph gr = new Graph(N);
		for (int i=0; i<M; i++) {
			str = new StringTokenizer(bfr.readLine());
			int x = Integer.parseInt(str.nextToken());
			int y = Integer.parseInt(str.nextToken());
			gr.put(x, y);
		}
		ArrayList<Integer> pa = new ArrayList<Integer>();
		for(int i=1; i<=4; i++) {
			pa.add(i);
		}
		int[] answer = new int[N+1];
		for (int i=1; i<=N; i++) {
			ArrayList<Integer> temA = new ArrayList<Integer>();
			temA = (ArrayList<Integer>) pa.clone();
			for(int j=0; j<gr.getNode(i).size(); j++) {
				if(gr.getNode(i).get(j)!=null) { 
					int temp = answer[gr.getNode(i).get(j)];
					if(temp!=0) {
					temA.remove((Integer)(temp));
					}
				}
			}
			Collections.sort(temA);
			answer[i] = temA.get(0);
			System.out.print(temA.get(0));		
		}
	}
}
class Graph {
    private List<List<Integer>> graph;
    public Graph(int initSize) {
        this.graph = new ArrayList<>();
        for(int i = 0; i < initSize+1; i++) {
            graph.add(new ArrayList<>());
        }
    }
    public List<Integer> getNode(int x) {
        return this.graph.get(x);
    }
    public void put(int x, int y) {
        graph.get(x).add(y);
        graph.get(y).add(x);
    }
}