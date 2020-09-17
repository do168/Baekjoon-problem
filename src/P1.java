//import java.io.*;
//import java.math.*;
//import java.security.*;
//import java.text.*;
//import java.util.*;
//import java.util.concurrent.*;
//import java.util.function.*;
//import java.util.regex.*;
//import java.util.stream.*;
//import static java.util.stream.Collectors.joining;
//import static java.util.stream.Collectors.toList;
//
//
////
//class Result {
//    static boolean[] isRoot;
//    static int[] root;
//    static int[] rank;
//    static int[] count;
//    static int find(int x) {
//        if (root[x] == x) {
//            return x;
//        } else {
//            return root[x] = find(root[x]);
//        }
//    }
//    static void union(int x, int y){
//        x = find(x);
//        y = find(y);
//
//        if(x == y)
//            return;
//
//        if(rank[x] < rank[y]) {
//            root[x] = y;
//            isRoot[x] = false;
//            count[y]+=count[x];
//        } else {
//            root[y] = x;
//            isRoot[y] = false;
//            count[x]+=count[y];
//            if(rank[x] == rank[y])
//                rank[x]++;
//        }
//    }
//    public static int connectedSum(int n, List<String> edges) {
//        root = new int[n + 1];
//        isRoot = new boolean[n+1];
//        Arrays.fill(isRoot, true);
//        for (int i = 1; i <= n; i++) {
//            root[i] = i;
//        }
//        rank = new int[n + 1];
//        for (int i = 1; i <= n; i++) {
//            rank[i] = 0 ;
//        }
//
//        count = new int[n+1];
//        Arrays.fill(count, 1);
//
//
//        for(int i=1; i<=edges.size(); i++) {
//            String[] related = edges.get(i).split("");
//            union(Integer.parseInt(related[0]), Integer.parseInt(related[2]));
//        }
//        int cnt = n;
//        int answer = 0;
//        for(int i=1; i<=n; i++) {
//            if(rank[i]>=1&&isRoot[i]) {
//                int num = (int) Math.ceil(Math.sqrt(count[i]));
//                answer+=num;
//                cnt-=count[i];
//            }
//        }
//        answer+=cnt;
//        return answer;
//
//    }
//
//}
//
//public class Solution {
//    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int n = Integer.parseInt(bufferedReader.readLine().trim());
//
//        int edgesCount = Integer.parseInt(bufferedReader.readLine().trim());
//
//        List<String> edges = IntStream.range(0, edgesCount).mapToObj(i -> {
//            try {
//                return bufferedReader.readLine();
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//        })
//                .collect(toList());
//
//        int result = Result.connectedSum(n, edges);
//
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
//    }
//}